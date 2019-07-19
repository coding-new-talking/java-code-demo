package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class Parameter {
	
	private byte[] bytes;
	private int offset;
	
	private Index2 nameIndex;
	private ParameterAccessFlags accessFlags;
	
	public Parameter(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		nameIndex = new Index2(bytes, offset);
		offset = nameIndex.parse();
		accessFlags = new ParameterAccessFlags(bytes, offset);
		offset = accessFlags.parse();
		return offset;
	}
	
	public int getNameIndex() {
		return nameIndex.getIndex();
	}
	
	public int getAccessFlags() {
		return accessFlags.getAccessFlags();
	}
}
