package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U1;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class FrameType {
	
	private U1 u1;
	
	public FrameType(byte[] bytes, int offset) {
		this.u1 = new U1(bytes, offset);
	}
	
	public int parse() {
		return u1.parse();
	}
	
	public int getFrameType() {
		return u1.getValue();
	}

	@Override
	public String toString() {
		return "FrameType [getFrameType()=" + getFrameType() + "]";
	}
}
