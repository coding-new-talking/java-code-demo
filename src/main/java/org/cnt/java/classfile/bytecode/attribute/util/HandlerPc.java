package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class HandlerPc {
	
	private U2 u2;
	
	public HandlerPc(byte[] bytes, int offset) {
		this.u2 = new U2(bytes, offset);
	}
	
	public int parse() {
		return u2.parse();
	}
	
	public int getHandlerPc() {
		return u2.getValue();
	}

	@Override
	public String toString() {
		return "HandlerPc [getHandlerPc()=" + getHandlerPc() + "]";
	}
}
