package Assignment1.exercise1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    private ServerSocket server = null;

    private BufferedReader in = null;
    private BufferedWriter out = null;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            //System.out.println("Just connected to " + server.getInetAddress());
            Socket socket = server.accept();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Waiting for a client ...");

            // What shall we put here?
            ////////////////////
            System.out.println("Just connected to " + server.getLocalSocketAddress());

            System.out.println("Client says: "+in.readLine());


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
