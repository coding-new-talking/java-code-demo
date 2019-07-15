package org.cnt.java.classfile.bytecode;

import org.cnt.java.classfile.bytecode.field.FieldInfo;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class Fields {

	private int fieldsCount;
	private int offset;
	private byte[] bytes;
	
	private FieldInfo[] fields;
	
	public Fields(byte[] bytes, int offset, int fieldsCount) {
		this.bytes = bytes;
		this.offset = offset;
		this.fieldsCount = fieldsCount;
	}
	
	public int parse() {
		fields = new FieldInfo[fieldsCount];
		for (int i = 0; i < fieldsCount; i++) {
			fields[i] = new FieldInfo(bytes, offset);
			offset = fields[i].parse();
		}
		return offset;
	}
}
