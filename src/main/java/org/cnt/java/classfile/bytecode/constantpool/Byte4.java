package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.classfile.bytecode.unsigned.U4;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class Byte4 {
	
	private U4 u4;
	
	public Byte4(byte[] bytes, int offset) {
		this.u4 = new U4(bytes, offset);
	}
	
	public int parse() {
		return u4.parse();
	}
	
	public long getValue() {
		return u4.getValue();
	}
	
	public byte getByte0() {
		return u4.getByte0();
	}
	
	public byte getByte1() {
		return u4.getByte1();
	}
	
	public byte getByte2() {
		return u4.getByte2();
	}
	
	public byte getByte3() {
		return u4.getByte3();
	}
	
	public byte[] getBytes() {
		return u4.getBytes();
	}
}
