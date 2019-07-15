package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantMethodType extends ConstantEntry {

	private Index2 descriptorIndex;
	
	public ConstantMethodType(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		descriptorIndex = new Index2(bytes, offset);
		offset = descriptorIndex.parse();
		return offset;
	}
	
	public int getDescriptorIndex() {
		return descriptorIndex.getIndex();
	}

	@Override
	public String toString() {
		return "ConstantMethodType [getDescriptorIndex()=" + getDescriptorIndex() + ", getTag()=" + getTag() + "]";
	}
}
