package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.attribute.util.Num2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class RuntimeInvisibleTypeAnnotations extends AttributeInfo {

	private Num2 numAnnotations;
	
	public RuntimeInvisibleTypeAnnotations(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		numAnnotations = new Num2(bytes, offset);
		offset = numAnnotations.parse();
		
		return offset;
	}
}
