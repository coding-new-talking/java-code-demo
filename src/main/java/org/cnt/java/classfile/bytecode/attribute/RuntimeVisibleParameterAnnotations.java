package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.attribute.annotation.ParameterAnnotation;
import org.cnt.java.classfile.bytecode.attribute.util.Num1;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class RuntimeVisibleParameterAnnotations extends AttributeInfo {

	private Num1 numParameters;
	private ParameterAnnotation[] parameterAnnotations;
	
	public RuntimeVisibleParameterAnnotations(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		numParameters = new Num1(bytes, offset);
		offset = numParameters.parse();
		parameterAnnotations = new ParameterAnnotation[numParameters.getNum()];
		for (int i = 0, len = parameterAnnotations.length; i < len; i++) {
			parameterAnnotations[i] = new ParameterAnnotation(bytes, offset);
			offset = parameterAnnotations[i].parse();
		}
		return offset;
	}
}
