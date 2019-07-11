package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ByteString {
	
	private int offset;
	private int length;
	private byte[] bytes;
	
	private String string;
	
	public ByteString(byte[] bytes, int offset, int length) {
		this.bytes = bytes;
		this.offset = offset;
		this.length = length;
	}
	
	public int parse() {
		string = Byter.toString(bytes, offset, length);
		return offset + length;
	}
	
	public String getString() {
		return string;
	}

	@Override
	public String toString() {
		return "ByteString [getString()=" + getString() + "]";
	}
}
