package collegeServer;

import java.net.*;
import java.io.*;

public class ReverseServer {
  public static void main(String [] args) {
    String s;  // the string to reverse
    int size;  // the length of the string
    char [] c; // the reversed characters 
    try {
        ServerSocket server = new ServerSocket(567);
        Socket client= server.accept();   // <===
        System.out.println("Reverse Server Connected on port 567");
        BufferedReader input = new BufferedReader (new InputStreamReader(client.getInputStream()));
        PrintWriter output = new PrintWriter (client.getOutputStream(),true);
        while ((s = input.readLine()) != null){
           size = s.length();
           c = new char[size]; 
           for (int i=0; i<size; i++)
             c[i] = s.charAt(size-1-i);
           output.println(c);
       }
        input.close();
        output.close();
        client.close();
    }catch(Exception e) {
         e.printStackTrace();
    }
  }
}  
