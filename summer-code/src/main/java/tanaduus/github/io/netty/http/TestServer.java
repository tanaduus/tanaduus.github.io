package tanaduus.github.io.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Http服务
 *
 * @author XiaJL created 2018/7/3
 */
public class TestServer {

    public static void main(String[] args) throws InterruptedException {
        //定义两个事件循环组(死循环)
        //接收连接线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //处理连接线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //服务端启动器
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            //定义服务管道方式，处理器
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new TestServerInitializer());

            //服务绑定端口并启动
            ChannelFuture channelFuture = serverBootstrap.bind(8888).sync();
            channelFuture.channel().closeFuture().sync();

        }finally{
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
