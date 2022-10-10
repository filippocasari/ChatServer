package Assignment1.exercise2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server = null;

    private BufferedReader in = null;


    public Server(int port) {
        try {

            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Just connected with " + server.getInetAddress());
            Socket socket = server.accept();


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            System.out.println("Client says: " + in.readLine());
            // Write out our header to the client
            out.println("Server here. I have received your message! [ACK]");
            out.flush();


            System.out.println("Closing connection");
            /////////////////
            in.close();
            out.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: server [port]");
            System.exit(0);
        }
        Server server = new Server(Integer.parseInt(args[0]));


        System.out.println("Server shutting down...");


    }

}
