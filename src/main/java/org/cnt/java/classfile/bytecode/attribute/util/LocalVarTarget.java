package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.constantpool.util.Length2;

/**
 * @author lixinjie
 * @since 2019-07-16
 */
public class LocalVarTarget {

	private byte[] bytes;
	private int offset;
	
	private Length2 tableLength;
	private Table[] tables;
	
	public LocalVarTarget(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		tableLength = new Length2(bytes, offset);
		offset = tableLength.parse();
		tables = new Table[tableLength.getLength()];
		for (int i = 0, len = tables.length; i < len; i++) {
			tables[i] = new Table(bytes, offset);
			offset = tables[i].parse();
		}
		return offset;
	}
}
