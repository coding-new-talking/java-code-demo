package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class CatchTarget {
	
	private U2 exceptionTableIndex;
	
	public CatchTarget(byte[] bytes, int offset) {
		this.exceptionTableIndex = new U2(bytes, offset);
	}
	
	public int parse() {
		return exceptionTableIndex.parse();
	}
	
	public int getExceptionTableIndex() {
		return exceptionTableIndex.getValue();
	}

	@Override
	public String toString() {
		return "CatchTarget [getExceptionTableIndex()=" + getExceptionTableIndex() + "]";
	}
}
