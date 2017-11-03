package Proj1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;
import java.util.Scanner;

import static Proj1.SQLChecker.start;

public class Runner {

    public static void main (String[] args) throws SchedulerException {
        ArrayList<String> queryList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean bool = true;

        //reminder quartz
        Scheduler reminderSch = StdSchedulerFactory.getDefaultScheduler();
        reminderSch.start();

        JobDetail reminderJob =  JobBuilder.newJob(Reminder.class)
                .withIdentity("reminderJob")
                .build();

        Trigger reminderTrigger = TriggerBuilder.newTrigger()
                .withIdentity("reminderTrigger")
                .startNow()
                .withSchedule(CronScheduleBuilder
                        .cronSchedule("0 * 8-19 ? * MON,TUE,WED,THU,FRI *"))
                .build();

        reminderSch.scheduleJob(reminderJob, reminderTrigger);

        //autosave quartz
        Scheduler autosaveSch = StdSchedulerFactory.getDefaultScheduler();
        autosaveSch.start();
        JobDetail autosaveJob =  JobBuilder.newJob(Autosave.class)
                .withIdentity("autosaveJob")
                .usingJobData("queryList", String.valueOf(queryList))
                .build();
        Trigger autosaveTrigger = TriggerBuilder.newTrigger()
                .withIdentity("autosaveTrigger")
                .startNow()
                .withSchedule(CronScheduleBuilder
                        .cronSchedule("0/30 * * ? * * *"))
                .build();
        autosaveSch.scheduleJob(autosaveJob, autosaveTrigger);

        System.out.println("Wpisz 'stop' jako odpowiedź aby zakończyć\n");
        while(bool) {
            System.out.print("Podaj numer zadania: ");
            int nrZad = scan.nextInt();
            System.out.println("Podaj rozwiązanie:");
            String sql;
            scan.nextLine();
            sql = scan.nextLine();
            bool = start(nrZad, sql, queryList);
        }

        reminderSch.shutdown();
        autosaveSch.shutdown();


    }
}
