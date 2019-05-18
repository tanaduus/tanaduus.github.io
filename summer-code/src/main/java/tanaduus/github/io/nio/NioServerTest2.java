package tanaduus.github.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class NioServerTest2 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8080);
        serverSocketChannel.bind(inetSocketAddress);

        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(5);

        int length = 2 + 3 + 5;

        SocketChannel channel = serverSocketChannel.accept();

        while (true) {
            long reads = 0;
            while(reads<length){
                long r = channel.read(buffers);
                reads += r;
            }

            Arrays.asList(buffers).forEach(Buffer::flip);

            channel.write(buffers);

            Arrays.asList(buffers).forEach(Buffer::clear);
        }
    }

    public static void main2(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        serverSocket.accept();
    }
}
