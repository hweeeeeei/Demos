package com.hewei.netty.listener;

import com.hewei.netty.service.NettyServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

/**
 * @Description: 服务启动端口监听器
 * <br>
 * @CreateDate: Created in 2019/3/5 15:53 <br>
 * @Author: hewei
 */
@Component
public class NettyServerListener {


    public void ServerStart() {


        /**
         * 连接处理线程, 不做任何逻辑处理
         */
        EventLoopGroup boss = new NioEventLoopGroup();

        /**
         * 事件处理 , 任务处理
         */
        EventLoopGroup word = new NioEventLoopGroup();



        //服务启动类，任务分配自动处理
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        //针对一个之前的线程模型（上面定义的是主从线程）
        ServerBootstrap bootstrap = serverBootstrap.group(boss, word)
                //设置NIO的双向通道
                .channel(NioServerSocketChannel.class)

                //子处理器，用于处理workerGroup
                /**
                 * 设置chanel初始化器
                 * 每一个chanel由多个handler共同组成管道(pipeline)
                 */
                .childHandler(new NettyServer());


    }


}
