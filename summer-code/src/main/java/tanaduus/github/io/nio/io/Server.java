package tanaduus.github.io.nio.io;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);

        serverSocket.accept();

        while(true){

        }
    }
}
