package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U1;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class TypeParameterBoundTarget {

	private byte[] bytes;
	private int offset;
	
	private U1 typeParameterIndex;
	private U1 boundIndex;
	
	public TypeParameterBoundTarget(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		typeParameterIndex = new U1(bytes, offset);
		offset = typeParameterIndex.parse();
		boundIndex = new U1(bytes, offset);
		offset = boundIndex.parse();
		return offset;
	}
	
	public int getTypeParameterIndex() {
		return typeParameterIndex.getValue();
	}
	
	public int getBoundIndex() {
		return boundIndex.getValue();
	}

	@Override
	public String toString() {
		return "TypeParameterBoundTarget [getTypeParameterIndex()=" + getTypeParameterIndex() + ", getBoundIndex()=" + getBoundIndex() + "]";
	}
}
