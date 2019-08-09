package org.cnt.java.classfile.bytecode.attribute.util;

import org.cnt.java.classfile.bytecode.constantpool.util.Index2;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class ExceptionTable {
	
	private byte[] bytes;
	private int offset;
	
	private StartPc startPc;
	private EndPc endPc;
	private HandlerPc handlerPc;
	private Index2 catchType;
	
	public ExceptionTable(byte[] bytes, int offset) {
		this.bytes = bytes;
		this.offset = offset;
	}
	
	public int parse() {
		startPc = new StartPc(bytes, offset);
		offset = startPc.parse();
		endPc = new EndPc(bytes, offset);
		offset = endPc.parse();
		handlerPc = new HandlerPc(bytes, offset);
		offset = handlerPc.parse();
		catchType = new Index2(bytes, offset);
		offset = catchType.parse();
		return offset;
	}

	public int getStartPc() {
		return startPc.getStartPc();
	}

	public int getEndPc() {
		return endPc.getEndPc();
	}

	public int getHandlerPc() {
		return handlerPc.getHandlerPc();
	}

	public int getCatchType() {
		return catchType.getIndex();
	}

	@Override
	public String toString() {
		return "ExceptionTable [getStartPc()=" + getStartPc() + ", getEndPc()=" + getEndPc() + ", getHandlerPc()="
				+ getHandlerPc() + ", getCatchType()=" + getCatchType() + "]";
	}
	
}
