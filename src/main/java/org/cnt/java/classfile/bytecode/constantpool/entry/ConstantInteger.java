package org.cnt.java.classfile.bytecode.constantpool.entry;

import org.cnt.java.classfile.bytecode.constantpool.Byte4;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantInteger extends ConstantEntry {
	
	private Byte4 byte4;
	
	public ConstantInteger(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		byte4 = new Byte4(bytes, offset);
		offset = byte4.parse();
		return offset;
	}

}
