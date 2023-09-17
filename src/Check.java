public class Check {

    private static boolean horizontalCheck(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col <= board[row].length - 4; col++) {
                if (board[row][col] == player &&
                        board[row][col + 1] == player &&
                        board[row][col + 2] == player &&
                        board[row][col + 3] == player)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean verticalCheck(char[][] board, char player) {
        for (int row = 0; row <= board.length - 4; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == player &&
                        board[row + 1][col] == player &&
                        board[row + 2][col] == player &&
                        board[row + 3][col] == player)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean leftDiagonalCheck(char[][] board, char player) {
        for (int row = 0; row <= board.length - 4; row++) {
            for (int col = 3; col < board[row].length; col++) {
                if (board[row][col] == player &&
                        board[row + 1][col - 1] == player &&
                        board[row + 2][col - 2] == player &&
                        board[row + 3][col - 3] == player)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean rightDiagonalCheck(char[][] board, char player) {
        for (int row = 0; row <= board.length - 4; row++) {
            for (int col = 0; col <= board[row].length - 4; col++) {
                if (board[row][col] == player &&
                        board[row + 1][col + 1] == player &&
                        board[row + 2][col + 2] == player &&
                        board[row + 3][col + 3] == player)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkForWin(char[][] board, char player) {
        return horizontalCheck(board,player) || verticalCheck(board,player) || rightDiagonalCheck(board,player)|| leftDiagonalCheck(board,player);
    }
}
