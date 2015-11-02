package systems.jobs;

import systems.jobs.tasks.TaskImpl.TestTask;
import systems.jobs.threads.ThreadPool;

/**
 * This is the main thread of the program, initialises a thread per system core
 * and starts logic.
 * 
 * @author Ilya
 *
 */
public class Launcher {

	private static String KEY_CORE_COUNT = "NUMBER_OF_PROCESSORS";

	private static int coreCount;
	private static int maxTaskCount;

	/**
	 * Initialise the thread pool with the system core count and the max task
	 * count (this is an arbitrary value). Do this before running main as these
	 * are required on set up.
	 */
	static {
		coreCount = Integer.parseInt(System.getenv().get(KEY_CORE_COUNT).toString());
		maxTaskCount = 999;
		ThreadPool.intialiseThreadPool(coreCount - 1, maxTaskCount);
	}

	public static void main(String[] args) {
		
		System.out.println("Starting main thread...");
		ThreadPool.addTask(new TestTask());
	}

}
