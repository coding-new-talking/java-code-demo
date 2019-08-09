package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class ObjectVariableInfo extends VariableInfo {

	private Index2 cpoolIndex;
	
	public ObjectVariableInfo(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		cpoolIndex = new Index2(bytes, offset);
		offset = cpoolIndex.parse();
		return offset;
	}
	
	public int getCpoolIndex() {
		return cpoolIndex.getIndex();
	}
}
