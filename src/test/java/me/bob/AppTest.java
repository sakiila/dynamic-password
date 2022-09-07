package me.bob;

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
     *
     */
    public void testDateTime() {
        String template = "{year}dypa{month}dypa{day}";
        LocalDateTime now = LocalDateTime.now();
        String inputPassword = now.getYear() + "dypa" + now.getMonthValue() + "dypa" + now.getDayOfMonth();
        boolean result = TemplateService.match(template, inputPassword);
        assertTrue(result);
    }
}
