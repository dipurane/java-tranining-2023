package com.encora.db.demo.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledTask {
	
	@Scheduled( fixedDelay = 5000)
	
	public void doSomePeriodicTask() throws InterruptedException {
		
		System.out.println("The code for sending email started #########");
		Thread.sleep(60*1000*10);
		System.out.println("The code for sending email End #########");
	}
}
