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
    private int ballYdir = 2;

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        // bg
        g.setColor(Color.BLACK);
        g.fillRect(1,1, 890, 690);

        // border
        g.setColor(Color.white);
        g.fillRect(0, 0, 3, 690);
        g.fillRect(0, 0, 890, 3);
        g.fillRect(895, 0, 3, 690 );

        //paddle
        g.setColor(Color.lightGray);
        g.fillRect(playerX, 550, 150, 10);


        //ball
        g.setColor(Color.MAGENTA);
        g.fillOval(ballPosX, ballPosY, 20, 20);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {

    }


}
