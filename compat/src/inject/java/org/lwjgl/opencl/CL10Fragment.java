package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Into;
import com.koyomiji.lwjgl2w3.inject.Wrap;
import org.lwjgl.BufferChecks;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/** The CL10 parts of LWJGL 2's CL object model that bindings do not cover. */
@Into(CL10.class)
final class CL10Fragment {

	/**
	 * LWJGL 3's clGetPlatformIDs (the same signature as LWJGL 2's, so LWJGL 3's wins) plus LWJGL 2's side effect:
	 * the platforms it returns get CLPlatform wrappers, which CLPlatform.getPlatforms and the CL object model look up.
	 */
	@Wrap
	public static int clGetPlatformIDs(PointerBuffer platforms, IntBuffer num_platforms) {
		if (platforms != null && num_platforms == null) {
			num_platforms = APIUtil.getBufferInt();
		}
		int result = clGetPlatformIDs$lwjgl3(platforms, num_platforms);
		if (result == CL10.CL_SUCCESS && platforms != null) {
			CLPlatform.registerCLPlatforms(platforms, num_platforms);
		}
		return result;
	}

	static native int clGetPlatformIDs$lwjgl3(PointerBuffer platforms, IntBuffer num_platforms);

	// LWJGL 2's natives with the function pointer last, which InfoUtilFactory (imported) calls: LWJGL 3's take theirs
	// from the ICD

	static long nclCreateContext(long properties, int num_devices, long devices, long pfn_notify, long user_data, long errcode_ret,
		long function_pointer) {
		return CL10.nclCreateContext(properties, num_devices, devices, pfn_notify, user_data, errcode_ret);
	}

	static long nclCreateImage2D(long context, long flags, long image_format, long image_width, long image_height, long image_row_pitch,
		long host_ptr, long errcode_ret, long function_pointer) {
		return CL10.nclCreateImage2D(context, flags, image_format, image_width, image_height, image_row_pitch, host_ptr, errcode_ret);
	}

	static long nclCreateImage3D(long context, long flags, long image_format, long image_width, long image_height, long image_depth,
		long image_row_pitch, long image_slice_pitch, long host_ptr, long errcode_ret, long function_pointer) {
		return CL10.nclCreateImage3D(context, flags, image_format, image_width, image_height, image_depth, image_row_pitch,
			image_slice_pitch, host_ptr, errcode_ret);
	}

	// LWJGL 2's natives that made the function's arrays in C (@Indirect, @PointerArray, the mapped size): here in Java,
	// with LWJGL 2's checks and its template's Java

	public static CLProgram clCreateProgramWithSource(CLContext context, ByteBuffer string, IntBuffer errcode_ret) {
		BufferChecks.checkDirect(string);
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return new CLProgram(CL10.clCreateProgramWithSource(context.getPointer(), stack.pointers(string),
				stack.pointers(string.remaining()), errcode_ret), context);
		}
	}

	/** The strings one after the other in {@code strings}, as long as {@code lengths} says. */
	public static CLProgram clCreateProgramWithSource(CLContext context, ByteBuffer strings, PointerBuffer lengths, IntBuffer errcode_ret) {
		BufferChecks.checkBuffer(strings, APIUtil.getSize(lengths));
		BufferChecks.checkBuffer(lengths, 1);
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return new CLProgram(CL10.clCreateProgramWithSource(context.getPointer(), consecutive(stack, strings, lengths), lengths,
				errcode_ret), context);
		}
	}

	public static CLProgram clCreateProgramWithSource(CLContext context, ByteBuffer[] strings, IntBuffer errcode_ret) {
		BufferChecks.checkArray(strings, 1);
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return new CLProgram(CL10.clCreateProgramWithSource(context.getPointer(), stack.pointers(strings),
				lengths(stack, strings), errcode_ret), context);
		}
	}

	/** As LWJGL 2: the string's chars as bytes (APIUtil's encoding), not LWJGL 3's UTF-8 (DEVIATION(text-encoding)). */
	public static CLProgram clCreateProgramWithSource(CLContext context, CharSequence string, IntBuffer errcode_ret) {
		long address = APIUtil.getBuffer(string);
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return new CLProgram(CL10.clCreateProgramWithSource(context.getPointer(), stack.pointers(address),
				stack.pointers(string.length()), errcode_ret), context);
		}
	}

	public static CLProgram clCreateProgramWithSource(CLContext context, CharSequence[] strings, IntBuffer errcode_ret) {
		BufferChecks.checkArray(strings);
		long address = APIUtil.getBuffer(strings);
		try (MemoryStack stack = MemoryStack.stackPush()) {
			PointerBuffer lengths = stack.mallocPointer(strings.length);
			for (int i = 0; i < strings.length; i++) {
				lengths.put(i, strings[i].length());
			}
			PointerBuffer pointers = stack.mallocPointer(strings.length);
			for (int i = 0; i < strings.length; i++) {
				pointers.put(i, address);
				address += strings[i].length();
			}
			return new CLProgram(CL10.clCreateProgramWithSource(context.getPointer(), pointers, lengths, errcode_ret), context);
		}
	}

	public static CLProgram clCreateProgramWithBinary(CLContext context, CLDevice device, ByteBuffer binary, IntBuffer binary_status,
		IntBuffer errcode_ret) {
		BufferChecks.checkDirect(binary);
		BufferChecks.checkBuffer(binary_status, 1);
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return new CLProgram(CL10.clCreateProgramWithBinary(context.getPointer(), stack.pointers(device.getPointer()), binary,
				binary_status, errcode_ret), context);
		}
	}

	/** The binaries one after the other in {@code binaries}, as long as {@code lengths} says. */
	public static CLProgram clCreateProgramWithBinary(CLContext context, PointerBuffer device_list, PointerBuffer lengths, ByteBuffer binaries,
		IntBuffer binary_status, IntBuffer errcode_ret) {
		BufferChecks.checkBuffer(device_list, 1);
		BufferChecks.checkBuffer(lengths, device_list.remaining());
		BufferChecks.checkBuffer(binaries, APIUtil.getSize(lengths));
		BufferChecks.checkBuffer(binary_status, device_list.remaining());
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return new CLProgram(CL10.clCreateProgramWithBinary(context.getPointer(), device_list, lengths,
				consecutive(stack, binaries, lengths), binary_status, errcode_ret), context);
		}
	}

	public static CLProgram clCreateProgramWithBinary(CLContext context, PointerBuffer device_list, ByteBuffer[] binaries,
		IntBuffer binary_status, IntBuffer errcode_ret) {
		BufferChecks.checkBuffer(device_list, binaries.length);
		BufferChecks.checkArray(binaries, 1);
		BufferChecks.checkBuffer(binary_status, binaries.length);
		return new CLProgram(CL10.clCreateProgramWithBinary(context.getPointer(), device_list, binaries, binary_status, errcode_ret),
			context);
	}

	/** CL_PROGRAM_BINARIES into {@code param_value}, one after the other, as long as {@code sizes} says. */
	public static int clGetProgramInfo(CLProgram program, PointerBuffer sizes, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		BufferChecks.checkBuffer(sizes, 1);
		BufferChecks.checkBuffer(param_value, APIUtil.getSize(sizes));
		if (param_value_size_ret != null) {
			BufferChecks.checkBuffer(param_value_size_ret, 1);
		}
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return CL10.clGetProgramInfo(program.getPointer(), CL10.CL_PROGRAM_BINARIES, consecutive(stack, param_value, sizes),
				param_value_size_ret);
		}
	}

	/** CL_PROGRAM_BINARIES into one buffer per device. */
	public static int clGetProgramInfo(CLProgram program, ByteBuffer[] param_value, PointerBuffer param_value_size_ret) {
		BufferChecks.checkArray(param_value);
		if (param_value_size_ret != null) {
			BufferChecks.checkBuffer(param_value_size_ret, 1);
		}
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return CL10.clGetProgramInfo(program.getPointer(), CL10.CL_PROGRAM_BINARIES, stack.pointers(param_value),
				param_value_size_ret);
		}
	}

	/** LWJGL 2's cl_image_format array as its bytes: LWJGL 3's CLImageFormat.Buffer at the same address. */
	public static int clGetSupportedImageFormats(CLContext context, long flags, int image_type, ByteBuffer image_formats,
		IntBuffer num_image_formats) {
		if (image_formats != null) {
			BufferChecks.checkDirect(image_formats);
		}
		if (num_image_formats != null) {
			BufferChecks.checkBuffer(num_image_formats, 1);
		}
		CLImageFormat.Buffer formats = image_formats == null ? null
			: CLImageFormat.create(MemoryUtil.memAddress(image_formats), image_formats.remaining() / (2 * 4));
		return CL10.clGetSupportedImageFormats(context.getPointer(), flags, image_type, formats, num_image_formats);
	}

	public static ByteBuffer clEnqueueMapBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_map, long map_flags, long offset,
		long size, PointerBuffer event_wait_list, PointerBuffer event, IntBuffer errcode_ret) {
		ByteBuffer __result = CL10.clEnqueueMapBuffer(command_queue.getPointer(), buffer.getPointer(), blocking_map != 0, map_flags, offset,
			size, event_wait_list, event, errcode_ret, null);
		if (__result != null) command_queue.registerCLEvent(event);
		return __result;
	}

	/**
	 * As LWJGL 2, the mapped buffer as large as LWJGL 2's extcl_CalculateImageSize made it from the pitches the call returns
	 * (LWJGL 3's asks the image for its CL_MEM_SIZE): so through the raw entry point, after LWJGL 2's checks.
	 */
	public static ByteBuffer clEnqueueMapImage(CLCommandQueue command_queue, CLMem image, int blocking_map, long map_flags,
		PointerBuffer origin, PointerBuffer region, PointerBuffer image_row_pitch, PointerBuffer image_slice_pitch,
		PointerBuffer event_wait_list, PointerBuffer event, IntBuffer errcode_ret) {
		BufferChecks.checkBuffer(origin, 3);
		BufferChecks.checkBuffer(region, 3);
		BufferChecks.checkBuffer(image_row_pitch, 1);
		if (image_slice_pitch != null) BufferChecks.checkBuffer(image_slice_pitch, 1);
		if (event_wait_list != null) BufferChecks.checkDirect(event_wait_list);
		if (event != null) BufferChecks.checkBuffer(event, 1);
		if (errcode_ret != null) BufferChecks.checkBuffer(errcode_ret, 1);
		long address = CL10.nclEnqueueMapImage(command_queue.getPointer(), image.getPointer(), blocking_map, map_flags,
			MemoryUtil.memAddress(origin), MemoryUtil.memAddress(region), MemoryUtil.memAddress(image_row_pitch),
			MemoryUtil.memAddressSafe(image_slice_pitch), event_wait_list == null ? 0 : event_wait_list.remaining(),
			MemoryUtil.memAddressSafe(event_wait_list), MemoryUtil.memAddressSafe(event), MemoryUtil.memAddressSafe(errcode_ret));
		long slice_pitch = image_slice_pitch == null ? 0 : image_slice_pitch.get(image_slice_pitch.position());
		long size = slice_pitch == 0
			? region.get(region.position() + 1) * image_row_pitch.get(image_row_pitch.position())
			: region.get(region.position() + 2) * slice_pitch;
		ByteBuffer __result = MemoryUtil.memByteBufferSafe(address, (int)size);
		if (__result != null) command_queue.registerCLEvent(event);
		return __result;
	}

	/**
	 * LWJGL 2's args block (APIUtil.getNativeKernelArgs) and, as its C made them, the places in it where the
	 * implementation puts each memory object's pointer.
	 */
	public static int clEnqueueNativeKernel(CLCommandQueue command_queue, CLNativeKernel user_func, CLMem[] mem_list, long[] sizes,
		PointerBuffer event_wait_list, PointerBuffer event) {
		if (mem_list != null) {
			BufferChecks.checkArray(mem_list, 1);
			BufferChecks.checkArray(sizes, mem_list.length);
		}
		if (event_wait_list != null) BufferChecks.checkDirect(event_wait_list);
		if (event != null) BufferChecks.checkBuffer(event, 1);
		long user_func_ref = CallbackUtil.createGlobalRef(user_func);
		ByteBuffer args = APIUtil.getNativeKernelArgs(user_func_ref, mem_list, sizes);
		int __result = 0;
		try (MemoryStack stack = MemoryStack.stackPush()) {
			PointerBuffer mems = null;
			PointerBuffer locations = null;
			if (mem_list != null) {
				mems = stack.mallocPointer(mem_list.length);
				locations = stack.mallocPointer(mem_list.length);
				for (int i = 0; i < mem_list.length; i++) {
					mems.put(i, mem_list[i].getPointer());
					locations.put(i, MemoryUtil.memAddress(args) + 12 + 4 + i * (4 + org.lwjgl.system.Pointer.POINTER_SIZE));
				}
			}
			__result = CL10.clEnqueueNativeKernel(command_queue.getPointer(), user_func, args, mems, locations, event_wait_list, event);
			if (__result == CL10.CL_SUCCESS) command_queue.registerCLEvent(event);
			return __result;
		} finally {
			CallbackUtil.checkCallback(__result, user_func_ref);
		}
	}

	/** Pointers to the pieces of {@code buffer}, one after the other, as long as {@code lengths} says. */
	static PointerBuffer consecutive(MemoryStack stack, ByteBuffer buffer, PointerBuffer lengths) {
		PointerBuffer pointers = stack.mallocPointer(lengths.remaining());
		long address = MemoryUtil.memAddress(buffer);
		for (int i = 0; i < pointers.capacity(); i++) {
			pointers.put(i, address);
			address += lengths.get(lengths.position() + i);
		}
		return pointers;
	}

	private static PointerBuffer lengths(MemoryStack stack, ByteBuffer[] buffers) {
		PointerBuffer lengths = stack.mallocPointer(buffers.length);
		for (int i = 0; i < buffers.length; i++) {
			lengths.put(i, buffers[i].remaining());
		}
		return lengths;
	}

}
