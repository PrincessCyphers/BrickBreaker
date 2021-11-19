import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private Boolean play = false;
    private int score = 0;
    private int totalBricks = 30;
    private Timer timer;
    private int delay = 8;          //milliseconds
    private int playerX = 450;
    private int ballPosX = 200;
    private int ballPosY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

    private MapGenerator map;

    public Gameplay() {
        map = new MapGenerator(5, 6);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        // bg
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 890, 690);

        //map
        map.draw((Graphics2D)g);

        // border
        g.setColor(Color.white);
        g.fillRect(0, 0, 3, 690);
        g.fillRect(0, 0, 890, 3);
        g.fillRect(895, 0, 3, 690);

        //paddle
        g.setColor(Color.lightGray);
        g.fillRect(playerX, 575, 150, 10);

        //scoring
        g.setColor(Color.green);
        g.setFont(new Font("serif", Font.BOLD, 28));
        g.drawString("Score: " + score, 680, 50);


        //ball
        g.setColor(Color.MAGENTA);
        g.fillOval(ballPosX, ballPosY, 20, 20);

        if(ballPosY > 575 ) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 35));
            g.drawString("GAME OVER!\nTotal Score:", 400, 350);

            g.setFont(new Font("serif", Font.BOLD, 35));
            g.drawString("Press Enter to Restart ", 400, 400);
        }

        g.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play) {
            //for ball to detect the paddle
            if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 575, 150, 10))) {
                ballYdir = -ballYdir;
            }

           A: for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if(map.map[i][j] > 0) {
                    int brickX = j * map.brickWidth + 80;
                    int brickY = i * map.brickHeight + 50;
                    int brickWidth = map.brickWidth;
                    int brickHeight = map.brickHeight;

                    Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                    Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
                    Rectangle brickRect = rect;

                    if (ballRect.intersects(brickRect)) {
                        map.setBrickValue(0, i, j);
                        totalBricks --;
                        score +=5;

                        if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) {
                            ballXdir =- ballXdir;
                        } else {
                            ballYdir =- ballYdir;
                        }
                        break A;
                    }
                    }
                }
            }
            ballPosX += ballXdir;
            ballPosY += ballYdir;
            if(ballPosX < 0) {
                ballXdir = -ballXdir;
            }
            if(ballPosY < 0) {
                ballYdir = -ballYdir;
            }
            if(ballPosX > 870) {
                ballXdir = -ballXdir;
            }
            }
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 700) {
                playerX = 700;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }
    }
    public void moveRight() {
        play = true;
        playerX +=20;
    }
    public void moveLeft() {
        play = true;
        playerX -=20;
    }
}