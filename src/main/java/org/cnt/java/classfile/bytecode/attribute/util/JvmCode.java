package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U1;

/**
 * @author lixinjie
 * @since 2019-07-22
 */
public class JvmCode {
	
	private byte[] bytes;
	private int offset;
	
	private int codeLength;
	private U1[] u1s;
	
	public JvmCode(byte[] bytes, int offset, int codeLength) {
		this.bytes = bytes;
		this.offset = offset;
		this.codeLength = codeLength;
	}
	
	public int parse() {
		u1s = new U1[codeLength];
		for (int i = 0, len = u1s.length; i < len; i++) {
			u1s[i] = new U1(bytes, offset);
			offset = u1s[i].parse();
		}
		return offset;
	}
	
	public int getCode() {
		return codeLength;
	}

	@Override
	public String toString() {
		return "JvmCode [getCode()=" + getCode() + "]";
	}
}
