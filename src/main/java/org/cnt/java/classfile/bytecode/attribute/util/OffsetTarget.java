package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class OffsetTarget {
	
	private U2 offset;
	
	public OffsetTarget(byte[] bytes, int offset) {
		this.offset = new U2(bytes, offset);
	}
	
	public int parse() {
		return offset.parse();
	}
	
	public int getOffset() {
		return offset.getValue();
	}

	@Override
	public String toString() {
		return "OffsetTarget [getOffset()=" + getOffset() + "]";
	}
}
