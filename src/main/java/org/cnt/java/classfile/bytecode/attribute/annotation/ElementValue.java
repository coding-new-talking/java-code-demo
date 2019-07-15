package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.attribute.util.ElementValueTag;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class ElementValue {

	private byte[] bytes;
	private int offset;
	
	private ElementValueTag tag;
	private ElementValueUnion union;
	
	public ElementValue(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		tag = new ElementValueTag(bytes, offset);
		offset = tag.parse();
		union = new ElementValueUnion(bytes, offset, tag);
		offset = union.parse();
		return offset;
	}
}
