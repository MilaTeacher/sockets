package sockets;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadingFromStream extends Thread{
   private BufferedReader in;
   public ReadingFromStream(BufferedReader in) {
       this.in = in;
   }

@Override
public void run() {
    try {
        String line;
        while ((line = in.readLine()) != null) {
            if (line.equals("exit")) {
                break;
            }
            System.out.println("Client -> received message: " + line);
        }
    } catch (IOException e) {
        if (!(e instanceof java.net.SocketException && e.getMessage().equals("Socket closed"))) {
            System.err.println("Client -> Error reading from server: " + e.getMessage());
        }
    } finally {
        try {
            in.close();
        } catch (IOException e) {
            // Handle closing exception if needed
            e.printStackTrace();
        }
    }
}


}
