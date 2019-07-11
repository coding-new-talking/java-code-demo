package org.cnt.java.classfile.bytecode.constantpool.entry;

import org.cnt.java.classfile.bytecode.constantpool.Byte4;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantLong extends ConstantEntry {
	
	private Byte4 highByte4;
	private Byte4 lowByte4;
	
	public ConstantLong(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		highByte4 = new Byte4(bytes, offset);
		offset = highByte4.parse();
		lowByte4 = new Byte4(bytes, offset);
		offset = lowByte4.parse();
		return offset;
	}

}
