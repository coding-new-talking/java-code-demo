package org.cnt.java.classfile.bytecode.attribute;

import java.util.Arrays;

import org.cnt.java.classfile.bytecode.attribute.util.LocalVarTable;
import org.cnt.java.classfile.bytecode.constantpool.util.Length2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class LocalVariableTable extends AttributeInfo {
	
	private Length2 localVarTableLength;
	private LocalVarTable[] localVarTables;
	
	public LocalVariableTable(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		localVarTableLength = new Length2(bytes, offset);
		offset = localVarTableLength.parse();
		localVarTables = new LocalVarTable[localVarTableLength.getLength()];
		for (int i = 0, len = localVarTables.length; i < len; i++) {
			localVarTables[i] = new LocalVarTable(bytes, offset);
			offset = localVarTables[i].parse();
		}
		return offset;
	}

	public int getLocalVarTableLength() {
		return localVarTableLength.getLength();
	}

	public LocalVarTable[] getLocalVarTables() {
		return localVarTables;
	}

	@Override
	public String toString() {
		return "LocalVariableTable [getLocalVarTableLength()=" + getLocalVarTableLength() + ", getLocalVarTables()="
				+ Arrays.toString(getLocalVarTables()) + "]";
	}
	
}
