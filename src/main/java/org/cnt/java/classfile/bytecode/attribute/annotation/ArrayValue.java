package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.attribute.util.Num2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class ArrayValue {

	private byte[] bytes;
	private int offset;
	
	private Num2 numValues;
	private ElementValue[] values;
	
	public ArrayValue(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		numValues = new Num2(bytes, offset);
		offset = numValues.parse();
		values = new ElementValue[numValues.getNum()];
		for (int i = 0, len = values.length; i < len; i++) {
			values[i] = new ElementValue(bytes, offset);
			offset = values[i].parse();
		}
		return offset;
	}
}
