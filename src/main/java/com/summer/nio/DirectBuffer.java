package com.summer.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class DirectBuffer {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("/Users/tanaduus/git-repo/net-framework/input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/tanaduus/git-repo/net-framework/output.txt");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4);
        while(true){
            int number = inputChannel.read(byteBuffer);
            System.out.println(number);
            if(number==-1){
                break;
            }
            byteBuffer.flip();
            outputChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
