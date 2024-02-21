package demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PropertySetTracker {

	@Before("execution(void MySampleClass.set*(*))")
	public void logPropertyChange() {
		System.out.println("A property is about to be set");
	}
}
