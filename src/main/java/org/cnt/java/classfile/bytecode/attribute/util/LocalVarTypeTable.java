package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;
import org.cnt.java.classfile.bytecode.constantpool.util.Length2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class LocalVarTypeTable {
	
	private byte[] bytes;
	private int offset;
	
	private StartPc startPc;
	private Length2 length;
	private Index2 nameIndex;
	private Index2 signatureIndex;
	private Index2 index;
	
	public LocalVarTypeTable(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		startPc = new StartPc(bytes, offset);
		offset = startPc.parse();
		length = new Length2(bytes, offset);
		offset = length.parse();
		nameIndex = new Index2(bytes, offset);
		offset = nameIndex.parse();
		signatureIndex = new Index2(bytes, offset);
		offset = signatureIndex.parse();
		index = new Index2(bytes, offset);
		offset = index.parse();
		return offset;
	}
	
	public int getStartPc() {
		return startPc.getStartPc();
	}
	
	public int getLength() {
		return length.getLength();
	}
	
	public int getNameIndex() {
		return nameIndex.getIndex();
	}
	
	public int getSignatureIndex() {
		return signatureIndex.getIndex();
	}
	
	public int getIndex() {
		return index.getIndex();
	}
}
