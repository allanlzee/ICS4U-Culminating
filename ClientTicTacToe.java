import javax.swing.*; 
import java.awt.*; 

public class ClientTicTacToe extends JFrame {
    public static void main(String[] args) {
	JFrame mainWindow = new JFrame(); 
	
	mainWindow.setTitle("Allan Zhou");
	mainWindow.setLocation(Globals.FRAME_X, Globals.FRAME_Y);
	mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
	mainWindow.setResizable(false); 
	
	JPanel tttPanel = new JPanel(); 
	Color c = new Color(176, 224, 230); 
	GridPanel grid = new GridPanel(c, 0, 0, Globals.NO_PLAYER);
	
	tttPanel.add(grid); 
	mainWindow.getContentPane().add(tttPanel); 
	mainWindow.pack();
	mainWindow.setVisible(true);  
    } 

}
