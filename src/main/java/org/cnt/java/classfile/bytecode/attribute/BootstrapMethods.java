package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.attribute.util.BootstrapMethod;
import org.cnt.java.classfile.bytecode.attribute.util.Num2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class BootstrapMethods extends AttributeInfo {
	
	private Num2 numBootstrapMethods;
	private BootstrapMethod[] bootstrapMethods;
	
	public BootstrapMethods(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		numBootstrapMethods = new Num2(bytes, offset);
		offset = numBootstrapMethods.parse();
		bootstrapMethods = new BootstrapMethod[numBootstrapMethods.getNum()];
		for (int i = 0, len = bootstrapMethods.length; i < len; i++) {
			bootstrapMethods[i] = new BootstrapMethod(bytes, offset);
			offset = bootstrapMethods[i].parse();
		}
		return offset;
	}
	
}
