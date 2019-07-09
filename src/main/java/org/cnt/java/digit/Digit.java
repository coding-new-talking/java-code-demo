package org.cnt.java.digit;

/**
 * @author lixinjie
 * @since 2019-07-09
 */
public class Digit {

	public static void main(String[] args) {
		//binaryRepresent();
		//binaryOperate();
		binarayShift();
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
		
		//从9转换-9(取反再加1)
		log(Integer.toBinaryString(~9 + 1));
		log(Integer.toBinaryString(-9));
	}
	
	//二进制的与/或/非/异或
	//与(and)，&，1 & 1 -> 1，其余都是0
	//或(or)，|，0 | 0 -> 0，其余都是1
	//非(not)，~，也称取反，0变成1、1变成0
	//异或(xor)，^，0 ^ 1 -> 1，1 ^ 0 -> 1，其余都是0
	static void binaryOperate() {
		log(Integer.toBinaryString(0b00001010 & 0b00001111));
		//00001010
		log(Integer.toBinaryString(0b00001010 | 0b00001111));
		//00001111
		log(Integer.toBinaryString(~0b00001010));
		//11110101
		log(Integer.toBinaryString(0b00001010 ^ 0b00001111));
		//00000101
	}
	
	//二进制的左移/右移
	//左移(<<)时，左边丢弃(符号位照样丢弃)，右边补0，左移一位相当于乘2，二位相当于乘4，以此类推。
	//移完后，最高位是0为正数，是1为负数。正数和负数左移时都遵从这个规律。
	//当左移一个周期时，回到原点。即相当于不移。超过一个周期后，把周期部分除掉，移动剩下的。
	//右移(>>)时，右边丢弃，正数左边补0，负数左边补1，右移一位相当于除2，二位相当于除4，以此类推。
	//在四舍五入时，正数选择舍，负数选择入。
	//正数右移从都丢弃完开始往后都是0，因为二进制都是0，直到到达一个周期时，回到原点。相当于不移。
	//超过一个周期后，把周期部分除掉，移动剩下的。
	//负数右移从都丢弃完开始往后都是-1，因为二进制都是1，直到到达一个周期时，回到原点。相当于不移。
	//超过一个周期后，把周期部分除掉，移动剩下的。
	static void binarayShift() {
		log(5);
		//5
		log(5 << 1);
		//10
		log(5 << 2);
		//20
		log(5 << 3);
		//40
		log(Integer.toBinaryString(5));
		//101
		log(Integer.toBinaryString(5 << 1));
		//1010
		log(Integer.toBinaryString(5 << 2));
		//10100
		log(Integer.toBinaryString(5 << 3));
		//101000
		
		log(-5);
		//-5
		log(-5 << 1);
		//-10
		log(-5 << 2);
		//-20
		log(-5 << 3);
		//-40
		log(Integer.toBinaryString(-5));
		//011
		log(Integer.toBinaryString(-5 << 1));
		//0110
		log(Integer.toBinaryString(-5 << 2));
		//01100
		log(Integer.toBinaryString(-5 << 3));
		//01100
		
		log("");
		
		log(5);
		//5
		log(5 << 29);
		//-1610612736
		log(5 << 30);
		//1073741824
		log(5 << 31);
		//-2147483648
		log(5 << 32);
		//5
		log(5 << 33);
		//10
		log(Integer.toBinaryString(5));
		//101
		log(Integer.toBinaryString(5 << 29));
		//10100000000000000000000000000000
		log(Integer.toBinaryString(5 << 30));
		//01000000000000000000000000000000
		log(Integer.toBinaryString(5 << 31));
		//10000000000000000000000000000000
		
		log(-5);
		//-5
		log(-5 << 29);
		//1610612736
		log(-5 << 30);
		//-1073741824
		log(-5 << 31);
		//-2147483648
		log(-5 << 32);
		//-5
		log(-5 << 33);
		//-10
		log(Integer.toBinaryString(-5));
		//011
		log(Integer.toBinaryString(-5 << 29));
		//01100000000000000000000000000000
		log(Integer.toBinaryString(-5 << 30));
		//11000000000000000000000000000000
		log(Integer.toBinaryString(-5 << 31));
		//10000000000000000000000000000000
		
		log("------------------------------");
		
		log(99);
		//99
		log(99 >> 1);
		//49
		log(99 >> 2);
		//24
		log(99 >> 3);
		//12
		log(Integer.toBinaryString(99));
		//1100011
		log(Integer.toBinaryString(99 >> 1));
		//110001
		log(Integer.toBinaryString(99 >> 2));
		//11000
		log(Integer.toBinaryString(99 >> 3));
		//1100
		
		log(-99);
		//-99
		log(-99 >> 1);
		//-50
		log(-99 >> 2);
		//-25
		log(-99 >> 3);
		//-13
		log(Integer.toBinaryString(-99));
		//0011101
		log(Integer.toBinaryString(-99 >> 1));
		//1001110
		log(Integer.toBinaryString(-99 >> 2));
		//1100111
		log(Integer.toBinaryString(-99 >> 3));
		//1110011
		
		log("");
		
		log(99);
		//99
		log(99 >> 6);
		//1
		log(99 >> 7);
		//0
		log(99 >> 8);
		//0
		log(99 >> 9);
		//0
		log(99 >> 31);
		//0
		log(99 >> 32);
		//99
		log(99 >> 33);
		//49
		log(Integer.toBinaryString(99));
		//1100011
		log(Integer.toBinaryString(99 >> 6));
		//1
		log(Integer.toBinaryString(99 >> 7));
		//0
		log(Integer.toBinaryString(99 >> 8));
		//0
		log(Integer.toBinaryString(99 >> 9));
		//0
		log(Integer.toBinaryString(99 >> 31));
		//0
		log(Integer.toBinaryString(99 >> 32));
		//1100011
		log(Integer.toBinaryString(99 >> 33));
		//110001
		
		log(-99);
		//-99
		log(-99 >> 6);
		//-2
		log(-99 >> 7);
		//-1
		log(-99 >> 8);
		//-1
		log(-99 >> 9);
		//-1
		log(-99 >> 31);
		//-1
		log(-99 >> 32);
		//-99
		log(-99 >> 33);
		//-50
		log(Integer.toBinaryString(-99));
		//0011101
		log(Integer.toBinaryString(-99 >> 6));
		//1111110
		log(Integer.toBinaryString(-99 >> 7));
		//1111111
		log(Integer.toBinaryString(-99 >> 8));
		//1111111
		log(Integer.toBinaryString(-99 >> 9));
		//1111111
		log(Integer.toBinaryString(-99 >> 31));
		//1111111
		log(Integer.toBinaryString(-99 >> 32));
		//0011101
		log(Integer.toBinaryString(-99 >> 33));
		//1001110

		log("------------------------------");
		
		log(99);
		log(99 >>> 1);
		log(99 >>> 2);
		log(99 >>> 7);
		log(99 >>> 8);
		log(99 >>> 31);
		log(99 >>> 32);
		log(99 >>> 33);
		log(Integer.toBinaryString(99));
		log(Integer.toBinaryString(99 >>> 1));
		log(Integer.toBinaryString(99 >>> 2));
		log(Integer.toBinaryString(99 >>> 7));
		log(Integer.toBinaryString(99 >>> 8));
		log(Integer.toBinaryString(99 >>> 31));
		log(Integer.toBinaryString(99 >>> 32));
		log(Integer.toBinaryString(99 >>> 33));
		
		log(-99);
		log(-99 >>> 1);
		log(-99 >>> 2);
		log(-99 >>> 7);
		log(-99 >>> 8);
		log(-99 >>> 31);
		log(-99 >>> 32);
		log(-99 >>> 33);
		log(Integer.toBinaryString(-99));
		log(Integer.toBinaryString(-99 >>> 1));
		log(Integer.toBinaryString(-99 >>> 2));
		log(Integer.toBinaryString(-99 >>> 7));
		log(Integer.toBinaryString(-99 >>> 8));
		log(Integer.toBinaryString(-99 >>> 31));
		log(Integer.toBinaryString(-99 >>> 32));
		log(Integer.toBinaryString(-99 >>> 33));
	}
	
	static void log(Object o) {
		System.out.println(o);
	}
}
