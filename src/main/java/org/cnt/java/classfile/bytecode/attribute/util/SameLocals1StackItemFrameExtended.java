package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class SameLocals1StackItemFrameExtended extends Frame {

	private OffsetDelta offsetDelta;
	private VerificationTypeInfo[] stack;
	
	public SameLocals1StackItemFrameExtended(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		offsetDelta = new OffsetDelta(bytes, offset);
		offset = offsetDelta.parse();
		stack = new VerificationTypeInfo[1];
		
		return offset;
	}
}
