package org.cnt.java.classfile.bytecode.constantpool.entry;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantEntryBuilder {
	
	public static final int ConstantClass_Tag = 7;
	public static final int ConstantFieldRef_Tag = 9;
	public static final int ConstantMethodRef_Tag = 10;
	public static final int ConstantInterfaceMethodRef_Tag = 11;
	public static final int ConstantString_Tag = 8;
	public static final int ConstantInteger_Tag = 3;
	public static final int ConstantFloat_Tag = 4;
	public static final int ConstantLong_Tag = 5;
	public static final int ConstantDouble_Tag = 6;
	public static final int ConstantNameAndType_Tag = 12;
	public static final int ConstantUtf8_Tag = 1;
	public static final int ConstantMethodHandle_Tag = 15;
	public static final int ConstantMethodType_Tag = 16;
	public static final int ConstantInvokeDynamic_Tag = 18;
	
	public static ConstantEntry build(byte[] bytes, int offset) {
		int tag = Byter.toUnsigned(bytes[offset]);
		switch (tag) {
			case ConstantClass_Tag:
				return new ConstantClass(bytes, offset);
			case ConstantFieldRef_Tag:
				return new ConstantFieldRef(bytes, offset);
			case ConstantMethodRef_Tag:
				return new ConstantMethodRef(bytes, offset);
			case ConstantInterfaceMethodRef_Tag:
				return new ConstantInterfaceMethodRef(bytes, offset);
			case ConstantString_Tag:
				return new ConstantString(bytes, offset);
			case ConstantInteger_Tag:
				return new ConstantInteger(bytes, offset);
			case ConstantFloat_Tag:
				return new ConstantFloat(bytes, offset);
			case ConstantLong_Tag:
				return new ConstantLong(bytes, offset);
			case ConstantDouble_Tag:
				return new ConstantDouble(bytes, offset);
			case ConstantNameAndType_Tag:
				return new ConstantNameAndType(bytes, offset);
			case ConstantUtf8_Tag:
				return new ConstantUtf8(bytes, offset);
			case ConstantMethodHandle_Tag:
				return new ConstantMethodHandle(bytes, offset);
			case ConstantMethodType_Tag:
				return new ConstantMethodType(bytes, offset);
			case ConstantInvokeDynamic_Tag:
				return new ConstantInvokeDynamic(bytes, offset);
		}
		return null;
	}
}
