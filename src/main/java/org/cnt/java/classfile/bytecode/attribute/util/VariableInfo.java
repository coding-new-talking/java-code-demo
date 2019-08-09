package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public abstract class VariableInfo {

	protected byte[] bytes;
	protected int offset;
	
	protected VariableInfoTag tag;
	
	public VariableInfo(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		tag = new VariableInfoTag(bytes, offset);
		offset = tag.parse();
		return offset;
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
