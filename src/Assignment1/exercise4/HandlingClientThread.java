package Assignment1.exercise4;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class HandlingClientThread extends Thread {

    private int id = 0;


    String line = null;
    BufferedReader is = null;
    PrintWriter os = null;
    Socket s = null;

    public HandlingClientThread(Socket socket, int id) {
        this.s = socket;
        this.id = id;
    }

    public void run() {
        System.out.println("starting thread to handle client");
        try {
            is = new BufferedReader(new InputStreamReader(s.getInputStream()));
            os = new PrintWriter(s.getOutputStream());

        } catch (IOException e) {
            System.out.println("IO error in server thread");
        }

        try {

            line = is.readLine();

            while (line.compareTo("end") != 0) {
                System.out.println("client "+id+" said: "+ line);
                os.println("Server here. ACK\n");
                os.flush();

                line = is.readLine();
            }
        } catch (IOException e) {

            line = this.getName(); //reused String line for getting thread name
            System.out.println("IO Error/ Client " + line + " terminated abruptly");
        } catch (NullPointerException e) {
            line = this.getName(); //reused String line for getting thread name
            System.out.println("Client " + line + " Closed");
        } finally {
            try {
                System.out.println("Connection Closing..");
                if (is != null) {
                    is.close();
                    System.out.println(" Socket Input Stream Closed");
                }

                if (os != null) {
                    os.close();
                    System.out.println("Socket Out Closed");
                }
                if (s != null) {
                    s.close();
                    System.out.println("Socket Closed");
                }

            } catch (IOException ie) {
                System.out.println("Socket Close Error");
            }
        }//end finally
    }


}
