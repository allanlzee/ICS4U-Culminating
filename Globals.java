import java.awt.GridBagConstraints;

import javax.swing.JLabel;

public class Globals
{
    // Network Constants
    public static final int CLIENT_ID_LENGTH = 15; 
    public static final int MAX_IPADDRESS_LENGTH = 15; 
    public static final int NET_SEND_ERROR = -1;
    public static final int NET_RECEIVE_ERROR = -1;
    public static final int NET_OK = 0;
    public static final int SENDING_ATTEMPTS_LIMIT = 5;
    public static final int PORT_NUMBER = 5000; // port number > 1024
    public static final int TIME_OUT = 3000; // milliseconds
    public static final int QUEUE_SIZE = 100;

    public static String clientIPAddress = "";
    public static String serverIPAddress; 
    

    // Mario's IP Address: 10.207.98.44

    // Player Constants
    public static final int GAME_TIE = 0;
    public static final int NO_PLAYER = 0;
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final int GAME_STILL_ON = -1;
    public static final int GRID_SIZE = 3;
    public static final int OK_CANCEL = 1;

    // Graphics Constants
    public static final int FRAME_X = 250;
    public static final int FRAME_Y = 100;

    public static final int ROW_HEIGHT = 175;
    public static final int COL_WIDTH = 175;
    public static final int ROWS = 3;
    public static final int COLS = 3;

    public static GridPanel[][] grid = new GridPanel[3][3];
    public static GridBagConstraints gridBagConstraints = new GridBagConstraints(); 
    public static JLabel status = new JLabel("Allan Zhou"); 

    public static final int OFFSET = 15; 
    
    public static final String SERVER1_NAME = "Bob's Bar";
    public static final String SERVER2_NAME = "Daniel's Dungeon"; 
    public static final String SERVER3_NAME = "Prasun and Sons"; 
    public static final String SERVER4_NAME = "Tilted Towers"; 
    /* public static final String SERVER5_NAME = "Gabe's Garage"; 
    public static final String SERVER6_NAME = "Steven's Spa and Lotion"; */ 
    
    public static final String SERVER1_ADDRESS = "10.207.98.44";
    public static final String SERVER2_ADDRESS = "10.100.2.102"; 
    public static final String SERVER3_ADDRESS = "10.100.2.103"; 
    public static final String SERVER4_ADDRESS = "10.100.2.104"; 
    /* public static final String SERVER5_ADDRESS = "10.100.2.105"; 
    public static final String SERVER6_ADDRESS = "10.100.2.106"; */ 

    // Constants for game commands (first character of transmitted message)
    public static final char REQUEST_UNKNOWN = 255; 
    public static final char REQUEST_TO_PLAY_GAME = 245; 
    public static final char REQUEST_TO_PROCESS_PLAY = 244; 
    public static final char COMMAND_GAME_TERMINATE = 243; 

    // command + row    + column + identification
    // 1 char  + 1 char + 1 char + 15 characters

    public static final String NO_MESSAGE = "No message";

    public static final char COMMAND_TO_WAIT = 242; 
    public static final char COMMAND_TO_START_GAME = 241; 
    public static final char COMMAND_YOUR_TURN = 240; 
    public static final char COMMAND_GAME_OVER = 239; 
    public static final char COMMAND_DISPLAY_MESSAGE = 238; 
    public static final char REQUEST_TO_DISCONNECT = COMMAND_GAME_TERMINATE; 

    public static boolean gameOver = false; 
    public static int iAmPlayer = NO_PLAYER;  
    public static int currentPlayer = NO_PLAYER; 
}
