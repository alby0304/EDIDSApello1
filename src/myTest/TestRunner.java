package myTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ListAdapterTest.class,
        ListIteratorAdapterTest.class,
})
public class TestRunner {
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ListAdapterTest.class, ListIteratorAdapterTest.class );
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("\nTotal tests run: " + result.getRunCount());
        System.out.println("\nTotal tests failed: " + result.getFailureCount());
        System.out.println("\nTotal time: " + result.getRunTime() + "ms");
    }
}
