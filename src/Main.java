import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Gameplay gamePlay = Gameplay();
        frame.setTitle("BRICK BREAKER");
        frame.setBounds(10, 10, 900, 700);
        frame.setLocationRelativeTo(null);                  // so frame is central to page on opening
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(gamePlay);

    }
}
