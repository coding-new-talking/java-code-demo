package org.cnt.java.classfile.bytecode.constantpool;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;
import org.cnt.java.classfile.bytecode.constantpool.util.RefKind;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class ConstantMethodHandle extends ConstantEntry {

	private RefKind refKind;
	private Index2 refIndex;
	
	public ConstantMethodHandle(byte[] bytes, int offset) {
		super(bytes, offset);
	}
	
	public int parse() {
		offset = tag.parse();
		refKind = new RefKind(bytes, offset);
		offset = refKind.parse();
		refIndex = new Index2(bytes, offset);
		offset = refIndex.parse();
		return offset;
	}
	
	public int getRefKind() {
		return refKind.getRefKind();
	}
	
	public int getRefIndex() {
		return refIndex.getIndex();
	}

	@Override
	public String toString() {
		return "ConstantMethodHandle [getRefKind()=" + getRefKind() + ", getRefIndex()=" + getRefIndex() + ", getTag()="
				+ getTag() + "]";
	}
}
