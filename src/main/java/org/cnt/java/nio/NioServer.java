package org.cnt.java.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lixinjie
 * @since 2019-05-07
 */
public class NioServer {

	static int clientCount = 0;
	static AtomicInteger counter = new AtomicInteger(0);
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
	
	public static void main(String[] args) {
		try {
			Selector selector = Selector.open();
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			ssc.bind(new InetSocketAddress("localhost", 8080));
			while (true) {
				selector.select();
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = keys.iterator();
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					iterator.remove();
					if (key.isAcceptable()) {
						ServerSocketChannel ssc1 = (ServerSocketChannel)key.channel();
						SocketChannel sc = null;
						while ((sc = ssc1.accept()) != null) {
							sc.configureBlocking(false);
							sc.register(selector, SelectionKey.OP_READ);
							InetSocketAddress rsa = (InetSocketAddress)sc.socket().getRemoteSocketAddress();
							System.out.println(rsa.getHostName() + ":" + rsa.getPort() + "->" + Thread.currentThread().getId() + ":" + (++clientCount));
						}
					} else if (key.isReadable()) {
						key.interestOps(key.interestOps() & (~ SelectionKey.OP_READ));
						processWithNewThread((SocketChannel)key.channel(), key);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void processWithNewThread(SocketChannel sc, SelectionKey key) {
		Runnable run = () -> {
			counter.incrementAndGet();
			try {
				ByteBuffer bb = ByteBuffer.allocate(20);
				long begin = System.currentTimeMillis();
				sc.read(bb);
				long end = System.currentTimeMillis();
				byte[] bytes = new byte[20];
				bb.flip();
				int count = bb.remaining();
				bb.get(bytes, 0, count);
				key.interestOps(key.interestOps() | SelectionKey.OP_READ);
				sc.close();
				System.out.println(time() + "->" + new String(bytes, 0, count) + "->" + Thread.currentThread().getId() + ":" + counter.get());
				System.out.println(Thread.currentThread().getId() + "->" + (end -begin) + " ms" );
			} catch (Exception e) {
				e.printStackTrace();
			}
			counter.decrementAndGet();
		};
		new Thread(run).start();
	}
	
	static String time() {
		return sdf.format(new Date());
	}
}
