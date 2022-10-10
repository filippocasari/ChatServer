package Assignment1.exercise4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class HandlingClientThread implements Runnable {
    private Socket socket;
    public HandlingClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(this.socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if ((!socket.isConnected() || in.readLine()==null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            try {

                System.out.println("Client says: " + in.readLine());
                out.println("Server here. I have received your message!");
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // Write out our header to the client



        System.out.println("Closing connection");
        /////////////////
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.close();
        try {
            this.socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
