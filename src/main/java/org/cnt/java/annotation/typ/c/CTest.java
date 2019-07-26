package org.cnt.java.annotation.typ.c;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.stream.Stream;

import org.cnt.java.annotation.ann.c.AnnC13;
import org.cnt.java.annotation.ann.c.AnnC23;
import org.cnt.java.annotation.ann.c.AnnC33;
import org.cnt.java.annotation.ann.c.AnnC43;
import org.cnt.java.annotation.ann.r.AnnR11;
import org.cnt.java.annotation.ann.r.AnnR12;
import org.cnt.java.annotation.ann.r.AnnRC11;
import org.cnt.java.annotation.ann.r.AnnRC12;
import org.cnt.java.utils.Logger;

/**
 * @author lixinjie
 * @since 2019-07-25
 */
public class CTest {

	static Logger log = Logger.getLogger();
	
	public static void main(String[] args) {
		log.info("------------------------{}-------------------------", "test1()");
		test1();
		log.info("------------------------{}-------------------------", "test2()");
		test2();
		log.info("------------------------{}-------------------------", "test3()");
		test3();
		log.info("------------------------{}-------------------------", "test4()");
		test4();
		log.info("------------------------{}-------------------------", "test5()");
		test5();
		log.info("------------------------{}-------------------------", "test6()");
		test6();
		log.info("------------------------{}-------------------------", "test7()");
		test7();
	}
	
	static void test1() {
		//getAnnotations()
		
		AnnotatedElement ae1 = C1.class;
		log.info("[C1] getAnnotations()=[");
		Stream.of(ae1.getAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出C1上标的三个注解
		
		AnnotatedElement ae2 = C2.class;
		log.info("[C2] getAnnotations()=[");
		Stream.of(ae2.getAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出C2上标的二个以及从C1继承的一个
		
		//result：此方法会考虑从父类上继承注解
		
		//note：只有标有@Inherited的注解才具有继承性
		//note：子类上的注解会重写父类上的同名注解
		
		//下面是对可重复注解的测试
		//有两种写法：
		//1）把多个注解分散着直接标到类型上
		//2）把多个注解放到容器注解中，容器注解标到类型上
		
		AnnotatedElement ae11 = CR11.class;
		log.info("[CR11] getAnnotations()=[");
		Stream.of(ae11.getAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR11上标的注解，发现都以容器的形式呈现
		
		AnnotatedElement ae21 = CR21.class;
		log.info("[CR21] getAnnotations()=[");
		Stream.of(ae21.getAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR21的注解，发现全部继承CR11上的
		
		//result：可重复注解也遵循继承规则
		
		AnnotatedElement ae22 = CR22.class;
		log.info("[CR22] getAnnotations()=[");
		Stream.of(ae22.getAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR22的注解，主要测试对父类注解的重写，采用同形式重写
		//note：容器的形式可以重写父类容器形式，即使子类的容器是空的
		//note：分散的形式暂时不能重写父类分散的形式，可能是父类分散的有5个，子类只有1个
		//      结果是父类的5个被继承，以容器的形式，子类这1个也存在，以分散的形式
		
		AnnotatedElement ae23 = CR23.class;
		log.info("[CR23] getAnnotations()=[");
		Stream.of(ae23.getAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR23的注解，主要测试对父类注解的重写，采用同形式重写
		//note：容器的形式可以重写父类容器形式
		//note：分散的形式此时可以重写父类分散的形式，可能是父类分散的有5个，子类现在已达到2个
		//      当分散的形式只有1个时，就以分散的形式存在，当达到2个时，就自动转换为容器形式
		//      父类是5个，所以是容器形式，子类现在达到2个，也变成了容器形式，都是容器，类型相同了，所以就重写了
		//      上个示例中，父类是容器形式，子类是分散形式，类型不相同，所以就没有重写，而是同时存在了
		
		AnnotatedElement ae31 = CR31.class;
		log.info("[CR31] getAnnotations()=[");
		Stream.of(ae31.getAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR31的注解，主要验证分散形式只有1个时，不会转换为容器形式，至少达到2个时才会
		//        结果确实是这样的，因为从2个开始就是数组了，必须放入容器中才行，于是自动转换为容器了
		
		AnnotatedElement ae32 = CR32.class;
		log.info("[CR32] getAnnotations()=[");
		Stream.of(ae32.getAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR32的注解，主要验证无论分散形式还是容器形式，只要形式相同就可以重写
		//        结果确实是这样的，分散形式可以，容器形式也可以，无论是直接标的容器，还是自动转换的容器
		
		AnnotatedElement ae33 = CR33.class;
		log.info("[CR33] getAnnotations()=[");
		Stream.of(ae33.getAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR33的注解，主要验证无论分散形式还是容器形式，只要形式不相同就不可以重写
		//        结果确实是这样的
		
		//对于可重复注解：
		//1）标着分散形式，只有1个，以分散形式存在
		//2）标着分散形式，至少2个，自动转换为容器形式，已容器形式存在
		//3）标着容器形式，即使是空的，也只能以容器形式存在
		//子类继承父类重写注解时：
		//1）子类和父类注解形式必须相同才可以重写
		//2）子类分散形式重写父类分散形式
		//3）子类容器形式重写父类容器形式
		//4）子类分散父类容器、子类容器父类分散，则不会重写，而是继承下来同时存在
	}
	
	static void test2() {
		//getDeclaredAnnotations()
		
		AnnotatedElement ae1 = C1.class;
		log.info("[C1] getDeclaredAnnotations()=[");
		Stream.of(ae1.getDeclaredAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出C1上标的三个注解
		
		AnnotatedElement ae2 = C2.class;
		log.info("[C2] getDeclaredAnnotations()=[");
		Stream.of(ae2.getDeclaredAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出C2上标的二个
		
		//result：此方法不考虑从父类的继承，只关注本类上有的
		
		//下面是对可重复注解的测试
		
		AnnotatedElement ae11 = CR11.class;
		log.info("[CR11] getDeclaredAnnotations()=[");
		Stream.of(ae11.getDeclaredAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR11上标的注解，发现都以容器的形式呈现
		
		AnnotatedElement ae21 = CR21.class;
		log.info("[CR21] getDeclaredAnnotations()=[");
		Stream.of(ae21.getDeclaredAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR21的注解，发现是空的，因为不考虑继承
		
		//result：可重复注解也遵循不继承规则
		
		AnnotatedElement ae22 = CR22.class;
		log.info("[CR22] getDeclaredAnnotations()=[");
		Stream.of(ae22.getDeclaredAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR22的注解，不考虑继承
		
		AnnotatedElement ae23 = CR23.class;
		log.info("[CR23] getDeclaredAnnotations()=[");
		Stream.of(ae23.getDeclaredAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR23的注解，不考虑继承
		
		AnnotatedElement ae31 = CR31.class;
		log.info("[CR31] getDeclaredAnnotations()=[");
		Stream.of(ae31.getDeclaredAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR31的注解，不考虑继承
		
		AnnotatedElement ae32 = CR32.class;
		log.info("[CR32] getDeclaredAnnotations()=[");
		Stream.of(ae32.getDeclaredAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR32的注解，不考虑继承
		
		AnnotatedElement ae33 = CR33.class;
		log.info("[CR33] getDeclaredAnnotations()=[");
		Stream.of(ae33.getDeclaredAnnotations()).forEach(ann -> log.info("{}", ann));
		log.info("]");
		//output：输出CR33的注解，不考虑继承
		
		//对于可重复注解：
		//1）标着分散形式，只有1个，以分散形式存在
		//2）标着分散形式，至少2个，自动转换为容器形式，已容器形式存在
		//3）标着容器形式，即使是空的，也只能以容器形式存在
		//子类不继承父类注解，不用考虑重写
	}
	
	static void test3() {
		//getAnnotation(Class<?>)
		
		AnnotatedElement ae1 = C1.class;
		log.info("getAnnotation(AnnC13.class)={}", ae1.getAnnotation(AnnC13.class));
		log.info("getAnnotation(AnnC33.class)={}", ae1.getAnnotation(AnnC33.class));
		log.info("getAnnotation(AnnC43.class)={}", ae1.getAnnotation(AnnC43.class));
		//output：只可以获取getAnnotations()方法返回的注解
		
		AnnotatedElement ae2 = C2.class;
		log.info("getAnnotation(AnnC23.class)={}", ae2.getAnnotation(AnnC23.class));
		log.info("getAnnotation(AnnC33.class)={}", ae2.getAnnotation(AnnC33.class));
		log.info("getAnnotation(AnnC43.class)={}", ae2.getAnnotation(AnnC43.class));
		//output：只可以获取getAnnotations()方法返回的注解
		
		//result：此方法只可以获取getAnnotations()方法返回的注解
		
		//可重复注解
		AnnotatedElement ae11 = CR11.class;
		log.info("getAnnotation(AnnRC11.class)={}", ae11.getAnnotation(AnnRC11.class));
		log.info("getAnnotation(AnnR11.class)={}", ae11.getAnnotation(AnnR11.class));
		log.info("getAnnotation(AnnRC12.class)={}", ae11.getAnnotation(AnnRC12.class));
		log.info("getAnnotation(AnnR12.class)={}", ae11.getAnnotation(AnnR12.class));
		//output：只可以获取getAnnotations()方法返回的注解
		//        因为是容器形式，所以只能获取容器注解。分散的获取不到
		
		//可重复注解
		AnnotatedElement ae21 = CR21.class;
		log.info("getAnnotation(AnnRC11.class)={}", ae21.getAnnotation(AnnRC11.class));
		log.info("getAnnotation(AnnR11.class)={}", ae21.getAnnotation(AnnR11.class));
		log.info("getAnnotation(AnnRC12.class)={}", ae21.getAnnotation(AnnRC12.class));
		log.info("getAnnotation(AnnR12.class)={}", ae21.getAnnotation(AnnR12.class));
		//output：只可以获取getAnnotations()方法返回的注解
		//        子类继承父类，和上一个输出的一样
		
		//可重复注解
		AnnotatedElement ae31 = CR31.class;
		log.info("getAnnotation(AnnRC11.class)={}", ae31.getAnnotation(AnnRC11.class));
		log.info("getAnnotation(AnnR11.class)={}", ae31.getAnnotation(AnnR11.class));
		//output：只可以获取getAnnotations()方法返回的注解
		//        因为是分散形式，所以只能获取分散注解。容器的获取不到
	}
	
	static void test4() {
		//getDeclaredAnnotation(Class<?>)
		
		AnnotatedElement ae1 = C1.class;
		log.info("getDeclaredAnnotation(AnnC13.class)={}", ae1.getDeclaredAnnotation(AnnC13.class));
		log.info("getDeclaredAnnotation(AnnC33.class)={}", ae1.getDeclaredAnnotation(AnnC33.class));
		log.info("getDeclaredAnnotation(AnnC43.class)={}", ae1.getDeclaredAnnotation(AnnC43.class));
		//output：只可以获取getDeclaredAnnotations()方法返回的注解
		
		AnnotatedElement ae2 = C2.class;
		log.info("getDeclaredAnnotation(AnnC23.class)={}", ae2.getDeclaredAnnotation(AnnC23.class));
		log.info("getDeclaredAnnotation(AnnC33.class)={}", ae2.getDeclaredAnnotation(AnnC33.class));
		log.info("getDeclaredAnnotation(AnnC43.class)={}", ae2.getDeclaredAnnotation(AnnC43.class));
		//output：只可以获取getDeclaredAnnotations()方法返回的注解
		
		//result：此方法只可以获取getDeclaredAnnotations()方法返回的注解
		
		//可重复注解
		AnnotatedElement ae11 = CR11.class;
		log.info("getDeclaredAnnotation(AnnRC11.class)={}", ae11.getDeclaredAnnotation(AnnRC11.class));
		log.info("getDeclaredAnnotation(AnnR11.class)={}", ae11.getDeclaredAnnotation(AnnR11.class));
		log.info("getDeclaredAnnotation(AnnRC12.class)={}", ae11.getDeclaredAnnotation(AnnRC12.class));
		log.info("getDeclaredAnnotation(AnnR12.class)={}", ae11.getDeclaredAnnotation(AnnR12.class));
		//output：只可以获取getDeclaredAnnotations()方法返回的注解
		//        因为是容器形式，所以只能获取容器注解。分散的获取不到
		
		//可重复注解
		AnnotatedElement ae21 = CR21.class;
		log.info("getDeclaredAnnotation(AnnRC11.class)={}", ae21.getDeclaredAnnotation(AnnRC11.class));
		log.info("getDeclaredAnnotation(AnnR11.class)={}", ae21.getDeclaredAnnotation(AnnR11.class));
		log.info("getDeclaredAnnotation(AnnRC12.class)={}", ae21.getDeclaredAnnotation(AnnRC12.class));
		log.info("getDeclaredAnnotation(AnnR12.class)={}", ae21.getDeclaredAnnotation(AnnR12.class));
		//output：只可以获取getDeclaredAnnotations()方法返回的注解
		//        因为不考虑从父类继承，所以全部都获取不到

		//可重复注解
		AnnotatedElement ae31 = CR31.class;
		log.info("getDeclaredAnnotation(AnnRC11.class)={}", ae31.getDeclaredAnnotation(AnnRC11.class));
		log.info("getDeclaredAnnotation(AnnR11.class)={}", ae31.getDeclaredAnnotation(AnnR11.class));
		//output：只可以获取getDeclaredAnnotations()方法返回的注解
		//        因为是分散形式，所以只能获取分散注解。容器的获取不到
	}
	
	static void test5() {
		//isAnnotationPresent(Class<?>)
		
		AnnotatedElement ae1 = C1.class;
		log.info("isAnnotationPresent(AnnC13.class)={}", ae1.isAnnotationPresent(AnnC13.class));
		log.info("isAnnotationPresent(AnnC33.class)={}", ae1.isAnnotationPresent(AnnC33.class));
		log.info("isAnnotationPresent(AnnC43.class)={}", ae1.isAnnotationPresent(AnnC43.class));
		//output：只可以获取getAnnotations()方法返回的注解
		
		AnnotatedElement ae2 = C2.class;
		log.info("isAnnotationPresent(AnnC23.class)={}", ae2.isAnnotationPresent(AnnC23.class));
		log.info("isAnnotationPresent(AnnC33.class)={}", ae2.isAnnotationPresent(AnnC33.class));
		log.info("isAnnotationPresent(AnnC43.class)={}", ae2.isAnnotationPresent(AnnC43.class));
		//output：只可以获取getAnnotations()方法返回的注解
		
		//result：此方法只可以获取getAnnotations()方法返回的注解
		
		//可重复注解
		AnnotatedElement ae11 = CR11.class;
		log.info("isAnnotationPresent(AnnRC11.class)={}", ae11.isAnnotationPresent(AnnRC11.class));
		log.info("isAnnotationPresent(AnnR11.class)={}", ae11.isAnnotationPresent(AnnR11.class));
		log.info("isAnnotationPresent(AnnRC12.class)={}", ae11.isAnnotationPresent(AnnRC12.class));
		log.info("isAnnotationPresent(AnnR12.class)={}", ae11.isAnnotationPresent(AnnR12.class));
		//output：只可以获取getAnnotations()方法返回的注解
		//        因为是容器形式，所以只能获取容器注解。分散的获取不到
		
		//可重复注解
		AnnotatedElement ae21 = CR21.class;
		log.info("isAnnotationPresent(AnnRC11.class)={}", ae21.isAnnotationPresent(AnnRC11.class));
		log.info("isAnnotationPresent(AnnR11.class)={}", ae21.isAnnotationPresent(AnnR11.class));
		log.info("isAnnotationPresent(AnnRC12.class)={}", ae21.isAnnotationPresent(AnnRC12.class));
		log.info("isAnnotationPresent(AnnR12.class)={}", ae21.isAnnotationPresent(AnnR12.class));
		//output：只可以获取getAnnotations()方法返回的注解
		//        子类继承父类，和上一个输出的一样
		
		//可重复注解
		AnnotatedElement ae31 = CR31.class;
		log.info("isAnnotationPresent(AnnRC11.class)={}", ae31.isAnnotationPresent(AnnRC11.class));
		log.info("isAnnotationPresent(AnnR11.class)={}", ae31.isAnnotationPresent(AnnR11.class));
		//output：只可以获取getAnnotations()方法返回的注解
		//        因为是分散形式，所以只能获取分散注解。容器的获取不到	
	}
	
	static void test6() {
		//getAnnotationsByType(Class<?>)
		
		AnnotatedElement ae1 = C1.class;
		log.info("getAnnotationsByType(AnnC13.class)={}", Arrays.toString(ae1.getAnnotationsByType(AnnC13.class)));
		log.info("getAnnotationsByType(AnnC33.class)={}", Arrays.toString(ae1.getAnnotationsByType(AnnC33.class)));
		log.info("getAnnotationsByType(AnnC43.class)={}", Arrays.toString(ae1.getAnnotationsByType(AnnC43.class)));
		//output：只可以获取getAnnotations()方法返回的注解
		
		AnnotatedElement ae2 = C2.class;
		log.info("getAnnotationsByType(AnnC23.class)={}", Arrays.toString(ae2.getAnnotationsByType(AnnC23.class)));
		log.info("getAnnotationsByType(AnnC33.class)={}", Arrays.toString(ae2.getAnnotationsByType(AnnC33.class)));
		log.info("getAnnotationsByType(AnnC43.class)={}", Arrays.toString(ae2.getAnnotationsByType(AnnC43.class)));
		//output：只可以获取getAnnotations()方法返回的注解
		
		//result：此方法只可以获取getAnnotations()方法返回的注解
		
		//可重复注解
		AnnotatedElement ae11 = CR11.class;
		log.info("getAnnotationsByType(AnnRC11.class)={}", Arrays.toString(ae11.getAnnotationsByType(AnnRC11.class)));
		log.info("getAnnotationsByType(AnnR11.class)={}", Arrays.toString(ae11.getAnnotationsByType(AnnR11.class)));
		log.info("getAnnotationsByType(AnnRC12.class)={}", Arrays.toString(ae11.getAnnotationsByType(AnnRC12.class)));
		log.info("getAnnotationsByType(AnnR12.class)={}", Arrays.toString(ae11.getAnnotationsByType(AnnR12.class)));
		//output：只可以获取getAnnotations()方法返回的注解
		//        如果寻找分散形式，但不存在。则会寻找它的容器，找到的话则取出容器中的值返回，否则就是没找到
		
		//可重复注解
		AnnotatedElement ae21 = CR21.class;
		log.info("getAnnotationsByType(AnnRC11.class)={}", Arrays.toString(ae21.getAnnotationsByType(AnnRC11.class)));
		log.info("getAnnotationsByType(AnnR11.class)={}", Arrays.toString(ae21.getAnnotationsByType(AnnR11.class)));
		log.info("getAnnotationsByType(AnnRC12.class)={}", Arrays.toString(ae21.getAnnotationsByType(AnnRC12.class)));
		log.info("getAnnotationsByType(AnnR12.class)={}", Arrays.toString(ae21.getAnnotationsByType(AnnR12.class)));
		//output：只可以获取getAnnotations()方法返回的注解
		//        子类继承父类，和上一个输出的一样
		
		//可重复注解
		AnnotatedElement ae31 = CR31.class;
		log.info("getAnnotationsByType(AnnRC11.class)={}", Arrays.toString(ae31.getAnnotationsByType(AnnRC11.class)));
		log.info("getAnnotationsByType(AnnR11.class)={}", Arrays.toString(ae31.getAnnotationsByType(AnnR11.class)));
		//output：只可以获取getAnnotations()方法返回的注解
		//        如果寻找容器，但不存在，那就不存在了。
		
		//result：带ByType与不带的唯一区别是，当寻找可重复注解时，如不存在则尝试寻找它的容器，并从容器中获取该重复注解。
		//        如果容器也不存在，那就认为不存在了。
	}
	
	static void test7() {
		//getDeclaredAnnotationsByType(Class<?>)
		
		AnnotatedElement ae1 = C1.class;
		log.info("getDeclaredAnnotationsByType(AnnC13.class)={}", Arrays.toString(ae1.getDeclaredAnnotationsByType(AnnC13.class)));
		log.info("getDeclaredAnnotationsByType(AnnC33.class)={}", Arrays.toString(ae1.getDeclaredAnnotationsByType(AnnC33.class)));
		log.info("getDeclaredAnnotationsByType(AnnC43.class)={}", Arrays.toString(ae1.getDeclaredAnnotationsByType(AnnC43.class)));
		//output：只可以获取getDeclaredAnnotations()方法返回的注解
		
		AnnotatedElement ae2 = C2.class;
		log.info("getDeclaredAnnotationsByType(AnnC23.class)={}", Arrays.toString(ae2.getDeclaredAnnotationsByType(AnnC23.class)));
		log.info("getDeclaredAnnotationsByType(AnnC33.class)={}", Arrays.toString(ae2.getDeclaredAnnotationsByType(AnnC33.class)));
		log.info("getDeclaredAnnotationsByType(AnnC43.class)={}", Arrays.toString(ae2.getDeclaredAnnotationsByType(AnnC43.class)));
		//output：只可以获取getDeclaredAnnotations()方法返回的注解
		
		//result：此方法只可以获取getDeclaredAnnotations()方法返回的注解
		
		//可重复注解
		AnnotatedElement ae11 = CR11.class;
		log.info("getDeclaredAnnotationsByType(AnnRC11.class)={}", Arrays.toString(ae11.getDeclaredAnnotationsByType(AnnRC11.class)));
		log.info("getDeclaredAnnotationsByType(AnnR11.class)={}", Arrays.toString(ae11.getDeclaredAnnotationsByType(AnnR11.class)));
		log.info("getDeclaredAnnotationsByType(AnnRC12.class)={}", Arrays.toString(ae11.getDeclaredAnnotationsByType(AnnRC12.class)));
		log.info("getDeclaredAnnotationsByType(AnnR12.class)={}", Arrays.toString(ae11.getDeclaredAnnotationsByType(AnnR12.class)));
		//output：只可以获取getDeclaredAnnotations()方法返回的注解
		//        如果寻找分散形式，但不存在。则会寻找它的容器，找到的话则取出容器中的值返回，否则就是没找到
		
		//可重复注解
		AnnotatedElement ae21 = CR21.class;
		log.info("getDeclaredAnnotationsByType(AnnRC11.class)={}", Arrays.toString(ae21.getDeclaredAnnotationsByType(AnnRC11.class)));
		log.info("getDeclaredAnnotationsByType(AnnR11.class)={}", Arrays.toString(ae21.getDeclaredAnnotationsByType(AnnR11.class)));
		log.info("getDeclaredAnnotationsByType(AnnRC12.class)={}", Arrays.toString(ae21.getDeclaredAnnotationsByType(AnnRC12.class)));
		log.info("getDeclaredAnnotationsByType(AnnR12.class)={}", Arrays.toString(ae21.getDeclaredAnnotationsByType(AnnR12.class)));
		//output：只可以获取getDeclaredAnnotations()方法返回的注解
		//        子类不继承父类，所以输出都是空
		
		//可重复注解
		AnnotatedElement ae31 = CR31.class;
		log.info("getDeclaredAnnotationsByType(AnnRC11.class)={}", Arrays.toString(ae31.getDeclaredAnnotationsByType(AnnRC11.class)));
		log.info("getDeclaredAnnotationsByType(AnnR11.class)={}", Arrays.toString(ae31.getDeclaredAnnotationsByType(AnnR11.class)));
		//output：只可以获取getDeclaredAnnotations()方法返回的注解
		//        如果直接寻找容器，但不存在，那就不存在了。
		
		//result：带ByType与不带的唯一区别是，当寻找可重复注解时，如不存在则尝试寻找它的容器，并从容器中获取该重复注解。
		//        如果容器也不存在，那就认为不存在了。
	}

}
