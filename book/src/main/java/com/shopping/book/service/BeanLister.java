package com.shopping.book.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanLister implements CommandLineRunner {


    /*
     * There are different implementations of the ApplicationContext interface,
     * for example ClassPathXmlApplicationContext, FileSystemXmlApplicationContext,
     *  and AnnotationConfigApplicationContext,
     * which allow you to load the application context from an XML file or Java configuration class.
     * */


    @Autowired
    private ApplicationContext applicationContext;

//    @Override
//    public void run(String... args) throws Exception {
//        String[] beanNames = applicationContext.getBeanDefinitionNames();
//        for(String beanName : beanNames) {
//            // check if the package name starts with a known base package
//            System.out.println(beanName);
//        }
//    }


    @Override
    public void run(String... args) throws Exception {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = applicationContext.getBean(beanName);
            String packageName = bean.getClass().getPackage().getName();
            if (packageName.startsWith("com.shopping.book")) {
                System.out.println(beanName);
                 }
            }
        }
    }


