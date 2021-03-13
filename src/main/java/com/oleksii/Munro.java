package com.oleksii;

import java.math.BigDecimal;
import java.util.Objects;

public class Munro {
	
	String name;	
	BigDecimal heightInM;
	String munroType;
	
	
	public Munro(String name, BigDecimal heightInM, String munroType) {
		this.name = Objects.requireNonNull(name);
		this.heightInM = Objects.requireNonNull(heightInM);
		this.munroType = Objects.requireNonNull(munroType);
			
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
