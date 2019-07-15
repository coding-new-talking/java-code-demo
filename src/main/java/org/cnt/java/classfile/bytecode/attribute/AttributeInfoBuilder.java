package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.ConstantPool;
import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class AttributeInfoBuilder {

	private byte[] bytes;
	private ConstantPool constantPool;
	
	private AttributeInfoBuilder(byte[] bytes, ConstantPool constantPool) {
		this.bytes = bytes;
		this.constantPool = constantPool;
	}
	
	public static AttributeInfoBuilder newBuilder(byte[] bytes, ConstantPool constantPool) {
		return new AttributeInfoBuilder(bytes, constantPool);
	}
	
	public AttributeInfo build(int offset) {
		int attributeNameIndex = Byter.toUnsigned(bytes[offset], bytes[offset + 1]);
		String attributeName = constantPool.getConstantUtf8String(attributeNameIndex);
		switch (attributeName) {
			case ConstantValue_Attribute:
				return new ConstantValue(bytes, offset);
			case Synthetic_Attribute:
				return new Synthetic(bytes, offset);
			case Signature_Attribute:
				return new Signature(bytes, offset);
			case Deprecated_Attribute:
				return new Deprecated(bytes, offset);
			case RuntimeVisibleAnnotations_Attribute:
				return new RuntimeVisibleAnnotations(bytes, offset);
			case RuntimeInvisibleAnnotations_Attribute:
				return new RuntimeInvisibleAnnotations(bytes, offset);
			case RuntimeVisibleTypeAnnotations_Attribute:
				return new RuntimeVisibleTypeAnnotations(bytes, offset);
			case RuntimeInvisibleTypeAnnotations_Attribute:
				return new RuntimeInvisibleTypeAnnotations(bytes, offset);
		}
		return null;
	}
	
	public static final String ConstantValue_Attribute = "ConstantValue";
	public static final String Synthetic_Attribute = "Synthetic";
	public static final String Signature_Attribute = "Signature";
	public static final String Deprecated_Attribute = "Deprecated";
	public static final String RuntimeVisibleAnnotations_Attribute = "RuntimeVisibleAnnotations";
	public static final String RuntimeInvisibleAnnotations_Attribute = "RuntimeInvisibleAnnotations";
	public static final String RuntimeVisibleTypeAnnotations_Attribute = "RuntimeVisibleTypeAnnotations";
	public static final String RuntimeInvisibleTypeAnnotations_Attribute = "RuntimeInvisibleTypeAnnotations";
}
