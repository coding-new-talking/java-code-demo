package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.attribute.util.LocalVarTypeTable;
import org.cnt.java.classfile.bytecode.constantpool.util.Length2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class LocalVariableTypeTable extends AttributeInfo {
	
	private Length2 localVarTypeTableLength;
	private LocalVarTypeTable[] localVarTypeTables;
	
	public LocalVariableTypeTable(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		localVarTypeTableLength = new Length2(bytes, offset);
		offset = localVarTypeTableLength.parse();
		localVarTypeTables = new LocalVarTypeTable[localVarTypeTableLength.getLength()];
		for (int i = 0, len = localVarTypeTables.length; i < len; i++) {
			localVarTypeTables[i] = new LocalVarTypeTable(bytes, offset);
			offset = localVarTypeTables[i].parse();
		}
		return offset;
	}
	
}
