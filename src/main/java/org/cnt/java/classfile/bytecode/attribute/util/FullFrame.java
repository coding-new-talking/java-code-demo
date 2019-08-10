package org.cnt.java.classfile.bytecode.attribute.util;

import java.util.Arrays;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class FullFrame extends Frame {

	private OffsetDelta offsetDelta;
	private Num2 numberOfLocals;
	private VerificationTypeInfo[] locals;
	private Num2 numberOfStackItems;
	private VerificationTypeInfo[] stack;
	
	public FullFrame(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		offsetDelta = new OffsetDelta(bytes, offset);
		offset = offsetDelta.parse();
		numberOfLocals = new Num2(bytes, offset);
		offset  = numberOfLocals.parse();
		locals = new VerificationTypeInfo[numberOfLocals.getNum()];
		for (int i = 0, len = locals.length; i < len; i++) {
			locals[i] = new VerificationTypeInfo(bytes, offset);
			offset = locals[i].parse();
		}
		numberOfStackItems = new Num2(bytes, offset);
		offset  = numberOfStackItems.parse();
		stack = new VerificationTypeInfo[numberOfStackItems.getNum()];
		for (int i = 0, len = stack.length; i < len; i++) {
			stack[i] = new VerificationTypeInfo(bytes, offset);
			offset = stack[i].parse();
		}
		return offset;
	}

	public int getOffsetDelta() {
		return offsetDelta.getOffsetDelta();
	}

	public int getNumberOfLocals() {
		return numberOfLocals.getNum();
	}

	public VerificationTypeInfo[] getLocals() {
		return locals;
	}

	public int getNumberOfStackItems() {
		return numberOfStackItems.getNum();
	}

	public VerificationTypeInfo[] getStack() {
		return stack;
	}

	@Override
	public String toString() {
		return "FullFrame [getOffsetDelta()=" + getOffsetDelta() + ", getNumberOfLocals()=" + getNumberOfLocals()
				+ ", getLocals()=" + Arrays.toString(getLocals()) + ", getNumberOfStackItems()="
				+ getNumberOfStackItems() + ", getStack()=" + Arrays.toString(getStack()) + ", getFrameType()="
				+ getFrameType() + "]";
	}
}
