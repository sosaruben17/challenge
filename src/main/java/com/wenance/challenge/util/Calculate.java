package com.wenance.challenge.util;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.stereotype.Component;

@Component
public class Calculate {
	
	
	public static BigDecimal averageValue(BigDecimal promedio, BigDecimal higth) {
			
		MathContext mc = new MathContext(10);
		BigDecimal substrac = higth.subtract(promedio);
		BigDecimal difference = substrac.divide(higth, mc);
		BigDecimal diffPercent = difference.multiply(BigDecimal.valueOf(100));
		
		return diffPercent;	
	}
	
}
