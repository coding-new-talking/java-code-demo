package org.cnt.java.classfile.bytecode.constantpool.entry;

import org.cnt.java.classfile.bytecode.constantpool.Index;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantMethodType extends ConstantEntry {

	private Index descriptorIndex;
	
	public ConstantMethodType(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		descriptorIndex = new Index(bytes, offset);
		offset = descriptorIndex.parse();
		return offset;
	}
	
	public int getDescriptorIndex() {
		return descriptorIndex.getIndex();
	}
}
