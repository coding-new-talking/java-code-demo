package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;
import org.cnt.java.classfile.bytecode.constantpool.util.Length2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class LocalVarTable {
	
	private byte[] bytes;
	private int offset;
	
	private StartPc startPc;
	private Length2 length;
	private Index2 nameIndex;
	private Index2 descriptorIndex;
	private Index2 index;
	
	public LocalVarTable(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		startPc = new StartPc(bytes, offset);
		offset = startPc.parse();
		length = new Length2(bytes, offset);
		offset = length.parse();
		nameIndex = new Index2(bytes, offset);
		offset = nameIndex.parse();
		descriptorIndex = new Index2(bytes, offset);
		offset = descriptorIndex.parse();
		index = new Index2(bytes, offset);
		offset = index.parse();
		return offset;
	}
	
	public int getStartPc() {
		return startPc.getStartPc();
	}
	
	public int getLength() {
		return length.getLength();
	}
	
	public int getNameIndex() {
		return nameIndex.getIndex();
	}
	
	public int getDescriptorIndex() {
		return descriptorIndex.getIndex();
	}
	
	public int getIndex() {
		return index.getIndex();
	}

	@Override
	public String toString() {
		return "LocalVarTable [getStartPc()=" + getStartPc() + ", getLength()=" + getLength() + ", getNameIndex()="
				+ getNameIndex() + ", getDescriptorIndex()=" + getDescriptorIndex() + ", getIndex()=" + getIndex()
				+ "]";
	}
}
