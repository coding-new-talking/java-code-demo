package org.cnt.java.filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * @author lixinjie
 * @since 2020-07-03
 */
public class FcMain {

	static final byte BLANK = 32;
	static final String NEWLINE_STRING = System.getProperty("line.separator");
	static final byte[] NEWLINE_BYTES = NEWLINE_STRING.getBytes(StandardCharsets.UTF_8);
	static final byte[] EMTPY_BYTES = new byte[0];
	static final int NEWLINE_LENGTH = NEWLINE_BYTES.length;
	static final int CONTENT_LENGTH = 60;
	static final int LINE_LENGTH = CONTENT_LENGTH + NEWLINE_LENGTH;
	
	public static void main(String[] args) throws IOException {
		String file = "D:/article.list";
		Path path = Paths.get(file);
		//write(path);
		replace(path);
		read(path);
	}
	
	static void read(Path path) throws IOException {
		SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.READ);
		channel.position(LINE_LENGTH * 0);
		System.out.println(channel.size());
		ByteBuffer bb = ByteBuffer.allocate((int) channel.size() + 1);
		bb.clear();
		while (channel.read(bb) != -1) { };
		bb.flip();
		byte[] bytes = new byte[bb.remaining()];
		bb.get(bytes, 0, bytes.length);
		System.out.println(new String(bytes, StandardCharsets.UTF_8));
	}
	
	static void write(Path path) throws IOException {
		SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		byte[] bytes = "happy weekend".getBytes(StandardCharsets.UTF_8);
		ByteBuffer bb = ByteBuffer.allocate(LINE_LENGTH);
		bb.put(bytes);
		bb.put(getBlanks(CONTENT_LENGTH - bytes.length));
		bb.put(getNewLine());
		channel.position(channel.size());
		bb.flip();
		channel.write(bb);
	}
	
	static void replace(Path path) throws IOException {
		SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		byte[] bytes = "我爱你，我的祖国母亲！".getBytes(StandardCharsets.UTF_8);
		ByteBuffer bb = ByteBuffer.allocate(LINE_LENGTH);
		bb.put(bytes);
		channel.position(LINE_LENGTH * 1);
		bb.flip();
		channel.write(bb);
	}

	static byte[] getBlanks(int count) {
		if (count == 0) {
			return EMTPY_BYTES;
		}
		byte[] blanks = new byte[count];
		Arrays.fill(blanks, BLANK);
		return blanks;
	}
	
	static byte[] getNewLine() {
		return NEWLINE_BYTES;
	}
}
