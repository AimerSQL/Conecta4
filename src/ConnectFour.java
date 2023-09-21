import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.initializeBoard();
        Jugador jugador = new Jugador();
        Scanner scanner = new Scanner(System.in);

        while (!Check.getGameWon() && tablero.move()) {
            tablero.displayBoard();
            int colChoice = 0;
            boolean validInput = false;
            do {
                try {
                    System.out.println("Jugador " + jugador.currentPlayer + ", elige una columna (1-" + tablero.col + "): ");
                    if (scanner.hasNextInt()) {
                        colChoice = scanner.nextInt() - 1;
                        validInput = Jugador.isValidMove(tablero.board, colChoice);
                    } else {
                        System.out.println("ERROR: Ingresa un número entero válido.");
                        scanner.next(); // Clear the non-integer input
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("ERROR: Ingresa un número entero válido.");
                    scanner.next(); // Clear the invalid input
                }
            } while (!validInput);


            Jugador.makeMove(tablero.board, colChoice, jugador.currentPlayer);
            Check.checkForWin(tablero.board, jugador.currentPlayer);
            jugador.winner = jugador.currentPlayer;
            jugador.switchPlayer();
            tablero.addMove();
        }
        tablero.displayBoard();

        if (Check.getGameWon()) {
            System.out.println("¡Jugador " + jugador.winner + " gana!");
        } else {
            System.out.println("Empate. No hay ganador.");
        }
    }

}
