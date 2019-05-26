package org.cnt.java.thread.coop;

import static org.cnt.java.utils.Methods.doingLongTime;
import static org.cnt.java.utils.Methods.println;
import static org.cnt.java.utils.Methods.println2;
import static org.cnt.java.utils.Methods.random;

import java.util.concurrent.Phaser;

/**
 * @author lixinjie
 * @since 2019-05-25
 */
public class ThreadCo4 {

	static final int COUNT = 6;
	
	public static void main(String[] args) throws Exception {
		new Thread(new Challenger("张三")).start();
		new Thread(new Challenger("李四")).start();
		new Thread(new Challenger("王五")).start();
		new Thread(new Challenger("赵六")).start();
		new Thread(new Challenger("大胖")).start();
		new Thread(new Challenger("小白")).start();
		synchronized (ThreadCo4.class) {
			ThreadCo4.class.wait();
		}
	}
	
	static Phaser ph = new Phaser() {
		
		protected boolean onAdvance(int phase, int registeredParties) {
			println2("第(%d)局，剩余[%d]人", phase, registeredParties);
			return registeredParties == 0 ||
					(phase != 0 && registeredParties == COUNT);
		};
	};
	
	static class Challenger implements Runnable {
		
		String name;
		int state;
		
		Challenger(String name) {
			this.name = name;
			this.state = 0;
		}
		
		@Override
		public void run() {
			println("[%s]开始挑战。。。", name);
			ph.register();
			int phase = 0;
			int h;
			while (!ph.isTerminated() && phase < 100) {
				doingLongTime(5);
				if (state == 0) {
					if (Decide.goon()) {
						h = ph.arriveAndAwaitAdvance();
						if (h < 0)
							println("No%d.[%s]继续，但已胜利。。。", phase, name);
						else
							println("No%d.[%s]继续at(%d)。。。", phase, name, h);
					} else {
						state = -1;
						h = ph.arriveAndDeregister();
						println("No%d.[%s]退出at(%d)。。。", phase, name, h);
					}
				} else {
					if (Decide.revive()) {
						state = 0;
						h = ph.register();
						if (h < 0)
							println("No%d.[%s]复活，但已失败。。。", phase, name);
						else
							println("No%d.[%s]复活at(%d)。。。", phase, name, h);
					} else {
						println("No%d.[%s]没有复活。。。", phase, name);
					}
				}
				phase++;
			}
			if (state == 0) {
				ph.arriveAndDeregister();
			}
			println("[%s]结束。。。", name);
		}
		
	}
	
	static class Decide {

		static boolean goon() {
			return random(9) > 4;
		}
		
		static boolean revive() {
			return random(9) < 5;
		}
	}

}
