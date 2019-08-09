package org.cnt.java.classfile.bytecode.attribute.util;

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
		
		numberOfStackItems = new Num2(bytes, offset);
		offset  = numberOfStackItems.parse();
		stack = new VerificationTypeInfo[numberOfStackItems.getNum()];
		
		return offset;
	}
}
