package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class SupertypeTarget {
	
	private U2 supertypeIndex;
	
	public SupertypeTarget(byte[] bytes, int offset) {
		this.supertypeIndex = new U2(bytes, offset);
	}
	
	public int parse() {
		return supertypeIndex.parse();
	}
	
	public int getSupertypeIndex() {
		return supertypeIndex.getValue();
	}

	@Override
	public String toString() {
		return "SupertypeTarget [getSupertypeIndex()=" + getSupertypeIndex() + "]";
	}
}
