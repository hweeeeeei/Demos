package com.test;


import com.inte.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String args[]) {

        //参考文章：http://www.cnblogs.com/xrq730/p/4919025.html
        //参考文章：http://www.cnblogs.com/hongwz/p/5764917.html

        // 加载配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");

        HelloWorld he1 = (HelloWorld) ctx.getBean("helloWorldImpl1");
        HelloWorld he2 = (HelloWorld) ctx.getBean("helloWorldImpl2");

        he1.printHelloWorld();
        System.out.println();
        he1.doPrint();

        System.out.println("-------");

        he2.printHelloWorld();
        System.out.println();
        he2.doPrint();
        //给HelloWorld接口的两个实现类的所有方法都加上了代理，代理内容就是打印时间


    }
}
