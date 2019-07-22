package org.cnt.java.classfile.bytecode.attribute;

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
		attributes = new AttributeInfo[attributesCount.getCount()];
		AttributeInfoBuilder builder = AttributeInfoBuilder.newBuilder(bytes, constantPool);
		for (int i = 0, len = attributes.length; i < len; i++) {
			attributes[i] = builder.build(offset);
			offset = attributes[i].parse();
		}
		return offset;
	}
	
}
