package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.attribute.annotation.StackMapFrame;
import org.cnt.java.classfile.bytecode.attribute.util.Num2;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class StackMapTable extends AttributeInfo {
	
	private Num2 numberOfEntries;
	private StackMapFrame[] entries;
	
	public StackMapTable(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		numberOfEntries = new Num2(bytes, offset);
		offset = numberOfEntries.parse();
		entries = new StackMapFrame[numberOfEntries.getNum()];
		for (int i = 0, len = entries.length; i < len; i++) {
			
		}
		return offset;
	}
	
}
