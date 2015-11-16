package games.tennis.jobs.tasks.TaskImpl;

import games.tennis.components.TennisComponent;
import games.tennis.jobs.tasks.Task;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Render extends JPanel implements Task {

    private volatile LinkedList<TennisComponent> componentList;

    private Graphics graphics;

    public Render(LinkedList<TennisComponent> componentList, Graphics graphics) {
        this.componentList = componentList;
        this.graphics = graphics;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    public synchronized void execute() {
            paint(graphics);
            for (TennisComponent component : componentList) {
                component.paint((Graphics2D) graphics);
            }
    }

}
