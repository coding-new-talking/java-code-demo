package org.cnt.java.classfile.bytecode.method;

import org.cnt.java.classfile.bytecode.unsigned.U2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class MethodAccessFlags {
	
	private U2 u2;
	
	public MethodAccessFlags(byte[] bytes, int offset) {
		this.u2 = new U2(bytes, offset);
	}
	
	public int parse() {
		return u2.parse();
	}

	public int getAccessFlags() {
		return u2.getValue();
	}
	
	@Override
	public String toString() {
		return "FieldAccessFlags [getAccessFlags()=0x" + Integer.toHexString(getAccessFlags()) + "]";
	}

	public static final int ACC_PUBLIC = 0x0001;
	public static final int ACC_PRIVATE = 0x0002;
	public static final int ACC_PROTECTED = 0x0004;
	public static final int ACC_STATIC = 0x0008;
	public static final int ACC_FINAL = 0x0010;
	public static final int ACC_SYNCHRONIZED = 0x0020;
	public static final int ACC_BRIDGE = 0x0040;
	public static final int ACC_VARARGS = 0x0080;
	public static final int ACC_NATIVE = 0x0100;
	public static final int ACC_ABSTRACT = 0x0400;
	public static final int ACC_STRICT = 0x0800;
	public static final int ACC_SYNTHETIC = 0x1000;
}
