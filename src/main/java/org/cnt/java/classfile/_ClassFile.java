package org.cnt.java.classfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-02
 */
public class _ClassFile {

	public static void main(String[] args) throws IOException {
		String path = "G:\\workspace\\sts4-cnt\\java-code-demo\\target\\classes\\org\\cnt\\java\\classfile\\Broccoli.class";
		byte[] bytes = Files.readAllBytes(Paths.get(path));
		showMagic(bytes);
		showVersion(bytes);
		showConstantPool(bytes);
	}
	
	static void showMagic(byte[] bytes) {
		//magic,u4,0-3
		byte b0 = bytes[0];
		byte b1 = bytes[1];
		byte b2 = bytes[2];
		byte b3 = bytes[3];
		log(Long.toHexString(Byter.toUnsigned(b0, b1, b2, b3)));
		//cafebabe
	}
	
	static void showVersion(byte[] bytes) {
		//minor_version,u2,4-5
		byte b4 = bytes[4];
		byte b5 = bytes[5];
		log(Byter.toUnsigned(b4, b5));
		//0
		
		//major_version,u2,6-7
		byte b6 = bytes[6];
		byte b7 = bytes[7];
		log(Byter.toUnsigned(b6, b7));
		//52
	}
	
	static void showConstantPool(byte[] bytes) {
		//constant_pool_count,u2,8-9
		byte b8 = bytes[8];
		byte b9 = bytes[9];
		int count = Byter.toUnsigned(b8, b9);
		log(count);
		//43
		log(Byter.toUnsigned(bytes[10]));
		log(Byter.toUnsigned(bytes[11], bytes[12]));
		log(Byter.toUnsigned(bytes[13]));
		log(Byter.toUnsigned(bytes[14], bytes[15]));
		log(new String(bytes, 16, 31));
		log(Byter.toUnsigned(bytes[47]));
		log(Byter.toUnsigned(bytes[48], bytes[49]));
		log(Byter.toUnsigned(bytes[50]));
		log(Byter.toUnsigned(bytes[51], bytes[52]));
		log(new String(bytes, 53, 32));
	}
	
	static void log(Object o) {
		System.out.println(o);
	}
}
