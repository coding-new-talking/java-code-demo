package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.attribute.util.Classes;
import org.cnt.java.classfile.bytecode.attribute.util.Num2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class InnerClasses extends AttributeInfo {
	
	private Num2 numberOfClasses;
	private Classes[] classes;
	
	public InnerClasses(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		numberOfClasses = new Num2(bytes, offset);
		offset = numberOfClasses.parse();
		classes = new Classes[numberOfClasses.getNum()];
		for (int i = 0, len = classes.length; i < len; i++) {
			classes[i] = new Classes(bytes, offset);
			offset = classes[i].parse();
		}
		return offset;
	}
	
}
