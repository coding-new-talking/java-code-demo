package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.attribute.util.Length1;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class TypePath {

	private byte[] bytes;
	private int offset;
	
	private Length1 pathLength;
	private Path[] paths;
	
	public TypePath(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		pathLength = new Length1(bytes, offset);
		offset = pathLength.parse();
		paths = new Path[pathLength.getLength()];
		for (int i = 0, len = paths.length; i < len; i++) {
			paths[i] = new Path(bytes, offset);
			offset = paths[i].parse();
		}
		return offset;
	}
}
