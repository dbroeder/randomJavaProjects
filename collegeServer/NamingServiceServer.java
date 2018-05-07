package collegeServer;

import java.net.*;
import java.io.*;


public class NamingServiceServer {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
			try
			{
				ServerSocket server=new ServerSocket(6052);
				NamingServiceServer thread=new NamingServiceServer();
				while(true)
				{
					Socket client=server.accept();
					thread.new ClientThread(client);
					
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		
		
		
		
	}
	public class ClientThread extends Thread{
		Socket client;
		BufferedReader input;
		PrintWriter output;
		public ClientThread(Socket c){
			try{
				client=c;
				input=new BufferedReader(new InputStreamReader(client.getInputStream()));
				output=new PrintWriter(client.getOutputStream(),true);
				start();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		public void run(){
			try{
				String s;
				
				while(true)
				{
					s=input.readLine();
					if(s.contains(".com")||s.contains(".net")||s.contains(".edu")||s.contains(".org"))
					{
						try
						{
							InetAddress hostAddress=InetAddress.getByName(s);
							String IPaddress=hostAddress.getHostAddress();
							output.println(IPaddress);
							break;
							
						}catch(UnknownHostException uhe)
						{
							output.println("You entered an incorrect internet address. Please try again.");
						}
					}
					else
						output.println("Please enter a valid internet address.");
				}
				input.close();
				output.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

}
