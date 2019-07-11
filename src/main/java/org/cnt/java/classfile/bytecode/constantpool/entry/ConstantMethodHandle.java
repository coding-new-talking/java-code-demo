package org.cnt.java.classfile.bytecode.constantpool.entry;

import org.cnt.java.classfile.bytecode.constantpool.Index;
import org.cnt.java.classfile.bytecode.constantpool.RefKind;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantMethodHandle extends ConstantEntry {

	private RefKind refKind;
	private Index refIndex;
	
	public ConstantMethodHandle(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		refKind = new RefKind(bytes, offset);
		offset = refKind.parse();
		refIndex = new Index(bytes, offset);
		offset = refIndex.parse();
		return offset;
	}
	
	public int getRefKind() {
		return refKind.getRefKind();
	}
	
	public int getRefIndex() {
		return refIndex.getIndex();
	}
}
