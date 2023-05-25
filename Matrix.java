public class Matrix {
    public static void main(String[] args) {
        int[][] board = {
                         {1, 2, 1}, 
                         {0, 2, 1}, 
                         {1, 2, 2}
                        };

        System.out.println(checkWinner(board));
    }

    
    public static int checkWinner(int[][] board) { 
        int gameStatus = Globals.GAME_STILL_ON; 

        int[] winStatus = {checkRow(board), checkCol(board), checkDiagonal(board)}; 

        for (int status : winStatus) {
            if (status > 0) {
                gameStatus = status; 
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
            boolean win = true; 

            for (int col = 1; col < Globals.GRID_SIZE && win; col++) {
                if (board[row][col] != currPlayer) {
                    win = false; 
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
            boolean win = true; 

            for (int row = 1; row < Globals.GRID_SIZE && win; row++) {
                if (board[row][col] != currPlayer) {
                    win = false; 
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
