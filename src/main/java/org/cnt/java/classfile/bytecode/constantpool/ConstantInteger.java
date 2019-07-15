package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.classfile.bytecode.constantpool.util.Byte4;
import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantInteger extends ConstantEntry {
	
	private Byte4 byte4;
	
	public ConstantInteger(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		byte4 = new Byte4(bytes, offset);
		offset = byte4.parse();
		return offset;
	}

	public int getInt() {
		return Byter.toSigned(byte4.getByte3(), byte4.getByte2(), byte4.getByte1(), byte4.getByte0());
	}

	@Override
	public String toString() {
		return "ConstantInteger [getInt()=" + getInt() + ", getTag()=" + getTag() + "]";
	}
}
