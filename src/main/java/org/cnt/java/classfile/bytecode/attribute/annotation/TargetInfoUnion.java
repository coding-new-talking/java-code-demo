package org.cnt.java.classfile.bytecode.attribute.annotation;

import org.cnt.java.classfile.bytecode.attribute.util.CatchTarget;
import org.cnt.java.classfile.bytecode.attribute.util.EmptyTarget;
import org.cnt.java.classfile.bytecode.attribute.util.FormalParameterTarget;
import org.cnt.java.classfile.bytecode.attribute.util.LocalVarTarget;
import org.cnt.java.classfile.bytecode.attribute.util.OffsetTarget;
import org.cnt.java.classfile.bytecode.attribute.util.SupertypeTarget;
import org.cnt.java.classfile.bytecode.attribute.util.TargetType;
import org.cnt.java.classfile.bytecode.attribute.util.ThrowsTarget;
import org.cnt.java.classfile.bytecode.attribute.util.TypeArgumentTarget;
import org.cnt.java.classfile.bytecode.attribute.util.TypeParameterBoundTarget;
import org.cnt.java.classfile.bytecode.attribute.util.TypeParameterTarget;

/**
 * @author lixinjie
 * @since 2019-07-15
 */
public class TargetInfoUnion {

	private byte[] bytes;
	private int offset;
	private TargetType targetType;
	
	private TypeParameterTarget typeParameterTarget;
	private SupertypeTarget supertypeTarget;
	private TypeParameterBoundTarget typeParameterBoundTarget;
	private EmptyTarget emptyTarget;
	private FormalParameterTarget formalParameterTarget;
	private ThrowsTarget throwsTarget;
	private LocalVarTarget localVarTarget;
	private CatchTarget catchTarget;
	private OffsetTarget offsetTarget;
	private TypeArgumentTarget typeArgumentTarget;
	
	public TargetInfoUnion(byte[] bytes, int offset, TargetType targetType) {
		this.bytes = bytes;
		this.offset = offset;
		this.targetType = targetType;
	}
	
	public int parse() {
		if (targetType.isTypeParameterTarget()) {
			typeParameterTarget = new TypeParameterTarget(bytes, offset);
			offset = typeParameterTarget.parse();
		} else if (targetType.isSupertypeTarget()) {
			supertypeTarget = new SupertypeTarget(bytes, offset);
			offset = supertypeTarget.parse();
		} else if (targetType.isTypeParameterBoundTarget()) {
			typeParameterBoundTarget = new TypeParameterBoundTarget(bytes, offset);
			offset = typeParameterBoundTarget.parse();
		} else if (targetType.isEmptyTarget()) {
			emptyTarget = new EmptyTarget(bytes, offset);
			offset = emptyTarget.parse();
		} else if (targetType.isFormalParameterTarget()) {
			formalParameterTarget = new FormalParameterTarget(bytes, offset);
			offset = formalParameterTarget.parse();
		} else if (targetType.isThrowsTarget()) {
			throwsTarget = new ThrowsTarget(bytes, offset);
			offset = throwsTarget.parse();
		} else if (targetType.isLocalVarTarget()) {
			localVarTarget = new LocalVarTarget(bytes, offset);
			offset = localVarTarget.parse();
		} else if (targetType.isCatchTarget()) {
			catchTarget = new CatchTarget(bytes, offset);
			offset = catchTarget.parse();
		} else if (targetType.isOffsetTarget()) {
			offsetTarget = new OffsetTarget(bytes, offset);
			offset = offsetTarget.parse();
		} else if (targetType.isTypeArgumentTarget()) {
			typeArgumentTarget = new TypeArgumentTarget(bytes, offset);
			offset = typeArgumentTarget.parse();
		}
		return offset;
	}
}
