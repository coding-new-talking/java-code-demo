package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.attribute.util.Length4;
import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class AttributeInfo {

	protected byte[] bytes;
	protected int offset;
	
	protected Index2 attributeNameIndex;
	protected Length4 attributeLength;
	
	public AttributeInfo(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		attributeNameIndex = new Index2(bytes, offset);
		offset = attributeNameIndex.parse();
		attributeLength = new Length4(bytes, offset);
		offset = attributeLength.parse();
		return offset;
	}
	
	public int getAttributeNameIndex() {
		return attributeNameIndex.getIndex();
	}
	
	public long getAttributeLength() {
		return attributeLength.getLength();
	}
}
