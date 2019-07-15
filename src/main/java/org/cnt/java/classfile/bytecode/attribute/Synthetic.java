package org.cnt.java.classfile.bytecode.attribute;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class Synthetic extends AttributeInfo {

	public Synthetic(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		return super.parse();
	}
}
