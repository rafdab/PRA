package Proj1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;

import static Proj1.SQLChecker.*;

public class Runner {

    public static void main (String[] args) throws SchedulerException {
        ArrayList<String> queryList = new ArrayList<>();

        //reminder quartz
        Scheduler reminderSch = StdSchedulerFactory.getDefaultScheduler();
        reminderSch.start();

        JobDetail reminderJob =  JobBuilder.newJob(Reminder.class)
                .withIdentity("reminderJob")
                .build();

        Trigger reminderTrigger = TriggerBuilder.newTrigger()
                .startNow()
                .withIdentity("reminderTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * 8-19 ? * MON,TUE,WED,THU,FRI *")).build();

        reminderSch.scheduleJob(reminderJob, reminderTrigger);

        //autosave quartz
        Scheduler autosaveSch = StdSchedulerFactory.getDefaultScheduler();
        autosaveSch.start();

        JobDetail autosaveJob =  JobBuilder.newJob(Reminder.class)
                .withIdentity("autosaveJob")
                .usingJobData("queryList", String.valueOf(queryList))
                .build();

        Trigger autosaveTrigger = TriggerBuilder.newTrigger()
                .startNow()
                .withIdentity("autosaveTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * ? * * *")).build();

        autosaveSch.scheduleJob(autosaveJob, autosaveTrigger);

        System.out.println("Wpisz '0' lub 'stop' aby zakończyć\n");
        while(start(queryList));

        reminderSch.shutdown();
        autosaveSch.shutdown();

    }
}
