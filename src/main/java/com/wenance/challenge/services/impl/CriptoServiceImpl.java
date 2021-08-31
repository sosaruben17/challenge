package com.wenance.challenge.services.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.google.gson.Gson;
import com.wenance.challenge.models.Cripto;
import com.wenance.challenge.models.CriptoPrice;
import com.wenance.challenge.services.CriptoService;
import com.wenance.challenge.util.Calculate;
import com.wenance.challenge.util.CriptoUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**  
 * Implementacion de interfaz CriptoService
 * @author RS
 */

@Slf4j
@Service
public class CriptoServiceImpl implements CriptoService{

	@Value("${webclient.url.base}")
	private String url_base;
	
	@Value("${cripto.pair}")
	private String cripto_pair;
	
	@Override
	public void task() {
		log.info("Cargando nueva consulta de precio");

		Cripto cripto = new Gson().fromJson(this.responseWebClientGet().block(), Cripto.class);
	    cripto.setDate(LocalDateTime.now());

		CriptoPrice.getCriptoPrice(cripto);
		
		log.info("Se agrego {} a la Lista de precios", cripto);
	}
	
	private Mono<String> responseWebClientGet() {
		try{
			
			return WebClient.create(url_base).get().uri(cripto_pair)
					   .accept(MediaType.APPLICATION_JSON)
					   .retrieve()
				       .bodyToMono(String.class);
			
		} catch(WebClientResponseException ex) {
            log.error("Codigo de error : {} con el mensaje {}", ex.getRawStatusCode(), ex.getResponseBodyAsString());
            log.error("WebClientResponseException", ex);
            throw ex;
        } catch(Exception e){
            log.error("Internal server exception ", e);
            throw e;
        }
	}



	@Override
	public Mono<Cripto> findByTimeStamp(String timeStamp) { 
		return Mono.justOrEmpty(CriptoPrice.getCriptoPrice().getCriptoList().stream()
		          .filter(filter -> filter.getDate().equals(LocalDateTime.parse(timeStamp)))
		          .findAny());
	}



	@Override
	public Mono<String> averageValuesByTimestamps(String time1, String time2) {
		
		Double promedio = CriptoPrice.getCriptoPrice().getCriptoList().stream()
				        .filter(filter -> CriptoUtil.rango(filter, time1, time2))
				        .mapToDouble(Cripto::getLprice).average().getAsDouble();
		
		Cripto cripto = CriptoPrice.getCriptoPrice().getCriptoList().stream()
				            .max(Comparator.comparing(Cripto::getLprice))
				            .orElse(new Cripto(null, null, null, null)); 
		
		BigDecimal diffPercent = Calculate.averageValue(BigDecimal.valueOf(promedio), BigDecimal.valueOf(cripto.getLprice()));
		
		return Mono.just("Valor promedio: "+promedio +
				    " Porcentaje de diferencia con el valor mas alto: "+diffPercent);
	}
	

}
