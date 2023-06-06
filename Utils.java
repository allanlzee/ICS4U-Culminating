import javax.swing.JOptionPane;

public class Utils
{
    public static String initialNetworkConnection ()
    {
	String[] serversNames = {Globals.SERVER1_NAME,
	    Globals.SERVER2_NAME,
	    Globals.SERVER3_NAME,
	    Globals.SERVER4_NAME};

	String[] serversAddresses = {Globals.SERVER1_ADDRESS,
	    Globals.SERVER2_ADDRESS,
	    Globals.SERVER3_ADDRESS,
	    Globals.SERVER4_ADDRESS};

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

		int errorCode = NetIO.sendRequest(Globals.REQUEST_TO_PLAY_GAME + 
			"00" + 
			leftPad(NetIO.myUserName(), Globals.CLIENT_ID_LENGTH, '0'), 
			Globals.serverIPAddress);

		if (errorCode != Globals.NET_OK) {
			JOptionPane.showMessageDialog(null, 
				"Timed out. Server not found.", 
				"Tic Tac Toe Connection", 
				JOptionPane.ERROR_MESSAGE);

			Globals.serverIPAddress = null; 
		}
	}

	return Globals.serverIPAddress;
    }

	private static String leftPad(String text, int desiredLen, char paddingItem) {
		String result = ""; 
		for (int i = 0; i < desiredLen - text.length(); i++) {
			result = paddingItem + result;
		}

		return result + text; 
	}

    public static void main (String[] args)
    {
	System.out.println (initialNetworkConnection ());
    }
}
