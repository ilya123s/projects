package games.tennis;

import games.tennis.components.TennisComponent;
import games.tennis.components.impl.Ball;
import games.tennis.components.impl.Paddle;
import games.tennis.jobs.tasks.TaskFactory;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameController extends JPanel {

    private static final long serialVersionUID = 1L;

    private Ball ball;

    private Paddle paddle;

    private volatile LinkedList<TennisComponent> componentList;
    
    private Graphics graphics;

    public GameController(Graphics graphics) {
        this.paddle = new Paddle(60, 10, this);
        this.ball = new Ball(30, 1, this);
        this.setBackground(Color.WHITE);
        this.graphics = graphics;
        componentList = new LinkedList<TennisComponent>();
        componentList.add(paddle);
        componentList.add(ball);

        TaskFactory.intialiseFactory(componentList, graphics);
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
        while (true) {
            TaskFactory.createRenderTask();
            TaskFactory.createUpdateBallPositionTask();
        }

    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

}
