import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class CheckersBoard extends JPanel {
    private final int boardWidth = 400;
    private final int squareLen = boardWidth/8;
    private Timer timer;

    private class Square {
        private int x;
        private int y;
        private Color c;
    }
    private Square board[][] = new Square[8][8];

    public CheckersBoard(){
        initBoard();
    }

    private void initBoard(){
        boolean isRed = true;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                board[i][j] = new Square();
                Square s = board[i][j];
                if (isRed){
                    s.c = Color.RED;
                }
                else{
                    s.c = Color.BLACK;
                }
                s.x = j * squareLen;
                s.y = i * squareLen;
                isRed = !isRed;
            }
            isRed = !isRed;
        }
    }

    private void drawSquare(Graphics g, Square s){
        g.drawRect(s.x, s.y, squareLen, squareLen);
        g.setColor(s.c);
        g.fillRect(s.x, s.y, squareLen, squareLen);
    }

    private void doDrawing(Graphics g){
        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                Square s = board[row][col];
                drawSquare(g,s);
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }
}
