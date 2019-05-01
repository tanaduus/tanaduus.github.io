package com.summer.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServerTest1 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));

        int length = 10;

        //获取堆外内存
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);

        SocketChannel socketChannel = serverSocketChannel.accept();

        while(true){
            int reads = 0;
            while(reads<length){
                int r = socketChannel.read(byteBuffer);
                reads += r;
            }

            byteBuffer.flip();

            socketChannel.write(byteBuffer);

            byteBuffer.flip();
            while(byteBuffer.hasRemaining()) {
                System.out.print((char)byteBuffer.get());
            }

            byteBuffer.clear();
        }
    }
}
