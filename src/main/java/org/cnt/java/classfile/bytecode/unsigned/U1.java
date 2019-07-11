package org.cnt.java.classfile.bytecode.unsigned;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class U1 {
	
	private int offset;
	private int length = 1;
	private byte[] bytes;
	
	private int value;
	private byte _byte;
	
	public U1(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		value = Byter.toUnsigned(bytes, offset, length);
		_byte = bytes[offset];
		return offset + length;
	}
	
	public int getValue() {
		return value;
	}
	
	public byte getByte() {
		return _byte;
	}
	
	public byte[] getBytes() {
		return new byte[] {_byte};
	}
}
