package collegeServer;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;




public class WebServer {
	
	public static int counter=0;
	public static String logFile="";
	

	public static String dateFormatter()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("EEE','dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z");
		   Date rightNow = new Date();
		   
		   return formatter.format(rightNow);
	}
	
	public static String responseMessage(String header,String iptype,String bitLength)
	{
		return ""+header
				+"Date: "+dateFormatter()+"\n"
				+"Connection: close\n"
				+ "Server: WebServer\n"
				+ ""+iptype+"\n"
				+""+bitLength+" bytes \r\n";
	}
	
	public static String contentType(String file)
	{
		if(file.endsWith(".htm")||file.endsWith(".html"))
			return "text/html";
		if(file.endsWith(".jpg")||file.endsWith(".jpeg"))
			return "image/jpeg";
		if(file.endsWith(".gif"))
			return "image/gif";
		return "application/octet-stream";
			
	}
	
	public static String getCounter()
	{
		Integer temp=new Integer(counter);
		return temp.toString();
	}
	
	public static void resetCounter()
	{
		counter=0;
	}
	
	public static void writeFile(FileInputStream file,DataOutputStream out) throws Exception
	{
		byte[] buffer=new byte[1024];
		int bytes=0;
		while((bytes=file.read(buffer))!=-1)
		{
			try{out.write(buffer,0,bytes);}catch(SocketException se){System.out.println("Caught Exception");}
			
		}
		counter=out.size();
	}
	
	public static void configWriter()
	{
		Configuration configutor = null;
		
		try {
			configutor = new Configuration("./config.xml");
		}
		catch (ConfigurationException ce) {
			System.out.println(ce);
			System.exit(0);
		}

		System.out.println(configutor.getLogFile());
		System.out.println(configutor.getDocBase());
		System.out.println(configutor.getServerName());
	}
	
	public class ClientThread extends Thread{
		Socket client;
		BufferedReader in;
		PrintWriter out;
		public ClientThread(Socket c){
			try{
				client=c;
				 // Get input and output streams to talk to the client from the socket
		        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		        out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
				start();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		public void run(){
			try{
			
			String badRequest="";
			 String requestLine=in.readLine();
		       //System.out.println(requestLine);
		       	       
		       StringTokenizer parseLine=new StringTokenizer(requestLine);
		       parseLine.nextToken();
		       String filename=parseLine.nextToken();
		      
		       System.out.println(filename);
		       if(filename.equals("/"))
		    	   filename="./index.html";
		       else if((filename.endsWith(".txt"))||(filename.endsWith(".jpg"))||(filename.endsWith(".htm"))||(filename.endsWith(".html"))||(filename.endsWith(".jpeg"))||(filename.endsWith(".gif")))
		       {
		    	   filename="."+filename;  
		       }
		    	  
		       else{
		    	   badRequest="HTTP/1.1 400 Bad Request \r\n";
		    	    out.println(badRequest);
		    	    out.flush();
		    	    out.println(responseMessage(badRequest,"Content-type: text/html","N/A"));
		    	    out.flush();
		    	    
		    	    out.close();
			        in.close();
			        client.close();
			        stop();
		       }
		    	   
		      // System.out.println(filename);
		       
		       FileInputStream file=null;
		       boolean fileExists=true;
		       try{
		    	   file=new FileInputStream(filename);
		       }catch(Exception e)
		       {
		    	   fileExists=false;
		       }
		       
		       String header="";
		       String content="";
		       String body="";
		       
		       if(fileExists)
		       {
		    	 header="HTTP/1.1 200 OK\r\n";
		    	 content=contentType(filename);
		       }
		       else
		       {
		    	   header="HTTP/1.1 404 Not Found \r\n";
		    	   content="Content-type: text/html\r\n";
		    	   body="<HTML><HEAD><TITLE>Not Found</TITLE></HEAD><BODY>Not Found</BODY></HTML>\r\n";
		    	   
		       }
		       
		       out.println(header);
		       //out.println(content);
		       //out.println();
		       out.flush();
		       
		       DataOutputStream fileWriter=new DataOutputStream(client.getOutputStream());
		       
		       if(fileExists)
		       {
		    	   writeFile(file,fileWriter);
		    	   out.println();
		    	   out.println(responseMessage(header,content,getCounter()));
		    	   out.flush();
		    	   file.close();
		    	   System.out.println(counter);
		       }
		       else
		       {
		    	   out.println(responseMessage(header,content,"N/A"));
			       out.flush();
		       }
				
				
		        
		        
		       out.close();
		        in.close();
		        client.close();
		        stop();
		        
		        
		        
			}
			catch(NullPointerException npe)
			{
				System.out.println("It's Ok.");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		 }
	}

		
	
	
	/**
	 * @param args
	 */
	public static void main(String args[]) throws IOException {
	      // Get the port to listen on
		int port = 1500;

		if (args.length == 1)
			port = Integer.parseInt(args[0]);

	    try {
	      // Create a ServerSocket 
	      ServerSocket ss = new ServerSocket(port);
	      System.out.println("Server bound at port " + ss.getLocalPort());

	        WebServer thread=new WebServer();
	        while(true)
	        {
	        	Socket client = ss.accept();
	        	thread.new ClientThread(client);
	        }
	      }catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	       
	       	       
	      
	}
}


