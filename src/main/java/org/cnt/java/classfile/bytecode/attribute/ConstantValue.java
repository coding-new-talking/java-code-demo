package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class ConstantValue extends AttributeInfo {

	private Index2 constantValueIndex;
	
	public ConstantValue(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		constantValueIndex = new Index2(bytes, offset);
		offset = constantValueIndex.parse();
		return offset;
	}
}
