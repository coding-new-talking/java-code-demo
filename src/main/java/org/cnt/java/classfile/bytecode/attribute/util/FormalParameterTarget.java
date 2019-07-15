package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U1;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class FormalParameterTarget {
	
	private U1 formalParameterIndex;
	
	public FormalParameterTarget(byte[] bytes, int offset) {
		this.formalParameterIndex = new U1(bytes, offset);
	}
	
	public int parse() {
		return formalParameterIndex.parse();
	}
	
	public int getFormalParameterIndex() {
		return formalParameterIndex.getValue();
	}

	@Override
	public String toString() {
		return "FormalParameterTarget [getFormalParameterIndex()=" + getFormalParameterIndex() + "]";
	}
}
