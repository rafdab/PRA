package Proj1;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.util.Calendar;

public class Reminder implements org.quartz.Job {
    //  0 * 8-19 ? * MON,TUE,WED,THU,FRI *

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //hour * 60(amount minutes in hour) + minutes
        int startTime[] = {8*60+15, 10*60, 11*60+45, 13*60+45, 15*60+30, 17*60+15, 19*60};
        int endTime[] = {9*60+30, 11*60+30, 13*60+15, 5*60+15, 17*60, 18*60+45};

        Calendar now = Calendar.getInstance();
        int currentTime = now.get(Calendar.HOUR_OF_DAY) * 60 + now.get(Calendar.MINUTE);

        for (int i = 0; i < startTime.length - 1; ++i){
            if (currentTime >= startTime[i] && currentTime <= endTime[i]){
                System.out.println("Liczba minut do końca zajęć: " + (endTime[i] - currentTime));
                break;
            }
            if (currentTime < startTime[i+1] && currentTime > endTime[i]){
                System.out.println("Liczba minut do końca przerwy: " + (startTime[i+1] - currentTime));
                break;
            }
        }
    }
}