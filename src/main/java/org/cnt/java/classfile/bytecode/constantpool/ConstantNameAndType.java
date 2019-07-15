package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantNameAndType extends ConstantEntry {

	private Index2 nameIndex;
	private Index2 descriptorIndex;
	
	public ConstantNameAndType(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		nameIndex = new Index2(bytes, offset);
		offset = nameIndex.parse();
		descriptorIndex = new Index2(bytes, offset);
		offset = descriptorIndex.parse();
		return offset;
	}
	
	public int getNameIndex() {
		return nameIndex.getIndex();
	}
	
	public int getDescriptorIndex() {
		return descriptorIndex.getIndex();
	}

	@Override
	public String toString() {
		return "ConstantNameAndType [getNameIndex()=" + getNameIndex() + ", getDescriptorIndex()="
				+ getDescriptorIndex() + ", getTag()=" + getTag() + "]";
	}
}
