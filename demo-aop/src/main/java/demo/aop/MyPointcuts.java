package demo.aop;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

	@Pointcut("execution(* MyBean.*(*))")
	public void callToMyBean() {
	}

	@Pointcut("within(MyBean)")
	public void withinMyBean() {
	}
}
