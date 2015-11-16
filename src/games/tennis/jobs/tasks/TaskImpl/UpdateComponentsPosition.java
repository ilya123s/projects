package games.tennis.jobs.tasks.TaskImpl;

import games.tennis.components.TennisComponent;
import games.tennis.jobs.tasks.Task;

import java.util.LinkedList;

public class UpdateComponentsPosition implements Task {

    private LinkedList<TennisComponent> componentList;

    public UpdateComponentsPosition(LinkedList<TennisComponent> componentList) {
        this.componentList = componentList;
    }

    @Override
    public synchronized void execute() {
        for (TennisComponent component : componentList) {
            component.update();
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
