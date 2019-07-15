package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantClass extends ConstantEntry {

	private Index2 nameIndex;
	
	public ConstantClass(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		nameIndex = new Index2(bytes, offset);
		offset = nameIndex.parse();
		return offset;
	}
	
	public int getNameIndex() {
		return nameIndex.getIndex();
	}

	@Override
	public String toString() {
		return "ConstantClass [getNameIndex()=" + getNameIndex() + ", getTag()=" + getTag() + "]";
	}
}
