package org.cnt.java.classfile.bytecode;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class MajorVersion {

	private U2 u2;
	
	public MajorVersion(byte[] bytes, int offset) {
		this.u2 = new U2(bytes, offset);
	}
	
	public int parse() {
		return u2.parse();
	}

	public int getVersion() {
		return u2.getValue();
	}
}
