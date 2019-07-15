package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U4;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class Length4 {
	
	private U4 u4;
	
	public Length4(byte[] bytes, int offset) {
		this.u4 = new U4(bytes, offset);
	}
	
	public int parse() {
		return u4.parse();
	}
	
	public long getLength() {
		return u4.getValue();
	}

	@Override
	public String toString() {
		return "Length4 [getLength()=" + getLength() + "]";
	}
}
