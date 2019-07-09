package org.cnt.java.utils;

/**
 * @author lixinjie
 * @since 2019-07-09
 */
public class Byter {

	public static short toUnsigned(byte b) {
		return (short)((short)b & 0xff);
	}
	
	public static int toUnsigned(byte b1, byte b0) {
		return toUnsigned(b1) << 8 | toUnsigned(b0);
	}
	
	public static long toUnsigned(byte b3, byte b2, byte b1, byte b0) {
		return (long)toUnsigned(b3) << 24 | toUnsigned(b2) << 16 | toUnsigned(b1) << 8 | toUnsigned(b0);
	}
	
	public static void main(String[] args) {
		/*System.out.println(0b10000001);
		byte b = (byte)0b10000001;
		System.out.println(b);
		short s = toUnsigned(b);
		System.out.println(s);
		System.out.println(Integer.toBinaryString(s));
		System.out.println(0b1000000110000001);
		int i = toUnsigned(b, b);
		System.out.println(i);
		System.out.println(Integer.toBinaryString(i));
		System.out.println(0b10000001100000011000000110000001L);
		long l = toUnsigned(b, b, b, b);
		System.out.println(l);
		System.out.println(Long.toBinaryString(l));
		*/
		System.out.println(Integer.toBinaryString(Byte.MAX_VALUE));
		System.out.println(Integer.toBinaryString(Byte.MIN_VALUE));
	}
}
