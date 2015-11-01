package systems.jobs;

import systems.jobs.threads.ThreadPool;

public class Launcher {

    private static String KEY_CORE_COUNT = "NUMBER_OF_PROCESSORS";

    private static int coreCount;
    private static int maxTaskCount;

    static {

        coreCount = Integer.parseInt(System.getenv().get(KEY_CORE_COUNT).toString());
        maxTaskCount = 999;
    }

    public static void main(String[] args) {
        
        ThreadPool threadPool = new ThreadPool(coreCount-1, maxTaskCount);
        
        
    }

}
