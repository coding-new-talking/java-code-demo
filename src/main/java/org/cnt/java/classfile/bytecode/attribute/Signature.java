package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class Signature extends AttributeInfo {

	private Index2 signatureIndex;
	
	public Signature(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		signatureIndex = new Index2(bytes, offset);
		offset = signatureIndex.parse();
		return offset;
	}
}
