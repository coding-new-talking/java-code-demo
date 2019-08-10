package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class VerificationTypeInfo {

	private byte[] bytes;
	private int offset;
	
	private VariableInfo variableInfo;

	public VerificationTypeInfo(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		VariableInfoBuilder builder = VariableInfoBuilder.newBuilder(bytes);
		variableInfo = builder.build(offset);
		offset = variableInfo.parse();
		return offset;
	}

	public VariableInfo getVariableInfo() {
		return variableInfo;
	}

	@Override
	public String toString() {
		return "VerificationTypeInfo [getVariableInfo()=" + getVariableInfo() + "]";
	}
}
