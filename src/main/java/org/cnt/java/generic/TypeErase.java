package org.cnt.java.generic;

/**
 * @author lixinjie
 * @since 2018-07-09
 */
public class TypeErase {

	
	static class A {
		private Object obj;

		public Object getObj() {
			return obj;
		}
		public void setObj(Object obj) {
			this.obj = obj;
		}
	}
	
	static class B<T> {
		private T obj;

		public T getObj() {
			return obj;
		}
		public void setObj(T obj) {
			this.obj = obj;
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		a.setObj("李新杰");
		String obj1 = (String)a.getObj();
		B<String> b = new B<>();
		b.setObj("李新杰");
		String obj2 = b.getObj();
		System.out.println(obj1 + "," + obj2);
	}

}
