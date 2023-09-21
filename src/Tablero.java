import java.util.Arrays;

public class Tablero {
    char[][] board ;
    int col = 7;
    int row = 6;
    int moves;

    public Tablero() {
        this.board = new char[row][col];
    }

    public void initializeBoard() {
        for (char[] chars : this.board) {
            Arrays.fill(chars, ' ');
        }
    }

    public void displayBoard() {
        System.out.println("  1   2   3   4   5   6   7");
        for (char[] chars : this.board) {
            for (char aChar : chars) {
                System.out.print("| " + aChar + " ");
            }
            System.out.println("|");
        }
    }

    public boolean move(){
       return  this.moves < col * row;
    }

    public void addMove(){
        this.moves++;
    }
}
