import hsa.*; 

public class Send {
    public static void main(String[] args) {
	System.out.println(NetIO.myIPAddress());
	
	do {
	    System.out.println("Message: ");
	    String message = Stdin.readLine(); 
	    System.out.print("Destination IP-Address: "); 
	    String ipAddress = Stdin.readLine(); 
	    
	    NetIO.sendRequest(message, ipAddress); 
	} while (true); 
    }
}
