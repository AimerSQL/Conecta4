import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.initializeBoard();
        Jugador jugador = new Jugador();
        boolean gameWon = false;
        int moves = 0;
        Scanner scanner = new Scanner(System.in);

        while (!gameWon && moves < tablero.col * tablero.row) {
            tablero.displayBoard();

            int colChoice;
            do {
                System.out.println("Jugador " + jugador.currentPlayer + ", elige una columna (1-" + tablero.col + "): ");
                colChoice = scanner.nextInt() - 1;
            } while (!Jugador.isValidMove(tablero.board, colChoice));

            Jugador.makeMove(tablero.board, colChoice, jugador.currentPlayer);

            gameWon = Check.checkForWin(tablero.board, jugador.currentPlayer);
            jugador.winner = jugador.currentPlayer;
            jugador.currentPlayer = (jugador.currentPlayer == 'X') ? 'O' : 'X';
            moves++;
        }

        tablero.displayBoard();

        if (gameWon) {
            System.out.println("¡Jugador " + jugador.winner + " gana!");
        } else {
            System.out.println("Empate. No hay ganador.");
        }
    }

}
