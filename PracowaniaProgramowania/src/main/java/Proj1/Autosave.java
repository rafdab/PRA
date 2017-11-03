package Proj1;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Autosave implements org.quartz.Job {
    //  0/30 * * ? * * *

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String queryList = dataMap.getString("queryList");

        try {
            saveToFile(queryList);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void saveToFile(String data) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("odp.txt", "UTF-8");
            writer.println(data);
        writer.close();
    }
}
