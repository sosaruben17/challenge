package com.wenance.challenge.task;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**  
 * Configurador del bot
 * @author RS
 */
@Configuration
@EnableScheduling
@EnableAsync
public class TaskConfiguration implements SchedulingConfigurer{

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
	}
	
	private Executor taskExecutor() {
	  return Executors.newScheduledThreadPool(20);
	}

}
