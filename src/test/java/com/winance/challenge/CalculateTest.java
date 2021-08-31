package com.winance.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.wenance.challenge.util.Calculate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculateTest {

	@InjectMocks 
	private Calculate calculate;
	
	@Test
	public void diffPercentTest() {
		
		BigDecimal promedio = BigDecimal.valueOf(48980.23);
		BigDecimal higth = BigDecimal.valueOf(48980.23);
		
		BigDecimal diffPercent = this.calculate.averageValue(promedio, higth);
		
		log.info("Porcentaje de diferencia: "+diffPercent.toString());
		
		assertThat(diffPercent.toString()).isEqualTo("0");		
	}
}
