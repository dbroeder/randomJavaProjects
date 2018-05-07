package socketPractice;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public class EchoSocketClient {

	public static void main(String[] args) throws IOException {
        //String serverAddress = JOptionPane.showInputDialog(
        //    "Enter IP Address of a machine that is\n" +
        //    "running the date service on port 9090:");
        Socket s = new Socket(InetAddress.getLocalHost(), 9090);
        BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }
	
	/*public static void main(String[] args) {
		try{
		System.err.println(InetAddress.getLocalHost());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Socket client;
		DataOutputStream os;
		DataInputStream is;
		
		try{
			client=new Socket("hostname",4000);
			os=new DataOutputStream(client.getOutputStream());
			is=new DataInputStream(client.getInputStream());
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		

	}
	*/

}
