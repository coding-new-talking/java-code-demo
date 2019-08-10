package org.cnt.java.classfile.bytecode.attribute.util;

import java.util.Arrays;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class AppendFrame extends Frame {

	private int additionalLocalVariables;
	private OffsetDelta offsetDelta;
	private VerificationTypeInfo[] locals;
	
	public AppendFrame(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		additionalLocalVariables = frameType.getFrameType() - 251;
		offsetDelta = new OffsetDelta(bytes, offset);
		offset = offsetDelta.parse();
		locals = new VerificationTypeInfo[additionalLocalVariables];
		for (int i = 0, len = locals.length; i < len; i++) {
			locals[i] = new VerificationTypeInfo(bytes, offset);
			offset = locals[i].parse();
		}
		return offset;
	}

	public int getAdditionalLocalVariables() {
		return additionalLocalVariables;
	}

	public int getOffsetDelta() {
		return offsetDelta.getOffsetDelta();
	}

	public VerificationTypeInfo[] getLocals() {
		return locals;
	}

	@Override
	public String toString() {
		return "AppendFrame [getAdditionalLocalVariables()=" + getAdditionalLocalVariables() + ", getOffsetDelta()="
				+ getOffsetDelta() + ", getLocals()=" + Arrays.toString(getLocals()) + ", getFrameType()="
				+ getFrameType() + "]";
	}
}
