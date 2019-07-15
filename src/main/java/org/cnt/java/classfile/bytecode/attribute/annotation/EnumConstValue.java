package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class EnumConstValue {

	private byte[] bytes;
	private int offset;
	
	private Index2 typeNameIndex;
	private Index2 constNameIndex;
	
	public EnumConstValue(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		typeNameIndex = new Index2(bytes, offset);
		offset = typeNameIndex.parse();
		constNameIndex = new Index2(bytes, offset);
		offset = constNameIndex.parse();
		return offset;
	}
}
