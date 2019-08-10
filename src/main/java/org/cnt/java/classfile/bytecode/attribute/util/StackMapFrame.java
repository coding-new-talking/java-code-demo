package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-08-09
 */
public class StackMapFrame {

	private byte[] bytes;
	private int offset;
	
	private Frame frame;
	
	public StackMapFrame(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		FrameBuilder builder = FrameBuilder.newBuilder(bytes);
		frame = builder.build(offset);
		offset = frame.parse();
		return offset;
	}

	public Frame getFrame() {
		return frame;
	}

	@Override
	public String toString() {
		return "StackMapFrame [getFrame()=" + getFrame() + "]";
	}
}
