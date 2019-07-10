package org.cnt.java.classfile.bytecode;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-10
 */
public class Magic {

	public int offset = 0;
	public int length = 4;
	
	private byte[] bytes;
	public long magic;
	
	public Magic(byte[] bytes) {
		this.bytes = bytes;
	}
	
	public int parse() {
		magic = Byter.toUnsignedLong(bytes, offset, length);
		return offset + length;
	}
}
