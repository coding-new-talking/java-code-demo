package org.cnt.java.classfile.bytecode;

import org.cnt.java.classfile.bytecode.attribute.AttributeInfo;
import org.cnt.java.classfile.bytecode.attribute.AttributeInfoBuilder;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class Attributes {

	private int offset;
	private byte[] bytes;
	
	private int attributesCount;
	private ConstantPool constantPool;

	private AttributeInfo[] attributes;
	
	public Attributes(byte[] bytes, int offset, int attributesCount, ConstantPool constantPool) {
		this.bytes = bytes;
		this.offset = offset;
		this.attributesCount = attributesCount;
		this.constantPool = constantPool;
	}
	
	public int parse() {
		attributes = new AttributeInfo[attributesCount];
		AttributeInfoBuilder builder = AttributeInfoBuilder.newBuilder(bytes, constantPool);
		for (int i = 0, len = attributes.length; i < len; i++) {
			attributes[i] = builder.build(offset);
			offset = attributes[i].parse();
		}
		return offset;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Attributes [\r\n");
		for (int i = 0, len = attributes.length; i < len; i++) {
			sb.append("#" + i).append(" = ")
				.append(attributes[i]).append("\r\n");
		}
		sb.append("]");
		return sb.toString();
	}
}
