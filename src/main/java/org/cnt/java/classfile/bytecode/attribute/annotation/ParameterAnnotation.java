package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.attribute.util.Num2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class ParameterAnnotation {

	private byte[] bytes;
	private int offset;
	
	private Num2 numAnnotations;
	private Annotation[] annotations;
	
	public ParameterAnnotation(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		numAnnotations = new Num2(bytes, offset);
		offset = numAnnotations.parse();
		annotations = new Annotation[numAnnotations.getNum()];
		for (int i = 0, len = annotations.length; i < len; i++) {
			annotations[i] = new Annotation(bytes, offset);
			offset = annotations[i].parse();
		}
		return offset;
	}
}
