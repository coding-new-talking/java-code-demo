package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.unsigned.U1;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class TargetType {
	
	private U1 u1;
	
	public TargetType(byte[] bytes, int offset) {
		this.u1 = new U1(bytes, offset);
	}
	
	public int parse() {
		return u1.parse();
	}
	
	public int getTargetType() {
		return u1.getValue();
	}

	@Override
	public String toString() {
		return "TargetType [getTargetType()=" + getTargetType() + "]";
	}
	
	public boolean isTypeParameterTarget() {
		int type = getTargetType();
		return type == 0x00 || type == 0x01;
	}
	
	public boolean isSupertypeTarget() {
		return getTargetType() == 0x10;
	}
	
	public boolean isTypeParameterBoundTarget() {
		int type = getTargetType();
		return type == 0x11 || type == 0x12;
	}
	
	public boolean isEmptyTarget() {
		int type = getTargetType();
		return type == 0x13 || type == 0x14 || type == 0x15;
	}
	
	public boolean isFormalParameterTarget() {
		return getTargetType() == 0x16;
	}
	
	public boolean isThrowsTarget() {
		return getTargetType() == 0x17;
	}
	
	public boolean isLocalVarTarget() {
		int type = getTargetType();
		return type == 0x40 || type == 0x41;
	}
	
	public boolean isCatchTarget() {
		return getTargetType() == 0x42;
	}
	
	public boolean isOffsetTarget() {
		int type = getTargetType();
		return type == 0x43 || type == 0x44 || type == 0x45 || type == 0x46;
	}
	
	public boolean isTypeArgumentTarget() {
		int type = getTargetType();
		return type == 0x47 || type == 0x48 || type == 0x49 || type == 0x4A || type == 0x4B;
	}
}
