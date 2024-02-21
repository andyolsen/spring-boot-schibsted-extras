package demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PropertySetTrackerV2 {

	@Pointcut("execution(void MySampleClass.set*(*))")
	public void setterMethodExecuted() {}

	@Before("setterMethodExecuted()")
	public void logPropertyChange() {
		System.out.println("A property is about to be set…");
	}
}
