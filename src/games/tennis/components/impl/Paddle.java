package games.tennis.components.impl;

import games.tennis.GameController;
import games.tennis.components.TennisComponent;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle implements KeyListener, TennisComponent {

    private int xMovement;

    private int x;

    private int paddleWidth;

    private int paddleHeight;

    private GameController gameController;

    public Paddle(int paddleWidth, int paddleHeight, GameController gameController) {
        this.paddleHeight = paddleHeight;
        this.paddleWidth = paddleWidth;
        this.gameController = gameController;
        x = (gameController.getWidth() / 2) - (paddleWidth / 2);
        System.out.println(x);
        System.out.println(getPaddleHeightPosition());
    }

    public int getPaddleHeightPosition() {
        return gameController.getHeight() - paddleHeight;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xMovement = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xMovement = 1;
        movePaddle();
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        xMovement = 0;
        movePaddle();
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    private void movePaddle() {
        if (x + xMovement > 0 && x + xMovement < gameController.getWidth() - paddleWidth)
            x += xMovement;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, getPaddleHeightPosition(), paddleWidth, paddleHeight);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, getPaddleHeightPosition(), paddleWidth, paddleHeight);
    }

    @Override
    public void update() {
        //This method does nothing, as paddle is updated when key is pressed, not when update is called
    }

}
