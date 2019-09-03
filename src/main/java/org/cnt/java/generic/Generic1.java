package org.cnt.java.generic;

/**
 * @author lixinjie
 * @since 2018-07-06
 */
public class Generic1 {

	public static void main(String[] args) {
		A<String> a = new A<>();
		a.setT("李新杰");
		a.setO("lixinjie");
		String name = a.getT();
		String py = (String)a.getO();
		System.out.println(name + py);
	}
	
	static class A<T> {
		private T t;
		private Object o;
		
		public T getT() {
			return t;
		}
		public void setT(T t) {
			this.t = t;
		}
		public Object getO() {
			return o;
		}
		public void setO(Object o) {
			this.o = o;
		}
	}
}
