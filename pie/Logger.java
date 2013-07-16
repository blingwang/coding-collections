// Implements a simple logging class using a singleton
public class Logger{
    private static Logger instance;

    private Logger(){}

    // inner class initializes instance on load, won't be loaded
    private static class LoggerHolder{
        public static final Logger instance = new Logger();
    }

    // return the singleton instance
    public static Logger getInstance(){
        return LoggerHolder.instance;
    }

    // log a string to the console
    public void log(String msg){
        System.out.println(System.currentTimeMillis() + ": " + msg);
    }
}
