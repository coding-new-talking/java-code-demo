package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U1;
import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class TypeArgumentTarget {

	private byte[] bytes;
	private int offset;
	
	private U2 _offset;
	private U1 typeArgumentIndex;
	
	public TypeArgumentTarget(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		_offset = new U2(bytes, offset);
		offset = _offset.parse();
		typeArgumentIndex = new U1(bytes, offset);
		offset = typeArgumentIndex.parse();
		return offset;
	}
	
	public int getOffset() {
		return _offset.getValue();
	}
	
	public int getTypeArgumentIndex() {
		return typeArgumentIndex.getValue();
	}

	@Override
	public String toString() {
		return "TypeArgumentTarget [getOffset()=" + getOffset() + ", getTypeArgumentIndex()=" + getTypeArgumentIndex()+ "]";
	}
}
