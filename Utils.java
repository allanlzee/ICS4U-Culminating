import javax.swing.JOptionPane;

public class Utils
{
    public static String initialNetworkConnection ()
    {
	String[] serversNames = {Globals.SERVER1_NAME,
	    Globals.SERVER2_NAME,
	    Globals.SERVER3_NAME,
	    Globals.SERVER4_NAME,
	    Globals.SERVER5_NAME,
	    Globals.SERVER6_NAME};

	String[] serversAddresses = {Globals.SERVER1_ADDRESS,
	    Globals.SERVER2_ADDRESS,
	    Globals.SERVER3_ADDRESS,
	    Globals.SERVER4_ADDRESS,
	    Globals.SERVER5_ADDRESS,
	    Globals.SERVER6_ADDRESS};

	String serverName = (String) JOptionPane.showInputDialog (null,
		"Choose a Server", "The TTT Connection", Globals.OK_CANCEL,
		null, serversNames, Globals.SERVER1_NAME);

	if (serverName == null)
	{
	    Globals.serverIPAddress = null;
	}
	else
	{
	    int i = 0;
	    for (; !serverName.equals(serversNames[i]); i++);
	    Globals.serverIPAddress = serversAddresses[i];
	}

	return Globals.serverIPAddress;
    }

    public static void main (String[] args)
    {
	System.out.println (initialNetworkConnection ());
    }
}
