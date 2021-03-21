package com.oleksii.munroservice.domain.webservice;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SearchEngine<E,N> {
	
	void filterBy(Optional<N> filterParam); 	
	void limitResults(Optional<N> limit);
	
}
