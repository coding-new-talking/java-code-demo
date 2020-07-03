package org.cnt.java.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lixinjie
 * @since 2020-07-03
 */
public class ActualHandler implements InvocationHandler {

	private ClassAB classAB;
	private Object proxy;
	
	public ActualHandler(ClassAB classAB) {
		this.classAB = classAB;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("this.proxy == proxy : " + (this.proxy == proxy));
		String name = method.getName();
		System.out.println("before " + name);
		Object val = method.invoke(classAB, args);
		System.out.println("after " + name);
		return val;
	}

	public void setProxy(Object proxy) {
		this.proxy = proxy;
	}
}
