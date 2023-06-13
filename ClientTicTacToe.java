import javax.swing.*; 
import java.awt.*; 

public class ClientTicTacToe extends JFrame {
    public static void main(String[] args) {
	Globals.serverIPAddress = Utils.initialNetworkConnection();

	if (Globals.serverIPAddress != null) {
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

		Globals.gridBagConstraints.gridheight = Globals.ROWS; 
		mainWindow.getContentPane().add(tttPanel, Globals.gridBagConstraints); 
	
		Globals.gridBagConstraints.gridx = 0; 
		Globals.gridBagConstraints.gridy = Globals.ROWS; 
		Globals.gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		
		mainWindow.getContentPane().add(Globals.status, Globals.gridBagConstraints);
		
		mainWindow.pack();
		mainWindow.setVisible(true);  

		do {
			System.out.println("Waiting...");
			String request = NetIO.receiveRequest(); 

			NodeInfo commandFromServer = new NodeInfo(request); 
			System.out.println(commandFromServer);

			switch (commandFromServer.getCommand()) {
				case Globals.COMMAND_TO_WAIT: 
					Utils.updateStatusLine(commandFromServer.getMessage()); 
					break; 

				case Globals.COMMAND_TO_START_GAME: 
					Globals.iAmPlayer = (int) commandFromServer.getRowColPlayer().charAt(0); 
					Globals.currentPlayer = Globals.PLAYER_ONE; 
					Utils.updateStatusLine(commandFromServer.getMessage()); 
					break; 

				case Globals.COMMAND_YOUR_TURN: 
					break; 

				case Globals.COMMAND_GAME_OVER:
					break; 

				case Globals.COMMAND_GAME_TERMINATE: 
					break; 

				case Globals.COMMAND_DISPLAY_MESSAGE: 
					break; 

				default: 
					Utils.updateStatusLine("ClientTicTacToe: Unknown Server Command");
					break; 
			}
		} while (!Globals.gameOver); 
	}
	else {
		System.out.println("No server selected");
	}
    } 
}
