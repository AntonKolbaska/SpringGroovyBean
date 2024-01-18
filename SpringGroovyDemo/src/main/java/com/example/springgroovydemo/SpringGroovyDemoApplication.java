package com.example.springgroovydemo;

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class SpringGroovyDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringGroovyDemoApplication.class, args);

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        GroovyBeanDefinitionReader reader = new GroovyBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(new ClassPathResource("bean.groovy"));

        Object mrBean = factory.getBean("mrBean", MrBean.class);
        System.out.println(mrBean.toString());
    }

}
