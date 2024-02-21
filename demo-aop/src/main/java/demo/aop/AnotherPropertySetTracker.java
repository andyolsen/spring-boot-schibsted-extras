package demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnotherPropertySetTracker {

	@Pointcut("execution(void MySampleClass.set*(*))")
	public void setterMethodExecuted() {
	}

	@Before("setterMethodExecuted()")
	public void logPropertyChange(JoinPoint jp) {
		System.out.println("Target: "            + jp.getTarget() + 
				           " Method: "           + jp.getSignature().getName() + 
				           " Setting to value: " + jp.getArgs()[0]);
	}
}
