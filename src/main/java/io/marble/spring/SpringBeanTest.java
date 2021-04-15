package io.marble.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:marbleBean.xml");
        Girl girl1 = (Girl) context.getBean("girl1");
        System.out.println(girl1);

        Girl girl2 = (Girl) context.getBean("girl2");
        System.out.println(girl2);


    }
}
