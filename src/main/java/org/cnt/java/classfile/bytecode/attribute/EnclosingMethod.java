package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class EnclosingMethod extends AttributeInfo {

	private Index2 classIndex;
	private Index2 methodIndex;
	
	public EnclosingMethod(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		classIndex = new Index2(bytes, offset);
		offset = classIndex.parse();
		methodIndex = new Index2(bytes, offset);
		offset = methodIndex.parse();
		return offset;
	}
	
	public int getClassIndex() {
		return classIndex.getIndex();
	}
	
	public int getMethodIndex() {
		return methodIndex.getIndex();
	}
}
