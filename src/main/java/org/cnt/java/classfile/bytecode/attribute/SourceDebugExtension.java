package org.cnt.java.classfile.bytecode.attribute;

import org.cnt.java.classfile.bytecode.constantpool.util.ByteString;

/**
 * @author lixinjie
 * @since 2019-07-19
 */
public class SourceDebugExtension extends AttributeInfo {

	private ByteString debugExtension;
	
	public SourceDebugExtension(byte[] bytes, int offset) {
		super(bytes, offset);
	}

	public int parse() {
		offset = super.parse();
		debugExtension = new ByteString(bytes, offset, (int)getAttributeLength());
		offset = debugExtension.parse();
		return offset;
	}
	
	public String getDebugExtension() {
		return debugExtension.getString();
	}
}
