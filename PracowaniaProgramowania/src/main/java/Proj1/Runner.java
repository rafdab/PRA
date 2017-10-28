package Proj1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;

import static Proj1.SQLChecker.*;

public class Runner {

    public static void main (String[] args) throws SchedulerException {
        ArrayList<String> queryList = new ArrayList<>();

        Scheduler reminderSch = StdSchedulerFactory.getDefaultScheduler();
        reminderSch.start();
        JobDetail reminderJob =  JobBuilder.newJob(Reminder.class)
                .withIdentity("reminderJob")
                .build();
        Trigger reminderTrigger = TriggerBuilder.newTrigger()
                .withIdentity("reminderTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * 8-19 ? * MON,TUE,WED,THU,FRI *")).build();
        reminderSch.scheduleJob(reminderJob, reminderTrigger);

        System.out.println("Wpisz '0' lub 'stop' aby zakończyć\n");
        while(start(queryList));

        reminderSch.shutdown();
    }
}
