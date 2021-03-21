package com.oleksii.munroservice.domain.webservice;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.oleksii.munroservice.domain.Munro;

@Component
public class MunroSearchEngine implements SearchEngine<Munro, String> {
	
	private List<Munro> munroDataSource;

	public MunroSearchEngine(List<Munro> munroDataSource) {		 
		this.munroDataSource = Objects.requireNonNull(munroDataSource);
	}
	

	public List<Munro> getMunroDataResult() {
		return munroDataSource;
	}


	@Override
	public void filterBy(Optional<String> munroType) { 
		
		if(munroType.isPresent() && !"".equals(munroType.get())) {
			this.munroDataSource = munroDataSource.stream().filter(m -> !"".equals(m.getMunroType()))
												  .filter(m -> munroType.get().equals(m.getMunroType()))												
												  .collect(Collectors.toList());
		} else {
			this.munroDataSource = munroDataSource.stream().filter(m -> m.getMunroType() != null)
												  .filter(m -> !"".equals(m.getMunroType()))
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


	public void limitResults(Optional<String> limit) {
		
		if(limit.isPresent() && Integer.parseInt(limit.get()) > 0) {			
			this.munroDataSource = munroDataSource.stream().limit(Integer.parseInt(limit.get())).collect(Collectors.toList());
		} 		
		
	}


	public void filterByMinMaxHeight(Optional<BigDecimal> minHeight, Optional<BigDecimal> maxHeight) {
		
		Predicate<Munro> munroMinHeightPredicate;
		Predicate<Munro> munroMaxHeightPredicate;
		
		if(minHeight.isPresent()) {
			munroMinHeightPredicate = m -> m.getHeightInM().compareTo(minHeight.get()) > 0;
		} else {
			munroMinHeightPredicate = m -> true;
		}
		
		if(maxHeight.isPresent()) {
			munroMaxHeightPredicate = m -> m.getHeightInM().compareTo(maxHeight.get()) < 0;
		} else {
			munroMaxHeightPredicate = m -> true;
		}		
		
		this.munroDataSource = munroDataSource.stream().filter(munroMinHeightPredicate)	
														   .filter(munroMaxHeightPredicate)	
														   .collect(Collectors.toList());		
		
	}
	
	
	
}
