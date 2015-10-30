package games.tennis.flow;

import games.tennis.components.TennisComponent;
import games.tennis.components.impl.Ball;
import games.tennis.components.impl.Paddle;

import java.awt.Color;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameController extends JPanel {

    private static final long serialVersionUID = 1L;

    private Ball ball;

    private Paddle paddle;

    private LinkedList<TennisComponent> componentList;

    public GameController() {
        this.paddle = new Paddle(60, 10, this);
        this.ball = new Ball(30, 1, this);
        this.setBackground(Color.WHITE);
        componentList = new LinkedList();
        componentList.add(paddle);
        componentList.add(ball);
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    /**
     * Main method to be run to execute threads and game flow.
     * 
     * @throws InterruptedException
     */
    public void runGameFlow() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Updater updater = new Updater(componentList);
        Render render = new Render(componentList, getGraphics());
        //setBallTimer(5);
        executor.execute(updater);
        executor.execute(render);

    }

    //    private void setBallTimer(long speed) throws InterruptedException {
    //        ball.setUpdate(true);
    //        Thread.sleep(speed);
    //    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

}
