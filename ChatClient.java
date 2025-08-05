import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost", 1234);
        System.out.println("Connected to server.");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        String message;
        while (true) {
            System.out.print("You: ");
            message = consoleInput.readLine();
            output.println(message);

            String reply = input.readLine();
            System.out.println("Server: " + reply);
        }
    }
}
