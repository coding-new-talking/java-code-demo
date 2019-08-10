package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-08-10
 */
public class FrameBuilder {

	private byte[] bytes;

	private FrameBuilder(byte[] bytes) {
		this.bytes = bytes;
	}
	
	public static FrameBuilder newBuilder(byte[] bytes) {
		return new FrameBuilder(bytes);
	}
	
	public Frame build(int offset) {
		int frameType = Byter.toUnsigned(bytes[offset]);
		if (SAME_Begin <= frameType && frameType <= SAME_End) {
			return new SameFrame(bytes, offset);
		}
		if (SAME_LOCALS_1_STACK_ITEM_Begin <= frameType && frameType <= SAME_LOCALS_1_STACK_ITEM_End) {
			return new SameLocals1StackItemFrame(bytes, offset);
		}
		if (frameType == SAME_LOCALS_1_STACK_ITEM_EXTENDED) {
			return new SameLocals1StackItemFrameExtended(bytes, offset);
		}
		if (CHOP_Begin <= frameType && frameType <= CHOP_End) {
			return new ChopFrame(bytes, offset);
		}
		if (frameType == SAME_FRAME_EXTENDED) {
			return new SameFrameExtended(bytes, offset);
		}
		if (APPEND_Begin <= frameType && frameType <= APPEND_End) {
			return new AppendFrame(bytes, offset);
		}
		if (frameType == FULL) {
			return new FullFrame(bytes, offset);
		}
		throw new RuntimeException("frameType=" + frameType);
	}
	
	public static final int SAME_Begin = 0;
	public static final int SAME_End = 63;
	
	public static final int SAME_LOCALS_1_STACK_ITEM_Begin = 64;
	public static final int SAME_LOCALS_1_STACK_ITEM_End = 127;
	
	//the range [128-246] are reserved for future use.
	
	public static final int SAME_LOCALS_1_STACK_ITEM_EXTENDED = 247;
	
	public static final int CHOP_Begin = 248;
	public static final int CHOP_End = 250;
	
	public static final int SAME_FRAME_EXTENDED = 251;
	
	public static final int APPEND_Begin = 252;
	public static final int APPEND_End = 254;
	
	public static final int FULL = 255;
}
