import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowEventHandler extends WindowAdapter {
    public WindowEventHandler() {
    }

    @Override 
    public void windowClosing(WindowEvent event) {
        if (!Globals.gameOver) {
            int errorCode = NetIO.sendRequest("" + Globals.REQUEST_TO_DISCONNECT + 
                "00" + 
                Utils.leftPad(NetIO.myUserName(), Globals.CLIENT_ID_LENGTH, '0') +
                Utils.leftPad(NetIO.myIPAddress(), Globals.MAX_IPADDRESS_LENGTH, '0') +
                Globals.NO_MESSAGE, 
                Globals.serverIPAddress);

            System.out.println("Client disconnecting...");
            Utils.delay(3000);  
        }

        System.exit(0); 
    }
}
