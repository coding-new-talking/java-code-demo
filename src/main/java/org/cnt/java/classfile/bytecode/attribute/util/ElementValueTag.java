package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U1;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ElementValueTag {
	
	private U1 u1;
	
	public ElementValueTag(byte[] bytes, int offset) {
		this.u1 = new U1(bytes, offset);
	}
	
	public int parse() {
		return u1.parse();
	}
	
	public int getTag() {
		return u1.getValue();
	}

	@Override
	public String toString() {
		return "ElementValueTag [getTag()=" + getTag() + "]";
	}
	
	public boolean isConstant() {
		int tag = getTag();
		return tag == Byte_Tag
				|| tag == Char_Tag
				|| tag == Double_Tag
				|| tag == Float_Tag
				|| tag == Int_Tag
				|| tag == Long_Tag
				|| tag == Short_Tag
				|| tag == Boolean_Tag
				|| tag == String_Tag;
	}
	
	public boolean isEnum() {
		return getTag() == Enum_Tag;
	}
	
	public boolean isClass() {
		return getTag() == Class_Tag;
	}
	
	public boolean isAnnotation() {
		return getTag() == Annotation_Tag;
	}
	
	public boolean isArray() {
		return getTag() == Array_Tag;
	}
	
	public static final char Byte_Tag = 'B';
	public static final char Char_Tag = 'C';
	public static final char Double_Tag = 'D';
	public static final char Float_Tag = 'F';
	public static final char Int_Tag = 'I';
	public static final char Long_Tag = 'J';
	public static final char Short_Tag = 'S';
	public static final char Boolean_Tag = 'Z';
	public static final char String_Tag = 's';
	public static final char Enum_Tag = 'e';
	public static final char Class_Tag = 'c';
	public static final char Annotation_Tag = '@';
	public static final char Array_Tag = '[';
}
