package org.cnt.java.classfile.bytecode;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantPoolCount {
	
	private U2 u2;
	
	public ConstantPoolCount(byte[] bytes, int offset) {
		this.u2 = new U2(bytes, offset);
	}
	
	public int parse() {
		return u2.parse();
	}

	public int getCount() {
		return u2.getValue();
	}

	@Override
	public String toString() {
		return "ConstantPoolCount [getCount()=" + getCount() + "]";
	}
}
