package org.cnt.java.classfile.bytecode;

import org.cnt.java.classfile.bytecode.method.MethodInfo;

/**
 * @author lixinjie
 * @since 2019-07-11
 */
public class Methods {

	private int methodsCount;
	private int offset;
	private byte[] bytes;
	private ConstantPool constantPool;

	private MethodInfo[] methods;
	
	public Methods(byte[] bytes, int offset, int methodsCount, ConstantPool constantPool) {
		this.bytes = bytes;
		this.offset = offset;
		this.methodsCount = methodsCount;
		this.constantPool = constantPool;
	}
	
	public int parse() {
		methods = new MethodInfo[methodsCount];
		for (int i = 0; i < methodsCount; i++) {
			methods[i] = new MethodInfo(bytes, offset, constantPool);
			offset = methods[i].parse();
		}
		return offset;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Methods [\r\n");
		for (int i = 0, len = methods.length; i < len; i++) {
			sb.append("#" + i).append(" = ")
				.append(methods[i]).append("\r\n");
		}
		sb.append("]");
		return sb.toString();
	}
}
