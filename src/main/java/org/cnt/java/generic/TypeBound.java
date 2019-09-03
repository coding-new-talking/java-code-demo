package org.cnt.java.generic;

/**
 * @author lixinjie
 * @since 2018-07-06
 */
public class TypeBound {

	static class CA {
		public void ca() {
			System.out.println("CA.ca");
		}
	}
	
	interface IB {
		void ib();
	}
	
	interface IC {
		void ic();
	}
	
	static class E<T extends CA & IB & IC> {
		
		public void e(T t) {
			t.ca();
			t.ib();
			t.ic();
		}
	}
	
	static class D extends CA implements IB, IC {

		@Override
		public void ic() {
			System.out.println("IC.ic");
		}

		@Override
		public void ib() {
			System.out.println("IB.ib");
		}
		
	}
	
	public static void main(String[] args) {
//		E<CA> e1 = new E<>();
//		E<IB> e2 = new E<>();
//		E<IC> e3 = new E<>();
		E<D> e = new E<>();
		e.e(new D());
	}
}
