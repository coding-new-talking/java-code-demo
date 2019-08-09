package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class SameLocals1StackItemFrame extends Frame {

	private VerificationTypeInfo[] stack;
	
	public SameLocals1StackItemFrame(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		stack = new VerificationTypeInfo[1];
		
		return offset;
	}
}
