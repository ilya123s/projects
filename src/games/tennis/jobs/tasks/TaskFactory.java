package games.tennis.jobs.tasks;

import games.tennis.components.TennisComponent;
import games.tennis.jobs.tasks.TaskImpl.Render;
import games.tennis.jobs.tasks.TaskImpl.UpdateComponentsPosition;
import games.tennis.jobs.threads.ThreadPool;

import java.awt.Graphics;
import java.util.LinkedList;

public class TaskFactory {

    private static TaskFactory taskFactory;

    private volatile LinkedList<TennisComponent> componentList;

    private Graphics graphics;

    public static TaskFactory getInstance() {
        if (null == taskFactory) {
            taskFactory = new TaskFactory();
        }

        return taskFactory;
    }

    public static void intialiseFactory(LinkedList<TennisComponent> componentList, Graphics graphics) {
        getInstance();
        taskFactory.componentList = componentList;
        taskFactory.graphics = graphics;
    }

    private TaskFactory() {

    }

    public static void createRenderTask() {
        Task renderTask = new Render(taskFactory.componentList, taskFactory.graphics);
        ThreadPool.addTask(renderTask);
    }
    
    public static void createUpdateBallPositionTask(){
        Task updateBallPosition = new UpdateComponentsPosition(taskFactory.componentList);
        
    }

}
