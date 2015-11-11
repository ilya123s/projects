package systems.jobs.threads;

public class FlexibleThread extends Thread {
    
    private Runnable runnableThread;
    
    public FlexibleThread() {
        super();
    }
    
    public FlexibleThread(Runnable runnable){
        super(runnable);
        runnableThread = runnable;
    }
    
    public void setRunnableToExecute(Runnable runnable){
        
        runnableThread = runnable;
    }

}
