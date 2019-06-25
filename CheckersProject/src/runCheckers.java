import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class runCheckers extends JFrame {
    public runCheckers(){
        initUI();
    }
    private void initUI() {
        CheckersBoard board = new CheckersBoard();
        add(board);
        setTitle("Checkers");
        this.getContentPane().setPreferredSize(new Dimension(400, 400));
        this.pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            runCheckers game = new runCheckers();
            game.setVisible(true);
        });
    }
}
