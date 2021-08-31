package com.wenance.challenge.util;

import java.time.LocalDateTime;
import java.util.function.Predicate;

import com.wenance.challenge.models.Cripto;

public class CriptoUtil {
	
	public static boolean rango(Cripto cripto, String time1, String time2) {

        Predicate < Cripto > p1 = (Cripto c) -> c.getDate().equals(LocalDateTime.parse(time1));
        Predicate < Cripto > p2 = (Cripto c) -> c.getDate().equals(LocalDateTime.parse(time2));
        Predicate < Cripto > ptotal = p1.or(p2);

        return ptotal.test(cripto);
    }
}
