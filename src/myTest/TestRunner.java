package myTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ListAdapterTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Total tests run: " + result.getRunCount());
        System.out.println("Total tests failed: " + result.getFailureCount());
        System.out.println("Total time: " + result.getRunTime() + "ms");
    }
}
