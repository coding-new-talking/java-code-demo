package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.attribute.util.TypeArgumentIndex;
import org.cnt.java.classfile.bytecode.attribute.util.TypePathKind;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class Path {

	private byte[] bytes;
	private int offset;
	
	private TypePathKind typePathKind;
	private TypeArgumentIndex typeArgumentIndex;
	
	public Path(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		typePathKind = new TypePathKind(bytes, offset);
		offset = typePathKind.parse();
		typeArgumentIndex = new TypeArgumentIndex(bytes, offset);
		offset = typeArgumentIndex.parse();
		return offset;
	}
}
