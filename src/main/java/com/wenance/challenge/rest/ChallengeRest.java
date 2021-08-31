package com.wenance.challenge.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wenance.challenge.models.Cripto;
import com.wenance.challenge.services.CriptoService;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins="*")
public class ChallengeRest {

	  @Autowired
	  private CriptoService criptoService;

	  @GetMapping("/price/{timeStamp}")
	  public Mono<Cripto> getBTCPrice(@PathVariable String timeStamp) {
	    return criptoService.findByTimeStamp(timeStamp);
	  }
	  
	  @GetMapping("/pricedata/{time1}/{time2}")
	  public Mono<String> getBTCPriceData(@PathVariable String time1, @PathVariable String time2) {
	    return criptoService.averageValuesByTimestamps(time1, time2);
	  }
	  
}
