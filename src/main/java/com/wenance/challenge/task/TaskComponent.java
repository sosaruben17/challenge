package com.wenance.challenge.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wenance.challenge.services.CriptoService;


@Component
public class TaskComponent {

	@Autowired CriptoService criptoService;
	
	@Scheduled(fixedDelay = 10000, initialDelay = 100)
	public void exampleTask() {
		this.criptoService.task();
	}
}
