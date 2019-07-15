package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U1;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class TypeParameterTarget {
	
	private U1 typeParameterIndex;
	
	public TypeParameterTarget(byte[] bytes, int offset) {
		this.typeParameterIndex = new U1(bytes, offset);
	}
	
	public int parse() {
		return typeParameterIndex.parse();
	}
	
	public int getTypeParameterIndex() {
		return typeParameterIndex.getValue();
	}

	@Override
	public String toString() {
		return "TypeParameterTarget [getTypeParameterIndex()=" + getTypeParameterIndex() + "]";
	}
}
