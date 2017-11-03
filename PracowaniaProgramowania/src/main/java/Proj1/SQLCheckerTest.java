package Proj1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SQLCheckerTest {
    @Test
    public void checkSql1() throws Exception {
        assertTrue(SQLChecker.checkSql("select x from y"));
    }
    @Test
    public void checkSql2() throws Exception {
        assertTrue(!SQLChecker.checkSql("from x select y"));
    }
    @Test
    public void checkSql3() throws Exception {
        assertTrue(!SQLChecker.checkSql(""));
    }

}