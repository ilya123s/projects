package games.tennis;

import games.tennis.flow.GameController;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunGame extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected static int xDimension = 0;

    protected static int yDimension = 0;

    public static void main(String[] args) throws InterruptedException {

        //Dimensions
        xDimension = 400;
        yDimension = 500;

        JFrame jframe = new JFrame("Table Tennis");
        jframe.setSize(xDimension, yDimension);

        //make the game controller.
        GameController game = new GameController();

        //add the paddle as a listener.
        jframe.addKeyListener(game.getPaddle());
        jframe.setFocusable(true);

        jframe.add(game);
        jframe.setVisible(true);
        jframe.setBackground(Color.WHITE);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //runs the game flow
        game.runGameFlow();

    }

}
