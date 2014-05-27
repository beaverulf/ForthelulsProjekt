import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server {
	private static int uniqueId;
	private int port;
	private boolean keepUp;
    
	public static void main(String[] args) throws Exception{
        Server myServ = new Server();
        myServ.run();
        
    }

    public void run() throws Exception{
    	boolean finished = false;
    	String temp = null;
    	String msgtocli = null;

        ServerSocket mySS = new ServerSocket(1990);
        Socket SS_accept = mySS.accept();

        BufferedReader SS_BF= new BufferedReader(new InputStreamReader
        (SS_accept.getInputStream()) );
        
        while(!finished){
        	System.out.println("Send msg to client:");
        	Scanner srv_inp = new Scanner(System.in);
        	msgtocli = srv_inp.nextLine();
        	
        	if(msgtocli!=null) {
    			PrintStream SSPS = new PrintStream(SS_accept.getOutputStream());
    			SSPS.println(msgtocli);
    		}
        	
        	temp = SS_BF.readLine();
    		System.out.println(temp);
        }
		

		
		
		mySS.close();
    }
}