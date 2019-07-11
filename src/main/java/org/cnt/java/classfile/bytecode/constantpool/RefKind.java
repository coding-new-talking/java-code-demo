package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.classfile.bytecode.unsigned.U1;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class RefKind {

	private U1 u1;
	
	public RefKind(byte[] bytes, int offset) {
		this.u1 = new U1(bytes, offset);
	}
	
	public int parse() {
		return u1.parse();
	}
	
	public int getRefKind() {
		return u1.getValue();
	}

	@Override
	public String toString() {
		return "RefKind [getRefKind()=" + getRefKind() + "]";
	}
}
