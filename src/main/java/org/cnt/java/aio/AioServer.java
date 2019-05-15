package org.cnt.java.aio;

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
			//非阻塞方法，其实就是注册了个回调，而且只能接受一个连接
			assc.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

				@Override
				public void completed(AsynchronousSocketChannel asc, Object attachment) {
					//再次注册，接受下一个连接
					assc.accept(null, this);
					try {
						InetSocketAddress rsa = (InetSocketAddress)asc.getRemoteAddress();
						System.out.println(time() + "->" + rsa.getHostName() + ":" + rsa.getPort() + "->" + Thread.currentThread().getId() + ":" + (++clientCount));
					} catch (Exception e) {
					}
					readFromChannelAsync(asc);
				}

				@Override
				public void failed(Throwable exc, Object attachment) {
					
				}
			});
			//不让主线程退出
			synchronized (AioServer.class) {
				AioServer.class.wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void readFromChannelAsync(AsynchronousSocketChannel asc) {
		//会把数据读入到该buffer之后，再触发工作线程来执行回调
		ByteBuffer bb = ByteBuffer.allocate(1024*1024*1 + 1);
		long begin = System.currentTimeMillis();
		//非阻塞方法，其实就是注册了个回调，而且只能接受一次读取
		asc.read(bb, null, new CompletionHandler<Integer, Object>() {
			//从该连接上一共读到的字节数
			int total = 0;
			/**
			 * @param count 表示本次读取到的字节数，-1表示数据已读完
			 */
			@Override
			public void completed(Integer count, Object attachment) {
				counter.incrementAndGet();
				if (count > -1) {
					total += count;
				}
				int size = bb.position();
				System.out.println(time() + "->count=" + count + ",total=" + total + "bs,buffer=" + size + "bs->" + Thread.currentThread().getId() + ":" + counter.get());
				if (count > -1) {//数据还没有读完
					//再次注册回调，接受下一次读取
					asc.read(bb, null, this);
				} else {//数据已读完
					try {
						asc.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				counter.decrementAndGet();
			}

			@Override
			public void failed(Throwable exc, Object attachment) {
				
			}
		});
		long end = System.currentTimeMillis();
		System.out.println(time() + "->exe read req,use=" + (end -begin) + "ms" + "->" + Thread.currentThread().getId());
	}
	
	static String time() {
		return sdf.format(new Date());
	}
}
