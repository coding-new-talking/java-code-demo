package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U1;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class Index1 {
	
	private U1 u1;
	
	public Index1(byte[] bytes, int offset) {
		this.u1 = new U1(bytes, offset);
	}
	
	public int parse() {
		return u1.parse();
	}
	
	public int getIndex() {
		return u1.getValue();
	}

	@Override
	public String toString() {
		return "Index1 [getIndex()=" + getIndex() + "]";
	}
}
