import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private Boolean play = false;
    private int score = 0;
    private int totalBricks = 30;
    private Timer timer;
    private int delay = 8;
    private int playerX = 450;
    private int ballPosX = 200;
    private int ballPosY = 350;
    private int ballXdir = -1;
    private int ballYdir = 2;



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
