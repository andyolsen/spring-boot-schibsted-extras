package demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Before("demo.aop.MyPointcuts.callToMyBean()")
	public void logCallToBean() {
		System.out.println("***Call to bean");
	}

	@Before("demo.aop.MyPointcuts.withinMyBean()")
	public void logWithinBean() {
		System.out.println("***Within bean");
	}
}
