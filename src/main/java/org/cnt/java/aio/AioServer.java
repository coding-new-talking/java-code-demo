package org.cnt.java.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lixinjie
 * @since 2019-05-13
 */
public class AioServer {

	static int clientCount = 0;
	static AtomicInteger counter = new AtomicInteger(0);
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
	
	public static void main(String[] args) {
		try {
			AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open();
			assc.bind(new InetSocketAddress("localhost", 8080));
			assc.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

				@Override
				public void completed(AsynchronousSocketChannel result, Object attachment) {
					assc.accept(null, this);
					InetSocketAddress rsa;
					try {
						rsa = (InetSocketAddress)result.getRemoteAddress();
						System.out.println(rsa.getHostName() + ":" + rsa.getPort() + "->" + Thread.currentThread().getId() + ":" + (++clientCount));
					} catch (Exception e) {
					}
					readFromChannelAsync(result);
				}

				@Override
				public void failed(Throwable exc, Object attachment) {
					
				}
			});
			synchronized (AioServer.class) {
				AioServer.class.wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void readFromChannelAsync(AsynchronousSocketChannel asc) {
		ByteBuffer bb = ByteBuffer.allocate(20);
		long begin = System.currentTimeMillis();
		asc.read(bb, null, new CompletionHandler<Integer, Object>() {

			@Override
			public void completed(Integer result, Object attachment) {
				counter.incrementAndGet();
				byte[] bytes = new byte[20];
				bb.flip();
				int count = bb.remaining();
				bb.get(bytes, 0, count);
				System.out.println(time() + "->" + new String(bytes, 0, count) + "->" + Thread.currentThread().getId() + ":" + counter.get());
				counter.decrementAndGet();
			}

			@Override
			public void failed(Throwable exc, Object attachment) {
				
			}
		});
		long end = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getId() + "->" + (end -begin) + " ms" );
	}
	
	static String time() {
		return sdf.format(new Date());
	}
}
