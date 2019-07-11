package org.cnt.java.classfile.bytecode;

/**
 * @author lixinjie
 * @since 2019-07-10
 */
public class ByteCode {

	private Magic magic;
	private MinorVersion minorVersion;
	private MajorVersion majorVersion;
	private ConstantPoolCount constantPoolCount;
	private ConstantPool constantPool;
	
	
	
	private int offset;
	private byte[] bytes;
	
	public ByteCode(byte[] bytes) {
		this.bytes = bytes;
	}
	
	public void parseMagic() {
		magic = new Magic(bytes, offset);
		offset = magic.parse();
	}
	
	public void parseMinorVersion() {
		minorVersion = new MinorVersion(bytes, offset);
		offset = minorVersion.parse();
	}
	
	public void parseMajorVersion() {
		majorVersion = new MajorVersion(bytes, offset);
		offset = majorVersion.parse();
	}
	
	public void parseConstantPoolCount() {
		constantPoolCount = new ConstantPoolCount(bytes, offset);
		offset = constantPoolCount.parse();
	}
	
	public void parseConstantPool() {
		constantPool = new ConstantPool(bytes, offset, constantPoolCount.getCount());
		offset = constantPool.parse();
	}
}
