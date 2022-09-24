package tanaduus.github.io.design.reactor.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Handler {

    private int bufferSize = 1024;
    private String localCharset = "UTF-8";

    public Handler() {
        super();
    }

    public Handler(int bufferSize) {
        this(bufferSize, null);
    }

    public Handler(String localCharset) {
        this(-1, localCharset);
    }

    public Handler(int bufferSize, String localCharset) {
        if (bufferSize > 0) {
            this.bufferSize = bufferSize;
        }
        if (localCharset != null) {
            this.localCharset = localCharset;
        }
    }

    public void handlerAccept(SelectionKey key) throws IOException {
        SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
    }

    public void handleRead(SelectionKey key) throws IOException {
        // 获取channel
        SocketChannel socketChannel = (SocketChannel) key.channel();

        // 获取buffer并重置
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();

        // 没有读到内容则关闭
        if (socketChannel.read(buffer) == -1) {
            socketChannel.close();
        } else {
            // 将buffer转换为读状态
            buffer.flip();

            // 将buffer中接收到的值按localCharset格式编码后保存到receivedString
            String receivedString = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
            System.out.println("received from client: " + receivedString);

            // 返回数据给客户端
            String sendString = "sending to client: " + receivedString;
            buffer = ByteBuffer.wrap(sendString.getBytes(localCharset));

            //关于write和OP_WRITE,后者更好
            socketChannel.write(buffer);

            // 关闭socket
            socketChannel.close();
        }

    }

}