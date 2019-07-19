package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class SourceFile extends AttributeInfo {

	private Index2 sourcefileIndex;
	
	public SourceFile(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		sourcefileIndex = new Index2(bytes, offset);
		offset = sourcefileIndex.parse();
		return offset;
	}
	
	public int getSourcefileIndex() {
		return sourcefileIndex.getIndex();
	}
}
