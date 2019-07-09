package org.cnt.java.digit;

/**
 * @author lixinjie
 * @since 2019-07-09
 */
public class Digit {

	public static void main(String[] args) {
		binaryRepresent();
	}

	//最高位是符号位，0表示正数，1表示负数。
	//0既不是正数也不是负数，计算机把它当作正数。
	//把一个数当作正数，它的二进制形式就是原码。
	//把原码中的0变为1、1变为0，此时称为反码。
	//反码加1就是补码。
	static void binaryRepresent() {
		log(Integer.toBinaryString(0));
		//00000000
		
		log(Integer.toBinaryString(1));
		//00000001
		log(Integer.toBinaryString(-1));
		//11111111
		
		log(Integer.toBinaryString(2));
		//00000010
		log(Integer.toBinaryString(-2));
		//11111110
		
		log(Integer.toBinaryString(5));
		//00000101
		log(Integer.toBinaryString(-5));
		//11111011
		
		log(Integer.toBinaryString(Byte.MAX_VALUE));
		//01111111
		log(Integer.toBinaryString(-Byte.MAX_VALUE));
		//10000001

		log(Integer.toBinaryString(Byte.MIN_VALUE));
		//10000000
		
		//从9转换-9
		log(Integer.toBinaryString(-9));
		int n = 9;
		n = ~n;
		n += 1;
		log(n);
		log(Integer.toBinaryString(n));
	}
	
	static void log(Object o) {
		System.out.println(Integer.MAX_VALUE);
	}
}
