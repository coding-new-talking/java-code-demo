package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class SameFrame extends Frame {

	private int offsetDelta;
	
	public SameFrame(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		offsetDelta = frameType.getFrameType();
		return offset;
	}

	public int getOffsetDelta() {
		return offsetDelta;
	}

	@Override
	public String toString() {
		return "SameFrame [getOffsetDelta()=" + getOffsetDelta() + ", getFrameType()=" + getFrameType() + "]";
	}
}
