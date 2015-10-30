package systems.jobs;


public class Launcher {

    private static String KEY_CORE_COUNT = "NUMBER_OF_PROCESSORS";

    private static int coreCount;

    static {

        coreCount = Integer.parseInt(System.getenv().get(KEY_CORE_COUNT).toString());
    }

    public static void main(String[] args) {
        
        

    }

}
