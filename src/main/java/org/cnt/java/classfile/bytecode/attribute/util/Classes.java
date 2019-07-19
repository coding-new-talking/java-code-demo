package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class Classes {
	
	private byte[] bytes;
	private int offset;
	
	private Index2 innerClassInfoIndex;
	private Index2 outerClassInfoIndex;
	private Index2 innerNameIndex;
	private InnerClassAccessFlags accessFlags;
	
	public Classes(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		innerClassInfoIndex = new Index2(bytes, offset);
		offset = innerClassInfoIndex.parse();
		outerClassInfoIndex = new Index2(bytes, offset);
		offset = outerClassInfoIndex.parse();
		innerNameIndex = new Index2(bytes, offset);
		offset = innerNameIndex.parse();
		accessFlags = new InnerClassAccessFlags(bytes, offset);
		offset = accessFlags.parse();
		return offset;
	}
	
}
