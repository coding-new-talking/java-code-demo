package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.attribute.util.Num2;
import org.cnt.java.classfile.bytecode.attribute.util.TargetType;
import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class TypeAnnotation {

	private byte[] bytes;
	private int offset;
	
	private TargetType targetType;
	private TargetInfoUnion union;
	private TypePath targetPath;
	private Index2 typeIndex;
	private Num2 numElementValuePairs;
	private ElementValuePair[] elementValuePairs;
	
	public TypeAnnotation(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		targetType = new TargetType(bytes, offset);
		offset = targetType.parse();
		union = new TargetInfoUnion(bytes, offset, targetType);
		offset = union.parse();
		targetPath = new TypePath(bytes, offset);
		offset = targetPath.parse();
		typeIndex = new Index2(bytes, offset);
		offset = typeIndex.parse();
		numElementValuePairs = new Num2(bytes, offset);
		offset = numElementValuePairs.parse();
		elementValuePairs = new ElementValuePair[numElementValuePairs.getNum()];
		for (int i = 0, len = elementValuePairs.length; i < len; i++) {
			elementValuePairs[i] = new ElementValuePair(bytes, offset);
			offset = elementValuePairs[i].parse();
		}
		return offset;
	}
}
