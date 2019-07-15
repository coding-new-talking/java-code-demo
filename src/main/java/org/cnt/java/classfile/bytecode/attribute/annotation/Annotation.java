package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.attribute.util.Num2;
import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class Annotation {

	private byte[] bytes;
	private int offset;
	
	private Index2 typeIndex;
	private Num2 numElementValuePairs;
	private ElementValuePair[] elementValuePairs;
	
	public Annotation(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		typeIndex = new Index2(bytes, offset);
		offset = typeIndex.parse();
		numElementValuePairs = new Num2(bytes, offset);
		offset = numElementValuePairs.parse();
		elementValuePairs = new ElementValuePair[numElementValuePairs.getNum()];
		for (int i = 0, len = elementValuePairs.length; i < len; i++) {
			elementValuePairs[i] = new ElementValuePair(bytes, offset);
			offset = elementValuePairs[i].parse();
		}
		return offset;
	}
}
