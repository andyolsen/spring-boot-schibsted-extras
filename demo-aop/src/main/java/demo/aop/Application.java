package demo.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        demoSimpleAspects(context);
        demoAdditionalAspects(context);
    }

    public static void demoSimpleAspects(ApplicationContext context) {

        MySampleInterface bean1 = context.getBean("mySampleBean1", MySampleInterface.class);
        System.out.println("Got bean1, type is " + bean1.getClass());

        bean1.setMessage("Croeso");
        bean1.setNumber(100);
        bean1.display();
    }

    public static void demoAdditionalAspects(ApplicationContext context) {

        MyBeanInterface bean = context.getBean("myBean", MyBeanInterface.class);

        System.out.println("About to call bean.someMethod()...");
        bean.someMethod("Cymru");
        System.out.println("Returned from bean.someMethod()\n");

        System.out.println("About to call bean.anotherMethod()...");
        int result = bean.anotherMethod(5);
        System.out.printf("Returned from bean.anotherMethod() with %d\n", result);
    }
}
