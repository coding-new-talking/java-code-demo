package org.cnt.java.classfile.bytecode.attribute.util;

import java.util.Arrays;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class SameLocals1StackItemFrame extends Frame {

	private int offsetDelta;
	private VerificationTypeInfo[] stack;
	
	public SameLocals1StackItemFrame(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		offsetDelta = frameType.getFrameType();
		stack = new VerificationTypeInfo[1];
		stack[0] = new VerificationTypeInfo(bytes, offset);
		offset = stack[0].parse();
		return offset;
	}

	public int getOffsetDelta() {
		return offsetDelta;
	}

	public VerificationTypeInfo[] getStack() {
		return stack;
	}

	@Override
	public String toString() {
		return "SameLocals1StackItemFrame [getOffsetDelta()=" + getOffsetDelta() + ", getStack()="
				+ Arrays.toString(getStack()) + ", getFrameType()=" + getFrameType() + "]";
	}
}
