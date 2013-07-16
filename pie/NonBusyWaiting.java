public class NonBusyWaiting{
    class TheTask extends Thread{
        public void run(){
            synchronized(this){
                // do the task
                this.notify();
            }
        }
    }

    public void waitOnTheTask(){
        Thread task = new TheTask();
        synchronized(task){
            task.start();
            try{
                task.wait();
            }
            catch(InterruptedException e){
                // do something if interrupted
            }
        }
    }
}

