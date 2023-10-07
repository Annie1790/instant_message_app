import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client {
    Logger logger = Logger.getLogger("client.logger");

    public void run() {
        logger.info("Connecting to client...");
        try {
            Socket socket = new Socket("127.0.0.1", 20000);
            logger.info("Connected!");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); //true makes sure .flush() method is called after execution
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("message:");
                String userInput = scanner.nextLine();
                output.println("message");
                output.println(userInput);
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client myClient = new Client();
        myClient.run();
    }
}
