package com.oleksii;

import java.math.BigDecimal;
import java.util.Objects;

public class Munro {
	
	private String name;	
	private BigDecimal heightInM;
	private String munroType;
	private String gridRef;
	
	
	public Munro(String name, BigDecimal heightInM, String gridRef, String munroType) {
		this.name = Objects.requireNonNull(name);
		this.heightInM = Objects.requireNonNull(heightInM);
		this.munroType = Objects.requireNonNull(munroType);
		this.gridRef = Objects.requireNonNull(gridRef);
			
	}
	
	public String getName() {
		return name;
	}
	
	public String getGrifRef() {
		return gridRef;
	}


	public BigDecimal getHeightInM() {
		return heightInM;
	}


	public String getMunroType() {
		return munroType;
	}


}
