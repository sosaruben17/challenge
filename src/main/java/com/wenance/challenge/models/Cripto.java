package com.wenance.challenge.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cripto {
	Double lprice;
	String curr1;
	String curr2;
	LocalDateTime date;
	
}
