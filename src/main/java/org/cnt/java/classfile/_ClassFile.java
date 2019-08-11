package org.cnt.java.classfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.cnt.java.classfile.bytecode.ByteCode;

/**
 * @author lixinjie
 * @since 2019-07-02
 */
public class _ClassFile {

	public static void main(String[] args) throws IOException {
		String project = new File("").getCanonicalPath();
		String path = project + "\\target\\classes\\org\\cnt\\java\\classfile\\Broccoli.class";
		path = "C:\\Users\\Administrator\\Desktop\\AnnotationMetadataReadingVisitor.class";
		path = "C:\\Users\\DELL\\Desktop\\AnnotationMetadataReadingVisitor.class";
		byte[] bytes = Files.readAllBytes(Paths.get(path));
		ByteCode bc = new ByteCode(bytes);
		bc.parse();
		StringBuilder sb = new StringBuilder();
		bc.toString(sb);
		log(sb);
		
	}
	
	
	static void log(Object o) {
		System.out.println(o);
	}
}
