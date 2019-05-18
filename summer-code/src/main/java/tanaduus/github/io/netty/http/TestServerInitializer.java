package tanaduus.github.io.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //添加处理器
        //编解码处理器
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        //自定义处理器
        pipeline.addLast("testHttpServerHandler",new TestHttpServerHandler());
    }
}
