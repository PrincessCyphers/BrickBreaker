import java.awt.*;

public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public MapGenerator (int row, int col) {
        map = new int[row][col];
        for(int i=0; i < map.length; i++) {
            for(int j=0; j< map[0].length; j++) {
                map[i][j] = 1;              // this makes brick visible and prevents intersection with ball. changing brink pos to 0 is how to get rid
            }
        }
        brickWidth = 600/col;
        brickHeight = 200/row;
    }
    public void draw(Graphics2D g) {
        for(int i=0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    g.setColor(Color.white);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }
}
