package connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void Run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);

        while (true){
            System.out.println("wating for a client...");
            Socket socket = serverSocket.accept();
            System.out.println("client connected.");
            Thread clientThread = new ClientThread(socket);
            clientThread.start();
        }
    }
}
