package games.tennis.jobs.tasks.TaskImpl;

import systems.jobs.tasks.Task;
import systems.jobs.threads.ThreadPool;

public class TestTask implements Task {

	@Override
	public void execute() {

		System.out.println(System.currentTimeMillis());
		ThreadPool.addTask(new TestTask());
	}

}
