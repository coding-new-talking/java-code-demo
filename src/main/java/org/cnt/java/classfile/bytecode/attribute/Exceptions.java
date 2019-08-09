package org.cnt.java.classfile.bytecode.attribute;

import java.util.Arrays;

import org.cnt.java.classfile.bytecode.attribute.util.Num2;
import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class Exceptions extends AttributeInfo {
	
	private Num2 numberOfExceptions;
	private Index2[] exceptionIndexTable;
	
	public Exceptions(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		numberOfExceptions = new Num2(bytes, offset);
		offset = numberOfExceptions.parse();
		exceptionIndexTable = new Index2[numberOfExceptions.getNum()];
		for (int i = 0, len = exceptionIndexTable.length; i < len; i++) {
			exceptionIndexTable[i] = new Index2(bytes, offset);
			offset = exceptionIndexTable[i].parse();
		}
		return offset;
	}

	public int getNumberOfExceptions() {
		return numberOfExceptions.getNum();
	}

	public int[] getExceptionIndexTable() {
		int[] indexTable = new int[exceptionIndexTable.length];
		for (int i = 0; i < exceptionIndexTable.length; i++) {
			indexTable[i] = exceptionIndexTable[i].getIndex();
		}
		return indexTable;
	}

	@Override
	public String toString() {
		return "Exceptions [getNumberOfExceptions()=" + getNumberOfExceptions() + ", getExceptionIndexTable()="
				+ Arrays.toString(getExceptionIndexTable()) + "]";
	}
	
}
