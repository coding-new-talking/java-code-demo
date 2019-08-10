package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-08-10
 */
public class VariableInfoBuilder {

	private byte[] bytes;
	
	private VariableInfoBuilder(byte[] bytes) {
		this.bytes = bytes;
	}
	
	public static VariableInfoBuilder newBuilder(byte[] bytes) {
		return new VariableInfoBuilder(bytes);
	}
	
	public VariableInfo build(int offset) {
		int tag = Byter.toUnsigned(bytes[offset]);
		switch (tag) {
			case ITEM_Top:
				return new TopVariableInfo(bytes, offset);
			case ITEM_Integer:
				return new IntegerVariableInfo(bytes, offset);
			case ITEM_Float:
				return new FloatVariableInfo(bytes, offset);
			case ITEM_Null:
				return new NullVariableInfo(bytes, offset);
			case ITEM_UninitializedThis:
				return new UninitializedThisVariableInfo(bytes, offset);
			case ITEM_Object:
				return new ObjectVariableInfo(bytes, offset);
			case ITEM_Uninitialized:
				return new UninitializedVariableInfo(bytes, offset);
			case ITEM_Long:
				return new LongVariableInfo(bytes, offset);
			case ITEM_Double:
				return new DoubleVariableInfo(bytes, offset);
		}
		throw new RuntimeException("tag=" + tag);
	}
	
	public static final int ITEM_Top = 0;
	public static final int ITEM_Integer = 1;
	public static final int ITEM_Float = 2;
	public static final int ITEM_Null = 5;
	public static final int ITEM_UninitializedThis = 6;
	public static final int ITEM_Object = 7;
	public static final int ITEM_Uninitialized = 8;
	public static final int ITEM_Long = 4;
	public static final int ITEM_Double = 3;
}
