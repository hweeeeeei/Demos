package com.test.main;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


public class ShiroDemoHelloWorld {
    private static Logger logger = Logger.getLogger(ShiroDemoHelloWorld.class);


    public static void main(String[] args) {

//        原文：https://blog.csdn.net/qq_26525215/article/details/78059488

        // 读取配置文件, 加载securityManager工厂 securityManager=认证/授权
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //获取securityManager 实例
        SecurityManager securityManager = factory.getInstance();

        //把securityManager实例绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);

        //得到当前执行的用户   Subject=主体
        Subject subject = SecurityUtils.getSubject();//认证实体，当前进来的用户


        //创建token令牌，用户名/密码
        UsernamePasswordToken token = new UsernamePasswordToken("hewei", "123456");

        //身份认证
        try {
            subject.login(token);
            logger.info("登录成功！");

            System.out.println("成功");
        } catch (AuthenticationException e) {
            //login的接口函数  void login(AuthenticationToken var1)
            // throws AuthenticationException;所以直接抓AuthenticationException异常即可
            //身份认证失败即抛出此异常
            logger.info("登录失败！");

            System.out.println("失败");
            e.printStackTrace();
        }
        //登出
        subject.logout();


    }
}
