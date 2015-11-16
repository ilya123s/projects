package games.tennis;

import games.tennis.jobs.threads.ThreadPool;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunGame extends JPanel {

    private static final long serialVersionUID = 1L;

    protected static int xDimension = 0;

    protected static int yDimension = 0;
    
    private static int maxTaskCount = 999;

    private static int coreCount = 999;
    
    private static String KEY_CORE_COUNT = "NUMBER_OF_PROCESSORS";
    
    static {
        
        //Initialise the core count and get the max task count
        coreCount = Integer.parseInt(System.getenv().get(KEY_CORE_COUNT).toString());
        maxTaskCount = 999;
        
        //set dimensions
        xDimension = 400;
        yDimension = 500;
    }

    public static void main(String[] args) throws InterruptedException {


        JFrame jframe = new JFrame("Table Tennis");
        jframe.setSize(xDimension, yDimension);

        //make the game controller.
        GameController game = new GameController(jframe.getGraphics());

        //add the paddle as a listener.
        jframe.addKeyListener(game.getPaddle());
        jframe.setFocusable(true);

        jframe.add(game);
        jframe.setVisible(true);
        jframe.setBackground(Color.WHITE);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // initialise thread pool with the amount of threads per core. 
        ThreadPool.intialiseThreadPool(coreCount, maxTaskCount);
        
        //runs the game flow
        game.runGameFlow();

    }

}
