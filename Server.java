import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
    final int PORT = 20000;
    Logger logger = Logger.getLogger("server.logger");

    public Server() {

    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            logger.info("Waiting for connection...");
            Socket clientSocket = serverSocket.accept(); // Listens for a connection to be made to this socket and //
                                                         // accepts it, gives a client socket to the other endpoint
            logger.info("Connection made!");
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            String command = input.readLine();
            if (command.equals("message")) {
                String message = input.readLine();
                System.out.println(message);
            } else if (command.equals("exit")) {
                return;
            } else {
                System.out.println("Bad command!");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server myServer = new Server();
        myServer.run();
    }
}