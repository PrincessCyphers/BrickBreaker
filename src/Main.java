import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Gameplay gamePlay = new Gameplay();
        frame.setBounds(10, 10, 900, 700);
        frame.setTitle("BRICK BREAKER");
        frame.setLocationRelativeTo(null);                  // so frame is central to page on opening
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(gamePlay);
        frame.setVisible(true);

    }
}
