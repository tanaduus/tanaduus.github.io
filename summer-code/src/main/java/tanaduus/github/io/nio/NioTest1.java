package tanaduus.github.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/tanaduus/git-repo/net-framework/src/main/java/com.summer.nio/text");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        while(byteBuffer.hasRemaining()){
            byte b = byteBuffer.get();
            System.out.print((char)b);
        }
    }
}
