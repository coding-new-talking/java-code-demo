package org.cnt.java.classfile.bytecode.field;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;
import org.cnt.java.classfile.bytecode.field.util.Count2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class FieldInfo {

	private int offset;
	private byte[] bytes;
	
	private FieldAccessFlags accessFlags;
	private Index2 nameIndex;
	private Index2 descriptorIndex;
	private Count2 attributesCount;
	
	
	public FieldInfo(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		accessFlags = new FieldAccessFlags(bytes, offset);
		offset = accessFlags.parse();
		nameIndex = new Index2(bytes, offset);
		offset = nameIndex.parse();
		descriptorIndex = new Index2(bytes, offset);
		offset = descriptorIndex.parse();
		attributesCount = new Count2(bytes, offset);
		offset = attributesCount.parse();
		return offset;
	}
}
