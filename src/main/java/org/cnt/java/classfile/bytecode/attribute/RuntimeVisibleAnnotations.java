package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.attribute.annotation.Annotation;
import org.cnt.java.classfile.bytecode.attribute.util.Num2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class RuntimeVisibleAnnotations extends AttributeInfo {

	private Num2 numAnnotations;
	private Annotation[] annotations;
	
	public RuntimeVisibleAnnotations(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
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
