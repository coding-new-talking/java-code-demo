package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantInvokeDynamic extends ConstantEntry {

	private Index2 bootstrapMethodAttrIndex;
	private Index2 nameAndTypeIndex;
	
	public ConstantInvokeDynamic(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		bootstrapMethodAttrIndex = new Index2(bytes, offset);
		offset = bootstrapMethodAttrIndex.parse();
		nameAndTypeIndex = new Index2(bytes, offset);
		offset = nameAndTypeIndex.parse();
		return offset;
	}
	
	public int getBootstrapMethodAttrIndex() {
		return bootstrapMethodAttrIndex.getIndex();
	}
	
	public int getNameAndTypeIndex() {
		return nameAndTypeIndex.getIndex();
	}

	@Override
	public String toString() {
		return "ConstantInvokeDynamic [getBootstrapMethodAttrIndex()=" + getBootstrapMethodAttrIndex()
				+ ", getNameAndTypeIndex()=" + getNameAndTypeIndex() + ", getTag()=" + getTag() + "]";
	}
}
