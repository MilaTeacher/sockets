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
    
        String line;
        try {
			while ((line = in.readLine()) != null) {
			    if (line.equals("exit")) {
			        break;
			    }
			    System.out.println("Client -> received message: " + line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  
    
}
}


