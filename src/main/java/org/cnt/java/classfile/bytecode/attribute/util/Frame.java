package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public abstract class Frame {

	protected byte[] bytes;
	protected int offset;
	
	protected FrameType frameType;
	
	public Frame(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		frameType = new FrameType(bytes, offset);
		offset = frameType.parse();
		return offset;
	}
	
	public int getFrameType() {
		return frameType.getFrameType();
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
