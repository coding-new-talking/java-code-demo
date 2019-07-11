package org.cnt.java.classfile.bytecode.constantpool.entry;

import org.cnt.java.classfile.bytecode.constantpool.Index;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantNameAndType extends ConstantEntry {

	private Index nameIndex;
	private Index descriptorIndex;
	
	public ConstantNameAndType(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		nameIndex = new Index(bytes, offset);
		offset = nameIndex.parse();
		descriptorIndex = new Index(bytes, offset);
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
