package org.cnt.java.utils;

/**
 * @author lixinjie
 * @since 2019-07-09
 */
public class Byter {
	
	
	public static int toUnsigned(byte[] bytes, int offset, int length) {
		if (length == 1) {
			return toUnsigned(bytes[offset]);
		}
		if (length == 2) {
			return toUnsigned(bytes[offset], bytes[offset + 1]);
		}
		return -1;
	}
	
	public static long toUnsignedLong(byte[] bytes, int offset, int length) {
		if (length == 1 || length == 2) {
			return toUnsigned(bytes, offset, length);
		}
		if (length == 4) {
			return toUnsigned(bytes[offset], bytes[offset + 1], bytes[offset + 2], bytes[offset + 3]);
		}
		return -1;
	}
	
	public static String toString(byte[] bytes, int offset, int length) {
		return new String(bytes, offset, length);
	}

	public static int toUnsigned(byte b) {
		//把一个byte原样不变的放到int
		//类型的第4个字节位置，且前面
		//3个字节都清空为0
		return b & 0xff;
	}
	
	public static int toUnsigned(byte b1, byte b0) {
		return toUnsigned(b1) << 8 | toUnsigned(b0);
	}
	
	public static long toUnsigned(byte b3, byte b2, byte b1, byte b0) {
		return (long)toUnsigned(b3) << 24 | toUnsigned(b2) << 16 | toUnsigned(b1) << 8 | toUnsigned(b0);
	}
	
	public static int toSigned(byte b) {
		//把一个byte原样不变的放到int
		//类型的第4个字节位置，且前面
		//3个字节都填充为byte的符号位
		return b;
	}
	
	public static int toSigned(byte b1, byte b0) {
		return toSigned(b1) << 8 | toUnsigned(b0);
	}
	
	public static int toSigned(byte b3, byte b2, byte b1, byte b0) {
		return toSigned(b3) << 24 | toUnsigned(b2) << 16 | toUnsigned(b1) << 8 | toUnsigned(b0);
	}
	
	public static long toSigned(byte b7, byte b6, byte b5, byte b4, byte b3, byte b2, byte b1, byte b0) {
		return (long)toSigned(b7) << 56 | (long)toUnsigned(b6) << 48 | (long)toUnsigned(b5) << 40 | (long)toUnsigned(b4) << 32
				| (long)toUnsigned(b3) << 24 | toUnsigned(b2) << 16 | toUnsigned(b1) << 8 | toUnsigned(b0);
	}
	
	public static void main(String[] args) {
		
	}
}
