package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class UninitializedVariableInfo extends VariableInfo {

	private Offset2 _offset;
	
	public UninitializedVariableInfo(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		_offset = new Offset2(bytes, offset);
		offset = _offset.parse();
		return offset;
	}
	
	public int getOffset() {
		return _offset.getOffset();
	}
}
