package org.cnt.java.classfile.bytecode.unsigned;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class U4 {
	
	private int offset;
	private int length = 4;
	private byte[] bytes;
	
	private long value;
	private byte byte3;
	private byte byte2;
	private byte byte1;
	private byte byte0;
	
	public U4(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		value = Byter.toUnsignedLong(bytes, offset, length);
		byte3 = bytes[offset + 0];
		byte2 = bytes[offset + 1];
		byte1 = bytes[offset + 2];
		byte0 = bytes[offset + 3];
		return offset + length;
	}
	
	public long getValue() {
		return value;
	}
	
	public byte getByte0() {
		return byte0;
	}
	
	public byte getByte1() {
		return byte1;
	}
	
	public byte getByte2() {
		return byte2;
	}
	
	public byte getByte3() {
		return byte3;
	}
	
	public byte[] getBytes() {
		return new byte[] {byte3, byte2, byte1, byte0};
	}
}
