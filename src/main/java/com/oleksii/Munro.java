package com.oleksii;

import java.math.BigDecimal;

public class Munro {
	
	String name;	
	BigDecimal heightInM;
	String munroType;
	
	
	public Munro(String name, BigDecimal heightInM, String munroType) {
		this.name = name;
		this.heightInM = heightInM;
		this.munroType = munroType;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getHeightInM() {
		return heightInM;
	}


	public void setHeightInM(BigDecimal heightInM) {
		this.heightInM = heightInM;
	}


	public String getMunroType() {
		return munroType;
	}


	public void setMunroType(String munroType) {
		this.munroType = munroType;
	}



}
