package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.classfile.bytecode.constantpool.util.ByteString;
import org.cnt.java.classfile.bytecode.constantpool.util.Length2;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantUtf8 extends ConstantEntry {

	private Length2 length2;
	private ByteString byteString;
	
	public ConstantUtf8(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		length2 = new Length2(bytes, offset);
		offset = length2.parse();
		byteString = new ByteString(bytes, offset, length2.getLength());
		offset = byteString.parse();
		return offset;
	}
	
	public int getLength() {
		return length2.getLength();
	}
	
	public String getString() {
		return byteString.getString();
	}

	@Override
	public String toString() {
		return "ConstantUtf8 [getLength()=" + getLength() + ", getString()=" + getString() + ", getTag()=" + getTag()
				+ "]";
	}
}
