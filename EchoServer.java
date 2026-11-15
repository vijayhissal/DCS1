import java.net.*;
import java.io.*;

public class EchoServer {

    public static void main(String args[]) {
        System.out.println("Waiting for clients...");

        try {
            ServerSocket ss = new ServerSocket(5000);

            Socket soc = ss.accept();
            System.out.println("Connect establish successfully..");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str = in.readLine();

            PrintWriter echo = new PrintWriter(soc.getOutputStream(), true);
            echo.println("Server Says:" + str);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}














import java.net.*;
import java.io.*;

public class EchoServer {

	public static void main(String args[]) {
		System.out.println("Waiting for clients...");
		
		try {
			ServerSocket ss = new ServerSocket(5000);
			
			while (true) { // 1. Keep accepting multiple clients
				Socket soc = ss.accept();
				System.out.println("Connect establish successfully..");
				
				new Thread(() -> { // 2. Handle each client in a separate thread
					try {
						BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
						String str = in.readLine();
						
						PrintWriter echo = new PrintWriter(soc.getOutputStream(), true);
						echo.println("Server Says:" + str);
					} catch (Exception e) {
						System.out.println(e);
					}
				}).start(); // 3. Start thread
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
