package org.cnt.java.classfile.bytecode;

import org.cnt.java.classfile.bytecode.unsigned.U4;

/**
 * @author lixinjie
 * @since 2019-07-10
 */
public class Magic {

	private U4 u4;
	
	public Magic(byte[] bytes, int offset) {
		this.u4 = new U4(bytes, offset);
	}
	
	public int parse() {
		return u4.parse();
	}

	public long getMagic() {
		return u4.getValue();
	}
}
