package games.tennis.components.impl;

import games.tennis.GameController;
import games.tennis.components.TennisComponent;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball implements TennisComponent {

    private int x;

    private int y;

    private int xMovement;

    private int yMovement;

    private int ballDiameter;

    private GameController gameController;

    private Paddle paddle;

    public Ball(int ballDiameter, int movementSpeed, GameController gameController) {
        // initialise ball position in top right
        x = 0;
        y = 0;
        xMovement = movementSpeed;
        yMovement = movementSpeed;
        this.gameController = gameController;
        this.ballDiameter = ballDiameter;
        this.paddle = gameController.getPaddle();
    }

    private void moveBall() {

        if ((x + xMovement < 0) | (x + xMovement > gameController.getWidth() - ballDiameter))
            xMovement = -xMovement;

        if (y + yMovement > gameController.getHeight() - ballDiameter)
            gameController.gameOver();

        if ((y + yMovement < 0))
            yMovement = -yMovement;

        if (collision()) {
            yMovement = -yMovement;
            y = paddle.getPaddleHeightPosition() - ballDiameter;
        }

        x += xMovement;
        y += yMovement;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, ballDiameter, ballDiameter);

    }

    private boolean collision() {
        return paddle.getBounds().intersects(getBounds());
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval(this.x, this.y, ballDiameter, ballDiameter);
    }

    @Override
    public void update() {
        moveBall();
    }


}
