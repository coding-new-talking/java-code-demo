package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class Offset2 {
	
	private U2 u2;
	
	public Offset2(byte[] bytes, int offset) {
		this.u2 = new U2(bytes, offset);
	}
	
	public int parse() {
		return u2.parse();
	}
	
	public int getOffset() {
		return u2.getValue();
	}

	@Override
	public String toString() {
		return "Offset2 [getOffset()=" + getOffset() + "]";
	}
}
