package org.cnt.java.generic;

/**
 * @author lixinjie
 * @since 2018-07-09
 */
public class ArrayCvCtv {

	static class Employee {}
	static class Teamleader extends Employee {}
	static class Manager extends Teamleader {}
	static class Boss extends Manager {}
	
	static void test1() {
		Employee[] es = new Employee[10];
		es[0] = new Employee();
		es[1] = new Teamleader();
		es[2] = new Manager();
		es[3] = new Boss();
	}
	
	static void test2() {
		Teamleader[] ts = new Teamleader[10];
		ts[1] = new Teamleader();
		ts[2] = new Manager();
		ts[3] = new Boss();
		Employee[] ets = ts;
		Employee ets1 = ets[1];
		Employee ets2 = ets[2];
		Employee ets3 = ets[3];
		//读数据没问题
		ets[0] = new Employee();//可以编译，运行报错
		ets[1] = new Teamleader();
		ets[2] = new Manager();
		ets[3] = new Boss();
		//写数据可能报错，且编译器不提示
		/**适合往外读数据*/
	}
	
	static void test3() {
		Employee[] es = new Employee[10];
		es[0] = new Employee();
		es[1] = new Teamleader();
		es[2] = new Manager();
		es[3] = new Boss();
		Teamleader[] ts = (Teamleader[])es;
		Teamleader ts0 = ts[0];//可以编译，运行报错
		Teamleader ts1 = ts[1];
		Teamleader ts2 = ts[2];
		Teamleader ts3 = ts[3];
		//读数据可能报错，且编译器不提示
		ts[1] = new Teamleader();
		ts[2] = new Manager();
		ts[3] = new Boss();
		//写数据没问题
		/**适合往里写入数据*/
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
}
