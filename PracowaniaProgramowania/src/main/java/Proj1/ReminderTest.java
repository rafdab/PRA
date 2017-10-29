package Proj1;

import static org.junit.Assert.assertTrue;

public class ReminderTest {
    @org.junit.Test
    public  void firstTest(){
        Reminder reminder = new Reminder();
        int a = reminder.getMinutes(14*60+1);
        assertTrue(a == -74);
    }
    @org.junit.Test
    public  void secondTest(){
        Reminder reminder = new Reminder();
        int a = reminder.getMinutes(15*60+20);
        assertTrue(a == 10);
    }
}
