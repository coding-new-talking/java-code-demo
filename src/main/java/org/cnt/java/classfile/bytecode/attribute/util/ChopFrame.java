package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class ChopFrame extends Frame {

	private OffsetDelta offsetDelta;
	
	public ChopFrame(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		offsetDelta = new OffsetDelta(bytes, offset);
		offset = offsetDelta.parse();
		return offset;
	}
}
