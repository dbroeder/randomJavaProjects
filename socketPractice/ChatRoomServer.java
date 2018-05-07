package socketPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatRoomServer {
	
	public static void main(String[] args) throws IOException
	{
		ServerSocket server = new ServerSocket(9090);
		try{
			while(true)
			{
				Socket client = server.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream());
				out.println("Welcome to Mr. Broeder's class chat room. You are user ")
			}
		}catch(IOException ioe)
		{
			
		}
		
		
	}
	
}
