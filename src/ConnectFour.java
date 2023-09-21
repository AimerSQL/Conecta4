import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.initializeBoard();
        Jugador jugador = new Jugador();
        Scanner scanner = new Scanner(System.in);
        try{
        while (!Check.getGameWon() && tablero.move()) {
            tablero.displayBoard();

            int colChoice = 0;

                do {
                    System.out.println("Jugador " + jugador.currentPlayer + ", elige una columna (1-" + tablero.col + "): ");
                    colChoice = scanner.nextInt() - 1;

                } while (!Jugador.isValidMove(tablero.board, colChoice));


            Jugador.makeMove(tablero.board, colChoice, jugador.currentPlayer);
            Check.checkForWin(tablero.board, jugador.currentPlayer);
            jugador.winner = jugador.currentPlayer;
            jugador.switchPlayer();
            tablero.addMove();
        }}catch (Exception error){
            System.out.println("error :" + error);
        }

        tablero.displayBoard();

        if (Check.getGameWon()) {
            System.out.println("¡Jugador " + jugador.winner + " gana!");
        } else {
            System.out.println("Empate. No hay ganador.");
        }
    }

}
