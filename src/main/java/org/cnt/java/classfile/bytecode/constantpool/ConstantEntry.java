package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.classfile.bytecode.constantpool.util.ConstantEntryTag;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public abstract class ConstantEntry {
	
	protected int offset;
	protected byte[] bytes;
	
	protected ConstantEntryTag tag;
	
	public ConstantEntry(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
		this.tag = new ConstantEntryTag(bytes, offset);
	}
	
	public abstract int parse();
	
	public int getTag() {
		return tag.getTag();
	}
}
