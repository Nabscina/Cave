package the.cave;

public abstract class Mobile {

    private int x;
    private int y;
    private int width;
    private int height;

    public Mobile(int x, int y, int width, int height) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {

        return this.x;
    }

    public int getY() {

        return this.y;
    }

    public void setX(int x) {

        if (x < width && x >= 0) {
            this.x = x;
        }
    }

    public void setY(int y) {

        if (y < height && y >= 0) {
            this.y = y;
        }
    }
}
