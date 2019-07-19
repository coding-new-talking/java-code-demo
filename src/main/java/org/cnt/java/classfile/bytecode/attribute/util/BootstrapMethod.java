package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class BootstrapMethod {
	
	private byte[] bytes;
	private int offset;
	
	private Index2 bootstrapMethodRef;
	private Num2 numBootstrapArguments;
	private Index2[] bootstrapArguments;
	
	public BootstrapMethod(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		bootstrapMethodRef = new Index2(bytes, offset);
		offset = bootstrapMethodRef.parse();
		numBootstrapArguments = new Num2(bytes, offset);
		offset = numBootstrapArguments.parse();
		bootstrapArguments = new Index2[numBootstrapArguments.getNum()];
		for (int i = 0, len = bootstrapArguments.length; i < len; i++) {
			bootstrapArguments[i] = new Index2(bytes, offset);
			offset = bootstrapArguments[i].parse();
		}
		return offset;
	}
	
}