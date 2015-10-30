package games.tennis.flow;

import games.tennis.components.TennisComponent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Render extends JPanel implements Runnable {

    private LinkedList<TennisComponent> componentList;

    private Graphics graphics;

    public Render(LinkedList<TennisComponent> componentList, Graphics graphics) {
        this.componentList = componentList;
        this.graphics = graphics;
    }

    @Override
    public void run() {

        while (true) {
            paint(graphics);
            for (TennisComponent component : componentList) {
                component.paint((Graphics2D) graphics);
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

}
