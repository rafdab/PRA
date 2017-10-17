import java.util.Timer;
import java.util.TimerTask;

class TimeHandler {
    private static Timer timer;

    static void schedule(){
        timer = new Timer();
        timer.schedule(new ScheduledTask(), 3*1000);
    }

    static class ScheduledTask extends TimerTask{
        public void run(){
            System.out.println("info");
            timer.cancel();
        }
    }
}
