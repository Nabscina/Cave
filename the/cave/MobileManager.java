package the.cave;

import java.util.ArrayList;
import java.util.Random;

public class MobileManager {

    private Player player;
    private Random random;
    private ArrayList<Monster> monsters;

    public MobileManager(Player player, Random random, ArrayList<Monster> monsters) {

        this.player = player;
        this.random = random;
        this.monsters = monsters;
    }

    public void playerMoves(String command) {

        move(this.player, command);
    }

    public void monstersMove(String commands, ArrayList<Monster> monsterlist) {

        String keys = "wasd";
        ArrayList<Monster> copy = new ArrayList<>(monsterlist);

        for (Monster m : copy) {
            String movements = "";
            for (int i = 0; i < commands.length(); i++) {
                movements += keys.charAt(random.nextInt(4));
            }
            move(m, movements);
        }
    }

    public void move(Mobile mobile, String command) {

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'a') {
                mobile.setY(mobile.getY() - 1);
            } else if (command.charAt(i) == 'w') {
                mobile.setX(mobile.getX() - 1);
            } else if (command.charAt(i) == 'd') {
                mobile.setY(mobile.getY() + 1);
            } else if (command.charAt(i) == 's') {
                mobile.setX(mobile.getX() + 1);
            }
            removeAMonster(this.player.getX(), this.player.getY());
        }
    }

    public void removeAMonster(int x, int y) {

        Monster removable = null;

        for (Monster m : monsters) {
            if (m.getX() == x && m.getY() == y) {
                removable = m;
            }
        }

        if (removable != null) {
            monsters.remove(removable);
        }
    }
}
