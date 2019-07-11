package org.cnt.java.classfile.bytecode.constantpool.entry;

import org.cnt.java.classfile.bytecode.constantpool.Index;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantClass extends ConstantEntry {

	private Index nameIndex;
	
	public ConstantClass(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		nameIndex = new Index(bytes, offset);
		offset = nameIndex.parse();
		return offset;
	}
	
	public int getNameIndex() {
		return nameIndex.getIndex();
	}
}
