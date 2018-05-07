package collegeServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NameServiceClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{
			Socket server = new Socket("127.0.0.1",6052);
	        System.out.println("Connected to NamingServiceServer host " + server.getInetAddress());
	        BufferedReader fromServer = new BufferedReader (new InputStreamReader(server.getInputStream()));
	        PrintWriter toServer = new PrintWriter (server.getOutputStream(),true);
	        BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
	        
	        System.out.print("Enter IP name to receive its IP address\nTo exit enter ^] ");
	        System.out.flush();
	        String s=input.readLine();
	        String p;
	        
	        while (!s.equals("^]"))
	        {
	        	toServer.println(s);
	        	if((p=fromServer.readLine()).contains("Please"))
	        	{
	        		System.out.print(p);
	        		System.out.flush();
	        		s=input.readLine();
	        	}
	        	else
	        	{
	        		System.out.println("The IP address is "+p+"\nThank you for using this program.");
	        		break;
	        	}
	        		
	        	
	        }
	        input.close();
	        fromServer.close();
	        toServer.close();
		}
		catch(Exception e)
		{
		}
	}

}
