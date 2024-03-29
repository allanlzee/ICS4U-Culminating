import java.net.*; 
import java.io.*; 

public class NetIO {
    // IP Address of Computer 
    public static String myIPAddress() {
	String address = ""; 
	
	try {
	    InetAddress myNode = InetAddress.getLocalHost(); 
	    address = myNode.getHostAddress(); 
	} 
	catch(Exception e) {
	    e.printStackTrace();  
	}
	
	return address; 
    }
    
    // Retrieve user name (student number) 
    public static String myUserName() {
	String userName = ""; 
	
	try {
	    userName = System.getProperty("user.name"); 
	} catch (Exception e) {
	    System.out.println("Error getting name of user");         
	}
	
	return userName; 
    }
    
    public static int sendRequest(String message, String destinationIPAddress) {
	int errorCode = Globals.NET_SEND_ERROR; 
	int attempts = 0; 
	
	do {
	    try {
		// Connecting to computer through port number 
		Socket myComputer = new Socket(); 
		myComputer.connect(new InetSocketAddress(destinationIPAddress, 
							Globals.PORT_NUMBER), 
				Globals.TIME_OUT); 
					
		// Create channel to send message through 
		myComputer.setSoTimeout(Globals.TIME_OUT); // timeout for transmission
			
		DataOutputStream output = new DataOutputStream(myComputer.getOutputStream());  
		output.writeUTF(message); 
			
		DataInputStream input = new DataInputStream(myComputer.getInputStream()); 
		String confirmation = input.readUTF(); 
			
		errorCode = Integer.parseInt(confirmation); 
		myComputer.close(); 
	    } 
	    catch (IOException e) {
			System.out.println("***Failure in sendRequest, attempt: + " + attempts); 
	    } 
	    
	    attempts++; 
	} while (errorCode != Globals.NET_OK && 
		 attempts < Globals.SENDING_ATTEMPTS_LIMIT);
	
	return errorCode; 
    }
    
    public static String receiveRequest() {
	String request = ""; 
	int errorCode = Globals.NET_RECEIVE_ERROR; 
	
	try {
	    // Create server socket 
	    ServerSocket server = new ServerSocket(Globals.PORT_NUMBER, Globals.QUEUE_SIZE);
	    
	    // Create regular socket with timeout 
	    Socket myComputer = server.accept(); 
	    myComputer.setSoTimeout(Globals.TIME_OUT); 
	    
	    // Receive messages through channel 
	    DataInputStream input = new DataInputStream(myComputer.getInputStream());
	    request = input.readUTF();
	    
	    // Client IP Address 
	    Globals.clientIPAddress = myComputer.getInetAddress().getHostAddress();
	    
	    DataOutputStream output = new DataOutputStream(myComputer.getOutputStream()); 
	    output.writeUTF("" + Globals.NET_OK);
	    
	    myComputer.close(); 
	    server.close(); 
	    errorCode = Globals.NET_OK;    
	} 
	catch (IOException e) {
	    System.out.println("***Error receiving in receiveRequest"); 
	}
	
	return request; 
    }
    
    public static void main(String[] args) { 
	System.out.println("My IP Address is " + myIPAddress()); 
	System.out.println("My name is " + myUserName()); 
    }
}
