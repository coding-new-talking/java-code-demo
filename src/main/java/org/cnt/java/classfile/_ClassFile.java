package org.cnt.java.classfile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-02
 */
public class _ClassFile {

	public static void main(String[] args) throws IOException {
		String path = "G:\\workspace\\sts4-cnt\\java-code-demo\\target\\classes\\org\\cnt\\java\\classfile\\Broccoli.class";
		String charset = "ASCII";
		showClassFile(path);
	}

	static void showClassFile(String path, String charset) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(path), Charset.forName(charset));
		System.out.println(lines.size());
		lines.forEach(line -> System.out.println(line));
	}
	
	static void showClassFile(String path) throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get(path));
		System.out.println(bytes.length);
		byte ca = bytes[0];
		byte fe = bytes[1];
		byte ba = bytes[2];
		byte by = bytes[3];
		
		System.out.println(Long.toHexString(Byter.toUnsigned(ca, fe, ba, by)));
		
		int ica = Byte.toUnsignedInt(ca);
		int ife = Byte.toUnsignedInt(fe);
		int iba = Byte.toUnsignedInt(ba);
		int iby = Byte.toUnsignedInt(by);
		
		System.out.println(ca);
		System.out.println(ica);
		System.out.println(Integer.toHexString(ica >> 4));
		System.out.println(Integer.toHexString(ica & 0b00001111));
		System.out.println(fe);
		System.out.println(ife);
		System.out.println(Integer.toHexString(ife >> 4));
		System.out.println(Integer.toHexString(ife & 0b00001111));
		System.out.println(ba);
		System.out.println(iba);
		System.out.println(Integer.toHexString(iba >> 4));
		System.out.println(Integer.toHexString(iba & 0b00001111));
		System.out.println(by);
		System.out.println(iby);
		System.out.println(Integer.toHexString(iby >> 4));
		System.out.println(Integer.toHexString(iby & 0b00001111));
		System.out.println();
		for (int i = 0; i < bytes.length; i++) {
			System.out.print(bytes[i]);
			System.out.print(",");
			//System.out.print((char)bytes[i]);
			
		}
	}
}
