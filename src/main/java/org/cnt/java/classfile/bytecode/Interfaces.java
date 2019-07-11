package org.cnt.java.classfile.bytecode;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class Interfaces {
	
	private int interfacesCount;
	private byte[] bytes;
	private int offset;
	
	private U2[] u2s;
	
	public Interfaces(byte[] bytes, int offset, int interfacesCount) {
		this.bytes = bytes;
		this.offset = offset;
		this.interfacesCount = interfacesCount;
	}
	
	public int parse() {
		u2s = new U2[interfacesCount];
		for (int i = 0; i < interfacesCount; i++) {
			u2s[i] = new U2(bytes, offset);
			offset = u2s[i].parse();
		}
		return offset;
	}

	public int[] getClassIndexes() {
		int[] indexes = new int[interfacesCount];
		for (int i = 0; i < interfacesCount; i++) {
			indexes[i] = u2s[i].getValue();
		}
		return indexes;
	}
}
