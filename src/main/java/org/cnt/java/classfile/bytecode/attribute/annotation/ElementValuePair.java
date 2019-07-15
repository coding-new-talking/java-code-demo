package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class ElementValuePair {

	private byte[] bytes;
	private int offset;
	
	private Index2 elementNameIndex;
	private ElementValue elementValue;
	
	public ElementValuePair(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		elementNameIndex = new Index2(bytes, offset);
		offset = elementNameIndex.parse();
		elementValue = new ElementValue(bytes, offset);
		offset = elementValue.parse();
		return offset;
	}
}
