package collegeServer;
import java.io.*;
import java.net.*;

/**
 * This program is a very simple Web server.  When it receives a HTTP request,
 * it just sends the request back to the client. This default port this
 * server listens to is 1500.
 * 
 * Usage:
 *
 * 	java HttpRequestMirror <port>
 * 
 **/
public class HttpRequestMirror {
  public static void main(String args[]) throws IOException {
      // Get the port to listen on
	int port = 1500;

	if (args.length == 1)
		port = Integer.parseInt(args[0]);

    try {
      // Create a ServerSocket 
      ServerSocket ss = new ServerSocket(port);
      System.out.println("Server bound at port " + ss.getLocalPort());

      while (true) {
        Socket client = ss.accept();

        // Get input and output streams to talk to the client from the socket
        BufferedReader in = 
          new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out =
          new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

        // Start sending our reply, using the HTTP 1.1 protocol
        out.println("HTTP/1.1 200 ");             
        out.println("Content-Type: text/plain");   
        out.println();                         // send the empty line    
        out.flush();

        // Now, read the HTTP request from the client, and echo it back to the client.
        // When we read an empty line, we stop reading and close the connection.  
        String line;
        while((line = in.readLine()) != null) {
          if (line.length() == 0) break;
          out.println(line);
        }

        // close the connection and resume waiting for additional connections
        out.close();
        in.close();
        client.close();
      } 
    }
    catch (Exception e) {
      System.err.println(e);
      System.err.println("Usage: java HttpRequestMirror <port>");
    }
  }
}
