package com.summer.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/tanaduus/git-repo/net-framework/src/main/java/com.summer.nio/text");
        FileChannel fileChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        byteBuffer.put((byte)'x');
        byteBuffer.put((byte)'i');
        byteBuffer.put((byte)'a');
        byteBuffer.put((byte)' ');
        byteBuffer.put((byte)'j');
        byteBuffer.put((byte)'i');
        byteBuffer.put((byte)'a');
        byteBuffer.put((byte)' ');
        byteBuffer.put((byte)'l');
        byteBuffer.put((byte)'o');
        byteBuffer.put((byte)'n');
        byteBuffer.put((byte)'g');
        byteBuffer.flip();
        fileChannel.write(byteBuffer);


    }
}
