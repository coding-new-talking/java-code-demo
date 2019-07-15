package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantInterfaceMethodRef extends ConstantEntry {

	private Index2 classIndex;
	private Index2 nameAndTypeIndex;
	
	public ConstantInterfaceMethodRef(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		classIndex = new Index2(bytes, offset);
		offset = classIndex.parse();
		nameAndTypeIndex = new Index2(bytes, offset);
		offset = nameAndTypeIndex.parse();
		return offset;
	}
	
	public int getClassIndex() {
		return classIndex.getIndex();
	}
	
	public int getNameAndTypeIndex() {
		return nameAndTypeIndex.getIndex();
	}

	@Override
	public String toString() {
		return "ConstantInterfaceMethodRef [getClassIndex()=" + getClassIndex() + ", getNameAndTypeIndex()="
				+ getNameAndTypeIndex() + ", getTag()=" + getTag() + "]";
	}
}
