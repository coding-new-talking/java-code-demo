package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class AppendFrame extends Frame {

	private OffsetDelta offsetDelta;
	private VerificationTypeInfo[] locals;
	
	public AppendFrame(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		offsetDelta = new OffsetDelta(bytes, offset);
		offset = offsetDelta.parse();
		locals = new VerificationTypeInfo[frameType.getFrameType() - 251];
		
		return offset;
	}
}
