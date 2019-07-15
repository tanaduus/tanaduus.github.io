package tanaduus.github.io.nio.io;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("148.70.72.81", 8899);

        TimeUnit.SECONDS.sleep(10);
        socket.close();

        while(true){

        }
    }
}

