package tanaduus.github.io.design.reactor模式.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class NioServer {

    public static void main(String[] args) throws IOException {
        // 创建ServerSocketChannel,监听8080端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        // 设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);

        // 为serverSocketChannel注册选择器
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 创建处理器
        Handler handler = new Handler(1024);
        while (true) {
            // 等待请求,每次等待阻塞3s,超过3s后线程继续向下运行,如果传入0或者不传入参数将一直阻塞
            if (selector.select(3000) == 0) {
                System.out.println("等待请求超时....");
                continue;
            }
            System.out.println("处理请求....");

            // 获取待处理的SelectionKey
            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
            while (keyIter.hasNext()) {
                SelectionKey key = keyIter.next();
                try {
                    // 接收到连接请求时
                    if (key.isAcceptable()) {
                        handler.handlerAccept(key);
                    }

                    // 接收到读数据时
                    if (key.isReadable()) {
                        handler.handleRead(key);
                    }

                } catch (Exception e) {
                    keyIter.remove();
                    continue;
                }

                // 处理完毕,从待处理的SelectionKey迭代器中移除当前所使用的key
                keyIter.remove();
            }
        }
    }
}

