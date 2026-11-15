import java.io.*;
import java.net.*;

public class EchoClient {

	public static void main(String args[]) {
		System.out.println("Client started...");
		
		try {
			Socket s=new Socket("localhost",5000);
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter string:");
			String str=input.readLine();
			
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println(str);
			
			BufferedReader read=new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println(read.readLine());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
