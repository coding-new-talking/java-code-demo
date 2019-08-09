package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.attribute.annotation.ElementValue;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class AnnotationDefault extends AttributeInfo {
	
	private ElementValue defaultValue;

	public AnnotationDefault(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		defaultValue = new ElementValue(bytes, offset);
		offset = defaultValue.parse();
		return offset;
	}
	
}
