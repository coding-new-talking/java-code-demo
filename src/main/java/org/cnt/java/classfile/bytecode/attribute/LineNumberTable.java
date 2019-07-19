package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.attribute.util.LineNumTable;
import org.cnt.java.classfile.bytecode.constantpool.util.Length2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class LineNumberTable extends AttributeInfo {
	
	private Length2 lineNumTableLength;
	private LineNumTable[] lineNumTables;
	
	public LineNumberTable(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		lineNumTableLength = new Length2(bytes, offset);
		offset = lineNumTableLength.parse();
		lineNumTables = new LineNumTable[lineNumTableLength.getLength()];
		for (int i = 0, len = lineNumTables.length; i < len; i++) {
			lineNumTables[i] = new LineNumTable(bytes, offset);
			offset = lineNumTables[i].parse();
		}
		return offset;
	}
	
}
