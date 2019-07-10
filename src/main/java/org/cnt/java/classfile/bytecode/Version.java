package org.cnt.java.classfile.bytecode;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-10
 */
public class Version {

	private MinorVersion minorVersion;
	private MajorVersion majorVersion;
	
	public Version(byte[] bytes) {
		this.minorVersion = new MinorVersion(bytes);
		this.majorVersion = new MajorVersion(bytes);
	}
	
	public int parse() {
		minorVersion.parse();
		return majorVersion.parse();
	}
	
	static class MinorVersion {
		public int offset = 4;
		public int length = 2;
		
		private byte[] bytes;
		
		private int version;
		
		MinorVersion(byte[] bytes) {
			this.bytes = bytes;
		}
		
		public int parse() {
			version = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static class MajorVersion {
		public int offset = 6;
		public int length = 2;
		
		private byte[] bytes;
		
		private int version;
		
		MajorVersion(byte[] bytes) {
			this.bytes = bytes;
		}
		
		public int parse() {
			version = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
}
