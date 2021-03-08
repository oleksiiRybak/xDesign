package com.oleksii;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MunroSearchEngine implements SearchEngine<Munro, String> {
	
	List<Munro> munroDataSource;

	public MunroSearchEngine(List<Munro> munroDataSource) {		 
		this.munroDataSource = Objects.requireNonNull(munroDataSource);
	}

	@Override
	public List<Munro> filterBy(String munroType) {
		
		List<Munro> munroList;
		if(munroType != null && !"".equals(munroType)) {
			munroList = munroDataSource.stream().filter(m -> munroType.equals(m.munroType)).collect(Collectors.toList());
		} else {
			munroList = munroDataSource.stream().filter(m -> m.munroType != null).collect(Collectors.toList());
		}
		
		return munroList;
	}
	
	
	
}
