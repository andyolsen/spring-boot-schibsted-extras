package demo.aop;

import org.springframework.stereotype.Component;

@Component
public class MyBean implements MyBeanInterface {

	@Override
	public void someMethod(String str) {
		System.out.printf("Hello from MyBean.someMethod() with %s\n", str);
	}

	@Override
	public int anotherMethod(int num) {
		System.out.printf("Hello from MyBean.anotherMethod() with %d\n", num);
		System.out.printf("I am going to return %d\n", num*10);
		return num * 10;
	}
}
