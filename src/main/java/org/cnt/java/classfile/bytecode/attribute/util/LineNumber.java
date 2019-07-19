package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class LineNumber {
	
	private U2 u2;
	
	public LineNumber(byte[] bytes, int offset) {
		this.u2 = new U2(bytes, offset);
	}
	
	public int parse() {
		return u2.parse();
	}
	
	public int getLineNumber() {
		return u2.getValue();
	}

	@Override
	public String toString() {
		return "LineNumber [getLineNumber()=" + getLineNumber() + "]";
	}
}
