package org.cnt.java.utils;

/**
 * @author lixinjie
 * @since 2019-07-09
 */
public class Byter {

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
	
	public static void main(String[] args) {
		
	}
}
