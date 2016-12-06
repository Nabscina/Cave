package the.cave;

import java.util.ArrayList;

public class Board {

    private int width;
    private int height;
    private String[][] board;

    public Board(int width, int height) {

        this.width = width;
        this.height = height;
        this.board = new String[width][height];
    }

    public void emptyBoard() {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = ".";
            }
        }
    }

    public void placeMonsters(ArrayList<Monster> monsters) {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                for (Monster m : monsters) {
                    if (m.getX() == i && m.getY() == j) {
                        board[i][j] = "X";
                    }
                }
            }
        }
    }

    public void placePlayer(Player player) {

        board[player.getX()][player.getY()] = "@";
    }

    public void drawBoard() {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    public String[][] getBoard() {

        return this.board;
    }
}
