package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Into;
import org.lwjgl.BufferChecks;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

@Into(CL12.class)
final class CL12Fragment {

	/** DEVIATION(out-of-scope): as LWJGL 2 where the implementation lacked it (see CLPrintfCallback). */
	public static int clSetPrintfCallback(CLContext context, CLPrintfCallback pfn_notify) {
		throw new IllegalStateException("Function is not supported");
	}

	// clCompileProgram: LWJGL 2's natives made the header name array in C (@Indirect, @PointerArray); here in Java, with
	// LWJGL 2's checks and its template's Java. Strings as LWJGL 2 encoded them: their chars as bytes.

	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_header,
		ByteBuffer header_include_name, CLCompileProgramCallback pfn_notify) {
		BufferChecks.checkBuffer(input_header, 1);
		BufferChecks.checkDirect(header_include_name);
		BufferChecks.checkNullTerminated(header_include_name);
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return compile(program, device_list, options, input_header, stack.pointers(header_include_name), pfn_notify);
		}
	}

	/** The null-terminated header names one after the other, one per header. */
	public static int clCompileProgramMulti(CLProgram program, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_headers,
		ByteBuffer header_include_names, CLCompileProgramCallback pfn_notify) {
		BufferChecks.checkBuffer(input_headers, 1);
		BufferChecks.checkDirect(header_include_names);
		BufferChecks.checkNullTerminated(header_include_names, input_headers.remaining());
		try (MemoryStack stack = MemoryStack.stackPush()) {
			PointerBuffer names = stack.mallocPointer(input_headers.remaining());
			long address = MemoryUtil.memAddress(header_include_names);
			for (int i = 0; i < names.capacity(); i++) {
				names.put(i, address);
				while (MemoryUtil.memGetByte(address) != 0) {
					address++;
				}
				address++;
			}
			return compile(program, device_list, options, input_headers, names, pfn_notify);
		}
	}

	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_headers,
		ByteBuffer[] header_include_names, CLCompileProgramCallback pfn_notify) {
		BufferChecks.checkBuffer(input_headers, header_include_names.length);
		BufferChecks.checkArray(header_include_names, 1);
		for (ByteBuffer name : header_include_names) {
			BufferChecks.checkNullTerminated(name);
		}
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return compile(program, device_list, options, input_headers, stack.pointers(header_include_names), pfn_notify);
		}
	}

	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, CharSequence options, PointerBuffer input_header,
		CharSequence header_include_name, CLCompileProgramCallback pfn_notify) {
		BufferChecks.checkBuffer(input_header, 1);
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return compile(program, device_list, stack.ASCII(options, true), input_header,
				stack.pointers(stack.ASCII(header_include_name, true)), pfn_notify);
		}
	}

	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, CharSequence options, PointerBuffer input_header,
		CharSequence[] header_include_name, CLCompileProgramCallback pfn_notify) {
		BufferChecks.checkBuffer(input_header, 1);
		BufferChecks.checkArray(header_include_name);
		try (MemoryStack stack = MemoryStack.stackPush()) {
			PointerBuffer names = stack.mallocPointer(header_include_name.length);
			for (int i = 0; i < header_include_name.length; i++) {
				names.put(i, stack.ASCII(header_include_name[i], true));
			}
			return compile(program, device_list, stack.ASCII(options, true), input_header, names, pfn_notify);
		}
	}

	/** LWJGL 2's template's Java around the call. */
	private static int compile(CLProgram program, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_headers,
		PointerBuffer header_include_names, CLCompileProgramCallback pfn_notify) {
		BufferChecks.checkDirect(options);
		BufferChecks.checkNullTerminated(options);
		long user_data = CallbackUtil.createGlobalRef(pfn_notify);
		if (pfn_notify != null) pfn_notify.setContext(program.getParent());
		int __result = 0;
		try {
			__result = CL12.clCompileProgram(program.getPointer(), device_list, options, input_headers, header_include_names, pfn_notify,
				user_data);
			return __result;
		} finally {
			CallbackUtil.checkCallback(__result, user_data);
		}
	}

}
