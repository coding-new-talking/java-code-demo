package org.cnt.java.classfile.bytecode;

/**
 * @author lixinjie
 * @since 2019-07-10
 */
public class ByteCode {

	private Magic magic;
	private Version version;
	private ConstantPool constantPool;
	
	
	
	private int index;
	private byte[] bytes;
	
	public ByteCode(byte[] bytes) {
		this.bytes = bytes;
	}
	
	public void parseMagic() {
		magic = new Magic(bytes);
		index = magic.parse();
	}
	
	public void parseVersion() {
		version = new Version(bytes);
		index = version.parse();
	}
	
	public void parseConstantPool() {
		constantPool = new ConstantPool(bytes);
		index = constantPool.parse();
	}
}
