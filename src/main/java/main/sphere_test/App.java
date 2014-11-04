package main.sphere_test;

import java.util.concurrent.ExecutionException;

public class App 
{

	
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {      
        JavaClientExample client = new JavaClientExample();
    	
        client.initialize();
        
    	client.listProductNames();
    	
    	client.endSession();
    }
}
