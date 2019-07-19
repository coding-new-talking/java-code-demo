package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.attribute.util.Parameter;
import org.cnt.java.classfile.bytecode.method.util.Count1;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class MethodParameters extends AttributeInfo {
	
	private Count1 parametersCount;
	private Parameter[] parameters;
	
	public MethodParameters(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		parametersCount = new Count1(bytes, offset);
		offset = parametersCount.parse();
		parameters = new Parameter[parametersCount.getCount()];
		for (int i = 0, len = parameters.length; i < len; i++) {
			parameters[i] = new Parameter(bytes, offset);
			offset = parameters[i].parse();
		}
		return offset;
	}
	
}
