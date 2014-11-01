package jmp.module04.multithreading;

import jmp.module04.multithreading.tasks.TaskManager;

public class App 
{
    public static void main( String[] args )
    {  	
    	TaskManager taskManager = new TaskManager();
    	taskManager.start(20);
     	
    }
    
}
