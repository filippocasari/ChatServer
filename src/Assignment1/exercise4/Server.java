package Assignment1.exercise4;

import Assignment1.exercise3.UserthreadFriend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    private ServerSocket server = null;

    private BufferedReader in = null;
    public Socket s;

    public Server(int port) throws IOException {
        try {

            server = new ServerSocket(port);
            System.out.println("Server started");
            while(true){

                s = server.accept();
                Random num = new Random();
                int id = num.nextInt();
                System.out.println("connection Established");
                System.out.println("Just connected with the id client " + id);

                Thread r = new HandlingClientThread(s, id);
                r.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        server.close();
    }



    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: server [port]");
            System.exit(0);
        }
        Server server = new Server(Integer.parseInt(args[0]));


        System.out.println("Server shutting down...");


    }

}
