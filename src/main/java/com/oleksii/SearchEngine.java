package com.oleksii;

import java.util.List;

public interface SearchEngine<E, N> {
	
	List<E> filterBy(N filterParam); 

}
