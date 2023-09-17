public class Jugador {
    char currentPlayer ;

    char winner;
    public Jugador() {
        this.currentPlayer= 'X';
    }

    public static boolean isValidMove(char[][] board, int col) {
        if (col < 0 || col >= board[0].length) {
            return false;
        }
        return board[0][col] == ' ';
    }

    public static void makeMove(char[][] board, int col, char player) {
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][col] == ' ') {
                board[i][col] = player;
                break;
            }
        }
    }
}
