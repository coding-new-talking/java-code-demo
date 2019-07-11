package org.cnt.java.classfile.bytecode;

import org.cnt.java.classfile.bytecode.constantpool.entry.ConstantEntry;
import org.cnt.java.classfile.bytecode.constantpool.entry.ConstantEntryBuilder;

/**
 * @author lixinjie
 * @since 2019-07-10
 */
public class ConstantPool {
	
	private int constantPoolCount;
	private int offset;
	private byte[] bytes;
	
	private ConstantEntry[] constantEntries;
	
	public ConstantPool(byte[] bytes, int offset, int constantPoolCount) {
		this.bytes = bytes;
		this.offset = offset;
		this.constantPoolCount = constantPoolCount;
	}
	
	public int parse() {
		constantEntries = new ConstantEntry[constantPoolCount];
		//第0个位置不使用，从第1个位置开始
		constantEntries[0] = null;
		for (int i = 1; i < constantPoolCount; i++) {
			ConstantEntry entry = ConstantEntryBuilder.build(bytes, offset);
			offset = entry.parse();
			constantEntries[i] = entry;
		}
		return offset;
	}
	
}
