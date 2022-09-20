package me.baobo;

import java.time.LocalDateTime;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }
    
    /**
     * normal
     */
    public void testDateTime() {
        String template = "{year}dypa{month}dypa{day}";
        LocalDateTime now = LocalDateTime.now();
        String inputPassword = now.getYear() + "dypa" + now.getMonthValue() + "dypa" + now.getDayOfMonth();
        boolean result = Main.match(template, inputPassword);
        
        assertTrue(result);
    }
    
    /**
     * normal
     */
    public void testDateTimeWithCalculation() {
        String template = "{year(+1)}dypa{month(-2)}dypa{day(*3)}dypa{hour(/5)}dypa{minute(%10)}";
        LocalDateTime now = LocalDateTime.now();
        String inputPassword =
            (now.getYear() + 1) + "dypa" + (now.getMonthValue() - 2) + "dypa" + (now.getDayOfMonth() * 3)
                + "dypa" + (now.getHour() / 5) + "dypa" + (now.getMinute() % 10);
        boolean result = Main.match(template, inputPassword);
        
        assertTrue(result);
    }
}
