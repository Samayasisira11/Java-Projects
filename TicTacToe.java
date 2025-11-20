import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    
    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        playGame();
    }
    
    public static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }
    
    public static void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    public static void playGame() {
        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("It's " + currentPlayer + "'s turn. Enter row (0-2): ");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            System.out.println("Enter column (0-2): ");
            int col = scanner.nextInt();
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid input. Try again.");
            } else if (board[row][col] != '-') {
                System.out.println("That spot is already taken. Try again.");
            } else {
                board[row][col] = currentPlayer;
                printBoard();
                if (checkForWin()) {
                    System.out.println(currentPlayer + " wins!");
                    gameOver = true;
                } else if (checkForTie()) {
                    System.out.println("It's a tie!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
    }
    
    public static boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }
    
    public static boolean checkForTie() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}