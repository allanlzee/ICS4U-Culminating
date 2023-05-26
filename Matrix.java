public class Matrix {
    public static void main(String[] args) {

    }

    public static int checkWinner(int[][] board) { 
	int gameStatus = Globals.GAME_STILL_ON; 

	int[] winStatus = {checkRow(board), checkCol(board), checkDiagonal(board)}; 

	for (int status = 0; status < winStatus.length; status++) {
	    if (winStatus[status] > 0) {
		gameStatus = winStatus[status]; 
	    }
	}

	if (gameStatus == Globals.GAME_STILL_ON) {
	    if (!checkSpace(board)) {
		gameStatus = Globals.GAME_TIE; 
	    }
	}

	return gameStatus; 
    }

    public static boolean checkSpace(int[][] board) {
	boolean spacesLeft = false; 
	
	for (int row = 0; row < Globals.GRID_SIZE && !spacesLeft; row++) {
	    for (int col = 0; col < Globals.GRID_SIZE && !spacesLeft; col++) {
		if (board[row][col] == 0) {
		    spacesLeft = true; 
		}
	    }
	}

	return spacesLeft; 
    }

    public static int checkRow(int[][] board) {
	int rowWin = -1; 

	for (int row = 0; row < Globals.GRID_SIZE && rowWin == -1; row++) {
	    int currPlayer = board[row][0]; 
	    boolean win = false; 

	    if (currPlayer != 0) {
		if (currPlayer == board[row][1] && currPlayer == board[row][2]) {
		    win = true; 
		}
	    }
	    
	    if (win) {
		rowWin = currPlayer; 
	    }
	}

	return rowWin; 
    }

    public static int checkCol(int[][] board) {
	int colWin = -1; 

	for (int col = 0; col < Globals.GRID_SIZE && colWin == -1; col++) {
	    int currPlayer = board[0][col]; 
	    boolean win = false; 

	    if (currPlayer != 0) {
		if (currPlayer == board[1][col] && currPlayer == board[2][col]) {
		    win = true; 
		}
	    }

	    if (win) {
		colWin = currPlayer; 
	    }
	}

	return colWin; 
    }

    public static int checkDiagonal(int[][] board) {
	int diagonalWin = -1; 

	if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) 
	    diagonalWin = board[0][0]; 
	else if (board[0][2] == board[1][1] && board[0][2] == board[2][0])
	    diagonalWin = board[0][2]; 

	return diagonalWin; 
    }
}
