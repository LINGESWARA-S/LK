import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started. Waiting for client...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        String message;
        while ((message = input.readLine()) != null) {
            System.out.println("Client: " + message);
            System.out.print("You: ");
            String reply = consoleInput.readLine();
            output.println(reply);
        }

        clientSocket.close();
        serverSocket.close();
    }
}