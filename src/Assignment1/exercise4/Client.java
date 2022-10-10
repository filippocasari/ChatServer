package Assignment1.exercise4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final String ip;
    private final int port;
    private DataOutputStream os;
    private BufferedReader is;
    Socket socket;

    public Client(String ip, int port) throws IOException {
        this.port = port;
        this.ip = String.valueOf(ip);


    }

    public void readServerResponse() {
        try {
            socket = new Socket(this.ip, this.port);
            os = new DataOutputStream(socket.getOutputStream());
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Client is trying to connect to " + this.ip + ":" + this.port);
            Scanner scanner = new Scanner(System.in);
            String inputString = "";
            while(!inputString.equals("end\n"))
             {
                inputString = scanner.nextLine();
                os.writeBytes(inputString + "\n");
                os.flush();
                int read;
                System.out.println(inputString);
                while ((read = socket.getInputStream().read()) > -1) {
                    System.out.print((char) read);
                }

            };



        } catch (Exception e) {
            System.err.println("something went wrong");
        }

    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: server [ip][port]");
            System.exit(0);
        }
        Client client = new Client(args[0], Integer.parseInt(args[1]));
        client.readServerResponse();

        System.out.println("Server shutting down...");


    }
}
