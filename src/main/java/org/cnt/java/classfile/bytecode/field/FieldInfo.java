package org.cnt.java.classfile.bytecode.field;

import org.cnt.java.classfile.bytecode.ConstantPool;
import org.cnt.java.classfile.bytecode.attribute.AttributeInfo;
import org.cnt.java.classfile.bytecode.attribute.AttributeInfoBuilder;
import org.cnt.java.classfile.bytecode.constantpool.util.Index2;
import org.cnt.java.classfile.bytecode.field.util.Count2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class FieldInfo {

	private int offset;
	private byte[] bytes;
	private ConstantPool constantPool;
	
	private FieldAccessFlags accessFlags;
	private Index2 nameIndex;
	private Index2 descriptorIndex;
	private Count2 attributesCount;
	private AttributeInfo[] attributes;
	
	public FieldInfo(byte[] bytes, int offset, ConstantPool constantPool) {
		this.bytes = bytes;
		this.offset = offset;
		this.constantPool = constantPool;
	}
	
	public int parse() {
		accessFlags = new FieldAccessFlags(bytes, offset);
		offset = accessFlags.parse();
		nameIndex = new Index2(bytes, offset);
		offset = nameIndex.parse();
		descriptorIndex = new Index2(bytes, offset);
		offset = descriptorIndex.parse();
		attributesCount = new Count2(bytes, offset);
		offset = attributesCount.parse();
		attributes = new AttributeInfo[attributesCount.getCount()];
		AttributeInfoBuilder builder = AttributeInfoBuilder.newBuilder(bytes, constantPool);
		for (int i = 0, len = attributes.length; i < len; i++) {
			attributes[i] = builder.build(offset);
			offset = attributes[i].parse();
		}
		return offset;
	}
}
