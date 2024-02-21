package demo.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public MySampleClass mySampleBean1() {
		MySampleClass bean = new MySampleClass();
		bean.setA("Hello world");
		bean.setB(21);
		return bean;
	}
	
	@Bean
	public MySampleClass mySampleBean2() {
		MySampleClass bean = new MySampleClass();
		bean.setA("Bonjour");
		bean.setB(42);
		return bean;
	}
}
