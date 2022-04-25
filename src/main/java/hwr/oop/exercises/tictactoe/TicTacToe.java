package hwr.oop.exercises.tictactoe;

import java.util.Arrays;

class TicTacToe {
    int[][] field;
    int player = 0;

    TicTacToe() {
        int[][] squares = new int[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                squares[x][y] = 0;
            }
        }
        field = squares;
    }

    int getValueAt(int x, int y) {
        // TODO implement!
        int fieldValue = this.field[x][y];
        return fieldValue;

    }

    void dontTickBoxTwice(int x, int y) throws RuntimeException {
        if (field[x][y] == 1) {
            throw new RuntimeException("Can't tick box twice.");
        } else if (field[x][y] == 2) {
            throw new RuntimeException("Can't tick box twice.");
        }
    }


    void setCross(int x, int y) {
        isGameFinished();
        dontTickBoxTwice(x, y);
        if (player == 1) {
            throw new RuntimeException("Player 2's turn.");
        }
        player = 1;

        // tick box
        field[x][y] = 1;
    }

    void setCircle(int x, int y) {
        isGameFinished();
        dontTickBoxTwice(x, y);
        if (player == 2) {
            throw new RuntimeException("Player 1's turn.");
        }
        player = 2;
        // circle box
        field[x][y] = 2;

    }

    boolean whoWins(int[] threeSquares) {
        boolean gameIsOver = false;
        int[] playerAWins = new int[] {1, 1, 1};
        int[] playerBWins = new int[] {2, 2, 2};
        if (Arrays.equals(threeSquares, playerAWins)) {
            gameIsOver = true;
            System.out.println("Player A wins.");
        } else if (Arrays.equals(threeSquares, playerBWins)) {
            gameIsOver = true;
            System.out.println("Player B wins.");
        }
        return gameIsOver;
    }

    void isGameFinished() throws RuntimeException {
        boolean gameIsOver = isGameOver();
        if (gameIsOver) {
            throw new RuntimeException("The game is over. There are no moves left.");
        }
    }

    boolean isGameOver() {
        // TODO implement!
        boolean gameIsOver = false;
        int[] compareThreeSquares = new int[3];

        // horizontally
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                compareThreeSquares[x] = getValueAt(x, y);
            }
            gameIsOver = whoWins(compareThreeSquares);
            if (gameIsOver) {
                return true;
            }
        }

        // vertically
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                compareThreeSquares[y] = getValueAt(x, y);
            }
            gameIsOver = whoWins(compareThreeSquares);
            if (gameIsOver) {
                return true;
            }
        }

        // diagonally top down
        for (int i = 0; i < 3; i++) {
            compareThreeSquares[i] = getValueAt(i, i);
        }
        gameIsOver = whoWins(compareThreeSquares);
        if (gameIsOver) {
            return true;
        }

        // diagonally bottom up
        compareThreeSquares[0] = getValueAt(0, 2);
        compareThreeSquares[1] = getValueAt(1, 1);
        compareThreeSquares[2] = getValueAt(2, 0);
        gameIsOver = whoWins(compareThreeSquares);
        if (gameIsOver) {
            return true;
        }

        // maybe game is not over
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (getValueAt(x, y) == 0) {
                    return false;
                }
            }
        }

        // game is over, nobody wins
        System.out.println("Game is over. Nobody won.");
        return true;


    }

}
