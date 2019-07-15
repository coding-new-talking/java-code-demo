package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.attribute.util.ElementValueTag;
import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class ElementValueUnion {

	private byte[] bytes;
	private int offset;
	private ElementValueTag tag;
	
	private Index2 constValueIndex;
	private EnumConstValue enumConstValue;
	private Index2 classInfoIndex;
	private Annotation annotationValue;
	private ArrayValue arrayValue;
	
	public ElementValueUnion(byte[] bytes, int offset, ElementValueTag tag) {
		this.bytes = bytes;
		this.offset = offset;
		this.tag = tag;
	}
	
	public int parse() {
		if (tag.isConstant()) {
			constValueIndex = new Index2(bytes, offset);
			offset = constValueIndex.parse();
		}
		if (tag.isEnum()) {
			enumConstValue = new EnumConstValue(bytes, offset);
			offset = enumConstValue.parse();
		}
		if (tag.isClass()) {
			classInfoIndex = new Index2(bytes, offset);
			offset = classInfoIndex.parse();
		}
		if (tag.isAnnotation()) {
			annotationValue = new Annotation(bytes, offset);
			offset = annotationValue.parse();
		}
		if (tag.isArray()) {
			arrayValue = new ArrayValue(bytes, offset);
			offset = arrayValue.parse();
		}
		return offset;
	}
}
