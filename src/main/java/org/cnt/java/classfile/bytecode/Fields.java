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
	private ConstantPool constantPool;
	
	private FieldInfo[] fields;
	
	public Fields(byte[] bytes, int offset, int fieldsCount, ConstantPool constantPool) {
		this.bytes = bytes;
		this.offset = offset;
		this.fieldsCount = fieldsCount;
		this.constantPool = constantPool;
	}
	
	public int parse() {
		fields = new FieldInfo[fieldsCount];
		for (int i = 0; i < fieldsCount; i++) {
			fields[i] = new FieldInfo(bytes, offset, constantPool);
			offset = fields[i].parse();
		}
		return offset;
	}
}
