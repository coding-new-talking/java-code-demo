package org.cnt.java.classfile.bytecode.constantpool.util;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class Length2 {
	
	private U2 u2;
	
	public Length2(byte[] bytes, int offset) {
		this.u2 = new U2(bytes, offset);
	}
	
	public int parse() {
		return u2.parse();
	}
	
	public int getLength() {
		return u2.getValue();
	}

	@Override
	public String toString() {
		return "Length2 [getLength()=" + getLength() + "]";
	}
}
