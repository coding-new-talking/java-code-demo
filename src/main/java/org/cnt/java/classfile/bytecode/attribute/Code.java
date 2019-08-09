package org.cnt.java.classfile.bytecode.attribute;

import java.util.Arrays;

import org.cnt.java.classfile.bytecode.ConstantPool;
import org.cnt.java.classfile.bytecode.attribute.util.ExceptionTable;
import org.cnt.java.classfile.bytecode.attribute.util.JvmCode;
import org.cnt.java.classfile.bytecode.attribute.util.Length4;
import org.cnt.java.classfile.bytecode.attribute.util.Num2;
import org.cnt.java.classfile.bytecode.constantpool.util.Length2;
import org.cnt.java.classfile.bytecode.field.util.Count2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class Code extends AttributeInfo {
	
	private ConstantPool constantPool;
	
	private Num2 maxStack;
	private Num2 maxLocals;
	private Length4 codeLength;
	private JvmCode jvmCode;
	private Length2 exceptionTableLength;
	private ExceptionTable[] exceptionTables;
	private Count2 attributesCount;
	private AttributeInfo[] attributes;
	
	public Code(byte[] bytes, int offset, ConstantPool constantPool) {
		super(bytes, offset);
		this.constantPool = constantPool;
	}

	public int parse() {
		offset = super.parse();
		maxStack = new Num2(bytes, offset);
		offset = maxStack.parse();
		maxLocals = new Num2(bytes, offset);
		offset = maxLocals.parse();
		codeLength = new Length4(bytes, offset);
		offset = codeLength.parse();
		jvmCode = new JvmCode(bytes, offset, (int)codeLength.getLength());
		offset = jvmCode.parse();
		exceptionTableLength = new Length2(bytes, offset);
		offset = exceptionTableLength.parse();
		exceptionTables = new ExceptionTable[exceptionTableLength.getLength()];
		for (int i = 0, len = exceptionTables.length; i < len; i++) {
			exceptionTables[i] = new ExceptionTable(bytes, offset);
			offset = exceptionTables[i].parse();
		}
		attributesCount = new Count2(bytes, offset);
		offset = attributesCount.parse();
		attributes = new AttributeInfo[attributesCount.getCount()];
		AttributeInfoBuilder builder = AttributeInfoBuilder.newBuilder(bytes, constantPool);
		for (int i = 0, len = attributes.length; i < len; i++) {
			attributes[i] = builder.build(offset);
			offset = attributes[i].parse();
		}
		return offset;
	}
	
	public int getMaxStack() {
		return maxStack.getNum();
	}
	
	public int getMaxLocals() {
		return maxLocals.getNum();
	}
	
	public long getCodeLength() {
		return codeLength.getLength();
	}
	
	public JvmCode getJvmCode() {
		return jvmCode;
	}
	
	public int getExceptionTableLength() {
		return exceptionTableLength.getLength();
	}
	
	public ExceptionTable[] getExceptionTables() {
		return exceptionTables;
	}
	
	public int getAttributesCount() {
		return attributesCount.getCount();
	}
	
	public AttributeInfo[] getAttributes() {
		return attributes;
	}

	@Override
	public String toString() {
		return "Code [getMaxStack()=" + getMaxStack() + ", getMaxLocals()=" + getMaxLocals() + ", getCodeLength()="
				+ getCodeLength() + ", getJvmCode()=" + getJvmCode() + ", getExceptionTableLength()="
				+ getExceptionTableLength() + ", getExceptionTables()=" + Arrays.toString(getExceptionTables())
				+ ", getAttributesCount()=" + getAttributesCount() + ", getAttributes()="
				+ Arrays.toString(getAttributes()) + "]";
	}
}
