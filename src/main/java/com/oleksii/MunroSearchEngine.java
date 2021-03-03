package com.oleksii;

import java.util.List;
import java.util.Objects;

public class MunroSearchEngine {
	
	List<Munro> munroDataSource;

	public MunroSearchEngine(List<Munro> munroDataSource) {		 
		this.munroDataSource = Objects.requireNonNull(munroDataSource);
	}
	
}
