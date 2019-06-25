import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class CheckersBoard extends JPanel {
    private final int boardWidth = 400;
    private final int squareLen = boardWidth/8;
    private Color beige = new Color(222,184,135);
    private Color brown = new Color(139,69,19);

    //timer to be used later
    private Timer timer;

    //square class
    private class Square {
        //x and y coordinates represent the top left corner
        private int x;
        private int y;
        //color is either beige or brown
        private Color c;
    }

    //creates array of 64 squares
    private Square board[][] = new Square[8][8];

    //constructor for initializing the board
    public CheckersBoard(){
        initBoard();
    }

    private void initBoard(){
        //this boolean represents when the color should be beige
        boolean isBeige = true;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                //initialize a new square for each cell on the board
                board[i][j] = new Square();
                Square s = board[i][j];
                if (isBeige){
                    s.c = beige;
                }
                else{
                    s.c = brown;
                }
                s.x = j * squareLen;
                s.y = i * squareLen;
                isBeige = !isBeige;
            }
            isBeige = !isBeige;
        }
    }

    //draws the square and fills in the appropriate color
    private void drawSquare(Graphics g, Square s){
        g.drawRect(s.x, s.y, squareLen, squareLen);
        g.setColor(s.c);
        g.fillRect(s.x, s.y, squareLen, squareLen);
    }

    //draws the board along with the pieces
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
