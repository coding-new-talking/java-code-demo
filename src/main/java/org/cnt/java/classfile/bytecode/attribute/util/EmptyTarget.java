package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class EmptyTarget {

	@SuppressWarnings("unused")
	private byte[] bytes;
	private int offset;
	
	public EmptyTarget(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		return offset;
	}
}
