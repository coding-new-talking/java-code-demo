package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.attribute.util.TargetType;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class TargetInfoUnion {

	private byte[] bytes;
	private int offset;
	private TargetType targetType;
	
	public TargetInfoUnion(byte[] bytes, int offset, TargetType targetType) {
		this.bytes = bytes;
		this.offset = offset;
		this.targetType = targetType;
	}
	
	public int parse() {
		return offset;
	}
}
