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
	tttPanel.setLayout(new GridLayout(Globals.ROWS, Globals.COLS));
	Color c = new Color(176, 224, 230); 

	for (int row = 0; row < Globals.ROWS; row++) {
		for (int col = 0; col < Globals.COLS; col++) {
			Globals.grid[row][col] = new GridPanel(c, row, col, Globals.NO_PLAYER);
			tttPanel.add(Globals.grid[row][col]); 
		}
	}
	
	GridBagLayout gridBag = new GridBagLayout(); 
	mainWindow.getContentPane().setLayout(gridBag); 

	Globals.gridBagConstraints.gridx = 0; 
	Globals.gridBagConstraints.gridy = Globals.ROWS; 
	Globals.gridBagConstraints.anchor = GridBagConstraints.LINE_START; 
	mainWindow.getContentPane().add(Globals.status, Globals.gridBagConstraints);

	mainWindow.getContentPane().add(tttPanel); 
	mainWindow.pack();
	mainWindow.setVisible(true);  
    } 

}
