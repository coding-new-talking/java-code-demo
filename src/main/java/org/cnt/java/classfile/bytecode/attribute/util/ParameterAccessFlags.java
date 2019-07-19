package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class ParameterAccessFlags {

	private U2 u2;
	
	public ParameterAccessFlags(byte[] bytes, int offset) {
		this.u2 = new U2(bytes, offset);
	}
	
	public int parse() {
		return u2.parse();
	}
	
	public int getAccessFlags() {
		return u2.getValue();
	}
}
