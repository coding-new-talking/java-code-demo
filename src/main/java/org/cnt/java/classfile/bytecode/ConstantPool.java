package org.cnt.java.classfile.bytecode;

import org.cnt.java.classfile.bytecode.constantpool.ConstantEntry;
import org.cnt.java.classfile.bytecode.constantpool.ConstantEntryBuilder;
import org.cnt.java.classfile.bytecode.constantpool.ConstantUtf8;

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
		ConstantEntryBuilder builder = ConstantEntryBuilder.newBuilder(bytes);
		for (int i = 1; i < constantPoolCount; i++) {
			ConstantEntry entry = builder.build(offset);
			offset = entry.parse();
			constantEntries[i] = entry;
			//对于long和double类型
			//一个entry占两个索引
			//这是历史遗留问题
			if (builder.getIndexDelta() == 1) {
				constantEntries[++i] = null;
			}
		}
		return offset;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ConstantPool [\r\n");
		for (int i = 0; i < constantPoolCount; i++) {
			sb.append("#" + i + " = ").append(constantEntries[i]).append("\r\n");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public ConstantEntry getConstantEntry(int index) {
		return constantEntries[index];
	}
	
	public ConstantUtf8 getConstantUtf8(int index) {
		return (ConstantUtf8)constantEntries[index];
	}
	
	public String getConstantUtf8String(int index) {
		return getConstantUtf8(index).getString();
	}
}
