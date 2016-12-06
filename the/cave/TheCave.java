package the.cave;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TheCave {

    private int moves;
    private int monsters;
    private int width;
    private int height;
    boolean monstersMove;
    private Board board;
    private Random random;
    private Scanner reader;
    private Player player;
    private ArrayList<Monster> randomMonsterList;
    private MobileManager mm;

    public TheCave(int moves, int monsters, int width, int height, boolean monstersMove) {

        this.moves = moves;
        if (this.moves <= 0) {
            this.moves = 1;
        }

        this.width = width;
        if (this.width < 10) {
            this.width = 10;
        }
        this.height = height;
        if (this.height < 10) {
            this.height = 10;
        }
        this.monsters = monsters;
        if (this.monsters >= (this.width * this.height)) {
            this.monsters = (this.width * this.height) - 1;
        } else if (this.monsters <= 0) {
            this.monsters = 1;
        }

        this.monstersMove = monstersMove;

        this.random = new Random();

        this.board = new Board(this.width, this.height);
        this.player = new Player(0, 0, width, height);
        this.reader = new Scanner(System.in);

        this.randomMonsterList = new ArrayList<>();
        randomize();

        this.mm = new MobileManager(this.player, this.random, this.randomMonsterList);
    }

    public void begin() {

        board.emptyBoard();
        board.placeMonsters(randomMonsterList);
        board.placePlayer(player);
        board.drawBoard();

        while (this.moves > 0) {

            System.out.println(moves);

            String commands = reader.nextLine();
            mm.playerMoves(commands);

            if (monstersMove) {
                mm.monstersMove(commands, randomMonsterList);
            }

            board.emptyBoard();
            board.placeMonsters(randomMonsterList);
            board.placePlayer(player);
            board.drawBoard();

            this.moves--;

            if (randomMonsterList.isEmpty()) {
                break;
            }
        }

        if (randomMonsterList.isEmpty()) {
            System.out.println("YOU WON");
        } else {
            System.out.println("YOU LOST");
        }
    }

    public void randomize() {

        for (int i = 0; i < this.monsters; i++) {
            randomMonsterList.add(new Monster(random.nextInt(this.width - 1) + 1, random.nextInt(this.height - 1) + 1, width, height));
        }
    }
}
