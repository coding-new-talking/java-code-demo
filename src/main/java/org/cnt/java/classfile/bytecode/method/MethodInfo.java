package org.cnt.java.classfile.bytecode.method;

import java.util.Arrays;

import org.cnt.java.classfile.bytecode.ConstantPool;
import org.cnt.java.classfile.bytecode.attribute.AttributeInfo;
import org.cnt.java.classfile.bytecode.attribute.AttributeInfoBuilder;
import org.cnt.java.classfile.bytecode.constantpool.util.Index2;
import org.cnt.java.classfile.bytecode.field.util.Count2;

/**
 * @author lixinjie
 * @since 2019-07-16
 */
public class MethodInfo {

	private int offset;
	private byte[] bytes;
	private ConstantPool constantPool;

	private MethodAccessFlags accessFlags;
	private Index2 nameIndex;
	private Index2 descriptorIndex;
	private Count2 attributesCount;
	private AttributeInfo[] attributes;
	
	public MethodInfo(byte[] bytes, int offset, ConstantPool constantPool) {
		this.bytes = bytes;
		this.offset = offset;
		this.constantPool = constantPool;
	}
	
	public int parse() {
		accessFlags = new MethodAccessFlags(bytes, offset);
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
	
	public int getAccessFlags() {
		return accessFlags.getAccessFlags();
	}

	public int getNameIndex() {
		return nameIndex.getIndex();
	}

	public int getDescriptorIndex() {
		return descriptorIndex.getIndex();
	}

	public int getAttributesCount() {
		return attributesCount.getCount();
	}

	public AttributeInfo[] getAttributes() {
		return attributes;
	}

	@Override
	public String toString() {
		return "MethodInfo [getAccessFlags()=0x" + Integer.toHexString(getAccessFlags()) + ", getNameIndex()=" + getNameIndex()
				+ ", getDescriptorIndex()=" + getDescriptorIndex() + ", getAttributesCount()=" + getAttributesCount()
				+ ", getAttributes()=" + Arrays.toString(getAttributes()) + "]";
	}
	
}
