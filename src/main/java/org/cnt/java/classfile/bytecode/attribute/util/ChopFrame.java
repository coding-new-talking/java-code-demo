package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class ChopFrame extends Frame {

	private int absentLocalVariables;
	private OffsetDelta offsetDelta;
	
	public ChopFrame(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		absentLocalVariables = 251 - frameType.getFrameType();
		offsetDelta = new OffsetDelta(bytes, offset);
		offset = offsetDelta.parse();
		return offset;
	}

	public int getAbsentLocalVariables() {
		return absentLocalVariables;
	}

	public int getOffsetDelta() {
		return offsetDelta.getOffsetDelta();
	}

	@Override
	public String toString() {
		return "ChopFrame [getAbsentLocalVariables()=" + getAbsentLocalVariables() + ", getOffsetDelta()="
				+ getOffsetDelta() + ", getFrameType()=" + getFrameType() + "]";
	}
}
