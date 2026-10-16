package org.lwjgl.opencl;

import org.lwjgl.system.Callback;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * LWJGL 2's CallbackUtil without its natives. LWJGL 2 passed a JNI global reference to the callback object as user_data
 * and called it from fixed C trampolines; here the callbacks are LWJGL 3 Callbacks, their own native functions, so
 * user_data is an ID in a Java table that keeps the object alive while native code may call it, as the global reference
 * did. The imported CL object model (CLContext and the CL10 code) uses the IDs unchanged.
 *
 * <p>LWJGL 2 deleted the reference of a one-shot callback (event, program, memory object destructor, native kernel) in
 * its trampoline after the call; the default invoke of those classes calls deleteGlobalRef instead.</p>
 *
 * <p>An LWJGL 3 Callback owns a native closure, which LWJGL 2's objects did not have. Once a callback object given to
 * createGlobalRef is unreachable (no table entry, no Java reference), its closure is freed on a later call here: native
 * code no longer calls it then, as LWJGL 2 allowed the object to be collected.
 * TODO(verify): a one-shot callback's closure freed while its last invocation is still returning to native code.</p>
 */
final class CallbackUtil {

	/** IDs away from small integers and typical pointers, so that LWJGL 3 user_data rarely matches one */
	private static final long ID_BASE = 0x4C57_4A47_0000_0000L;

	private static final Map<Long, Object> refs = new HashMap<Long, Object>();
	private static long nextId = ID_BASE;

	/** closures to free once their callback object is collected */
	private static final ReferenceQueue<Callback> collected = new ReferenceQueue<Callback>();
	private static final Map<Reference<Callback>, Long> closures = new HashMap<Reference<Callback>, Long>();
	/** callbacks that allocated their closure (markOwned) -> whether a phantom reference frees it */
	private static final Map<Callback, Boolean> owned = new WeakHashMap<Callback, Boolean>();

	private CallbackUtil() {
	}

	static long createGlobalRef(final Object obj) {
		if (obj == null) {
			return 0;
		}
		synchronized (refs) {
			freeCollected();
			long id = nextId++;
			refs.put(id, obj);
			if (obj instanceof Callback && Boolean.FALSE.equals(owned.get(obj))) {
				Callback callback = (Callback)obj;
				owned.put(callback, Boolean.TRUE);
				closures.put(new PhantomReference<Callback>(callback, collected), callback.address());
			}
			return id;
		}
	}

	static void deleteGlobalRef(final long ref) {
		synchronized (refs) {
			refs.remove(ref); // without other references, collectable now: its phantom reference frees the closure
			freeCollected();
		}
	}

	static void checkCallback(final int errcode, final long user_data) {
		if (errcode != 0x0 && user_data != 0) {
			deleteGlobalRef(user_data);
		}
	}

	/** The object for an ID, or null: what LWJGL 2's trampolines read through the global reference. */
	static Object getObject(final long ref) {
		synchronized (refs) {
			return refs.get(ref);
		}
	}

	/**
	 * Called by the CL callback classes' constructors that allocate a closure, not by those that wrap a native function
	 * the caller passed (CLContextCallback(long) and the create(...) wrappers), whose function is not ours to free.
	 */
	static void markOwned(final Callback callback) {
		synchronized (refs) {
			owned.put(callback, Boolean.FALSE);
		}
	}

	private static void freeCollected() {
		Reference<? extends Callback> ref;
		while ((ref = collected.poll()) != null) {
			Long address = closures.remove(ref);
			if (address != null) {
				Callback.free(address);
			}
		}
	}

}
