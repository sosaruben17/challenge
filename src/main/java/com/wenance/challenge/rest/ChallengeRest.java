package com.wenance.challenge.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenance.challenge.models.Cripto;
import com.wenance.challenge.services.CriptoService;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class ChallengeRest {

	  @Autowired
	  private CriptoService criptoService;

	  @GetMapping("/price/{timeStamp}")
	  public Mono<ResponseEntity<Cripto>> getBTCPrice(@PathVariable String timeStamp) {
	    return criptoService.findByTimeStamp(timeStamp)
	    	   .map(c -> ResponseEntity.ok()
	    	            .contentType(MediaType.APPLICATION_JSON)
	    	            .body(c))
	    	   .defaultIfEmpty(ResponseEntity.notFound().build());
	  }
	  
	  @GetMapping("/pricedata/{time1}/{time2}")
	  public Mono<ResponseEntity<String>> getBTCPriceData(@PathVariable String time1, @PathVariable String time2) {
	    return criptoService.averageValuesByTimestamps(time1, time2)
	    		.map(s -> ResponseEntity.ok()
	    	            .contentType(MediaType.APPLICATION_JSON)
	    	            .body(s))
	    	   .defaultIfEmpty(ResponseEntity.notFound().build());
	  }
	  
}
