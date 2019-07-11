package org.cnt.java.classfile.bytecode.unsigned;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class U2 {
	
	private int offset;
	private int length = 2;
	private byte[] bytes;
	
	private int value;
	private byte byte0;
	private byte byte1;
	
	public U2(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		value = Byter.toUnsigned(bytes, offset, length);
		byte0 = bytes[offset + 0];
		byte1 = bytes[offset + 1];
		return offset + length;
	}
	
	public int getValue() {
		return value;
	}
	
	public byte getByte0() {
		return byte0;
	}
	
	public byte getByte1() {
		return byte1;
	}
	
	public byte[] getBytes() {
		return new byte[] {byte0, byte1};
	}
}
