package org.cnt.java.thread.rwlock;

import static org.cnt.java.utils.Methods.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lixinjie
 * @since 2019-06-15
 */
public class RDLock {

	public static void main(String[] args) {

		ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
		Lock rlock = rwlock.readLock();
		Lock wlock = rwlock.writeLock();
		if (rlock.tryLock()) {
			println3("readlock");
			if (wlock.tryLock()) {
				println3("writelock");
				wlock.unlock();
			}
			rlock.unlock();
		}
		println3("----------------");
		if (wlock.tryLock()) {
			println3("writelock");
			if (rlock.tryLock()) {
				println3("readlock");
				rlock.unlock();
			}
			wlock.unlock();
		}
	}

}
