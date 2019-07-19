package org.cnt.java.classfile.bytecode.attribute.util;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class LineNumTable {
	
	private byte[] bytes;
	private int offset;
	
	private StartPc startPc;
	private LineNumber lineNumber;
	
	public LineNumTable(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		startPc = new StartPc(bytes, offset);
		offset = startPc.parse();
		lineNumber = new LineNumber(bytes, offset);
		offset = lineNumber.parse();
		return offset;
	}
	
	public int getStartPc() {
		return startPc.getStartPc();
	}
	
	public int getLineNumber() {
		return lineNumber.getLineNumber();
	}
}
