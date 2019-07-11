package org.cnt.java.classfile.bytecode.constantpool.entry;

import org.cnt.java.classfile.bytecode.constantpool.Index;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantString extends ConstantEntry {

	private Index stringIndex;
	
	public ConstantString(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		stringIndex = new Index(bytes, offset);
		offset = stringIndex.parse();
		return offset;
	}
	
	public int getStringIndex() {
		return stringIndex.getIndex();
	}

	@Override
	public String toString() {
		return "ConstantString [getStringIndex()=" + getStringIndex() + ", getTag()=" + getTag() + "]";
	}
}
