package com.oleksii;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MunroSearchEngine implements SearchEngine<Munro, String> {
	
	private List<Munro> munroDataSource;

	public MunroSearchEngine(List<Munro> munroDataSource) {		 
		this.munroDataSource = Objects.requireNonNull(munroDataSource);
	}
	

	public List<Munro> getMunroDataResult() {
		return munroDataSource;
	}


	@Override
	public void filterBy(String munroType) { 
		
		if(munroType != null && !"".equals(munroType)) {
			this.munroDataSource = munroDataSource.stream().filter(m -> !"".equals(m.munroType))
												.filter(m -> munroType.equals(m.munroType))												
												.collect(Collectors.toList());
		} else {
			this.munroDataSource = munroDataSource.stream().filter(m -> m.munroType != null)
												.filter(m -> !"".equals(m.munroType))
												.collect(Collectors.toList());
		}		
		
	}

	public void sortByHeightAndName(boolean sortByNameAsc, boolean sortByHeightAsc) {
		Comparator<Munro> compareByMunroHeigh;
		Comparator<Munro> compareByMunroName;
		
		if(sortByHeightAsc) {
			compareByMunroHeigh = Comparator.comparing( Munro::getHeightInM );
		} else {
			compareByMunroHeigh = Comparator.comparing( Munro::getHeightInM ).reversed();
		}
		
		if(sortByNameAsc) {
			compareByMunroName = Comparator.comparing( Munro::getName );
		} else {
			compareByMunroName = Comparator.comparing( Munro::getName ).reversed();
		}
		
		this.munroDataSource =  munroDataSource.stream()
								.sorted(compareByMunroName)	
								.sorted(compareByMunroHeigh)							    					               
						        .collect(Collectors.toList());
		
	}
	
	
	
}
