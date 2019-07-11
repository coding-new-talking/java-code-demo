package org.cnt.java.classfile.bytecode.constantpool.entry;

import org.cnt.java.classfile.bytecode.constantpool.Tag;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public abstract class ConstantEntry {
	
	protected int offset;
	protected byte[] bytes;
	
	protected Tag tag;
	
	public ConstantEntry(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
		this.tag = new Tag(bytes, offset);
	}
	
	public abstract int parse();
}
