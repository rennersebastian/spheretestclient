package main.sphere_test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutionException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static JavaClientExample client;

    @BeforeClass
    public static void init() throws Exception {
    	client = new JavaClientExample();
    	client.initialize();
    }
    
    @AfterClass
    public static void close() throws Exception {
    	client.endSession();
    }
    
    @Test
    public void getProductCount() throws InterruptedException,
            ExecutionException {

        int count = client.getProductCount();
        assertTrue(count > 0);
    }    
    
    @Test
    public void getProductnames() throws InterruptedException, ExecutionException{
    	client.listProductNames();
    }
}
