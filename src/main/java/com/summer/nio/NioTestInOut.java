package com.summer.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NioTestInOut {

    public static void main2(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("/Users/tanaduus/git-repo/net-framework/input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/tanaduus/git-repo/net-framework/output.txt");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        while(true){
            byteBuffer.clear();
            int read = inputChannel.read(byteBuffer);
            System.out.println(read);
            if(read==-1){
                break;
            }

            byteBuffer.flip();
            outputChannel.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/tanaduus/git-repo/net-framework/output.txt");
        FileChannel outChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(30);
        String str = "tanaduus hello \n夏神啊!";
        byte[] bytes= str.getBytes("UTF-8");
        byteBuffer.put(bytes);
        byteBuffer.flip();
        outChannel.write(byteBuffer);
        outChannel.close();
        fileOutputStream.close();
    }
}
