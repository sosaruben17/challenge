package com.wenance.challenge.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CriptoPrice {
	private static CriptoPrice criptoPrice;
	private ArrayList<Cripto> criptoList = new ArrayList<Cripto>();
	
	public CriptoPrice (Cripto cripto) {
		this.criptoList.add(cripto);
	}
	
	public static CriptoPrice getCriptoPrice(Cripto cripto) {
		if(criptoPrice == null) {
		  criptoPrice = new CriptoPrice(cripto);
		}else {
		  criptoPrice.criptoList.add(cripto);
		}
		return criptoPrice;
	}
	
	public static CriptoPrice getCriptoPrice() {
		return criptoPrice;
	}

	public ArrayList<Cripto> getCriptoList() {
		return criptoList;
	}

	public void setCriptoList(ArrayList<Cripto> criptoList) {
		this.criptoList = criptoList;
	}

}
