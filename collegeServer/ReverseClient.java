package collegeServer;

import java.net.*;
import java.io.*;

public class ReverseClient {
  public static void main(String [] args) {

    String s;                       // the string to reverse 

   // if (args.length != 1){
    //  System.out.println("Usage: java ReverseClient host");
     // System.exit(1);
    
    //else
    
    try {
        Socket server = new Socket("127.0.0.1",567);
        System.out.println("Connected to ReverseSever host " + server.getInetAddress());
        BufferedReader fromServer = new BufferedReader (new InputStreamReader(server.getInputStream()));
        PrintWriter toServer = new PrintWriter (server.getOutputStream(),true);
        BufferedReader input = new BufferedReader( new InputStreamReader(System.in));

        System.out.print("# ");                          // prompt client for another message
        System.out.flush();                              // display prompt
        s = input.readLine();                            // receive message from client

        while (!s.equals("quit")) {
           toServer.println(s);                          // send client's message to server
           System.out.println(fromServer.readLine());    // receive and print response from server

           System.out.print("# ");                       // prompt client for another message
           System.out.flush();                           // display prompt
           s = input.readLine();                         // receive message from client; "quit" ends
        } // while

        // cleanup; close all streams
        fromServer.close();
        toServer.close();
        input.close(); 
        server.close();

    } // try
    catch(Exception e) {
         e.printStackTrace();
    } // catch
  } // main
} // ReverseClient          
