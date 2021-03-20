package com.oleksii;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.oleksii.MunroSearchEngine;

class MunroSearchEngineTest {
	
	SearchEngine munroSearchEngine;
	List<Munro> munroList;

	@BeforeEach
	void setUp() throws Exception {		
		munroList = prepareMunroList();
		munroSearchEngine = new MunroSearchEngine(munroList);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
		
	@Test
	void testFilterByMunType() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		String munroType = "MUN";		
		int expectedNumberOfRecords = 2;
		
		munroSearchEngine.filterBy(Optional.of(munroType));
		
		assertEquals(expectedNumberOfRecords, munroSearchEngine.getMunroDataResult().size());
		assertTrue(munroType.equals(munroSearchEngine.getMunroDataResult().get(0).getMunroType()));
	}
	
	@Test
	void testSortedMunro() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		boolean sortByNameAsc = true;
		boolean sortByHeightAsc = true;
		BigDecimal lowestMunro = new BigDecimal(900.0);
		BigDecimal highestMunro = new BigDecimal(1700.0);
		int expectedNumberOfRecords = 7;
		
		munroSearchEngine.sortByHeightAndName(sortByNameAsc, sortByHeightAsc);
		
		assertEquals(expectedNumberOfRecords, munroSearchEngine.getMunroDataResult().size());		
		assertEquals(lowestMunro, munroSearchEngine.getMunroDataResult().get(0).getHeightInM());
		assertEquals(highestMunro, munroSearchEngine.getMunroDataResult().get(6).getHeightInM());
	}
	
	@Test
	void testMunroSortedOrderOfNames() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		boolean sortByNameAsc = true;
		boolean sortByHeightAsc = true;
				
		munroSearchEngine.sortByHeightAndName(sortByNameAsc, sortByHeightAsc);		
		
		int compareFirstCharacters = Character.compare(munroSearchEngine.getMunroDataResult().get(3).getName().charAt(0), 
										      		   munroSearchEngine.getMunroDataResult().get(4).getName().charAt(0)); 
		assertTrue(compareFirstCharacters < 0);
	}
	
	@Test
	void testFilterByTopType() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		String munroType = "TOP";
		munroSearchEngine.filterBy(Optional.of(munroType));
		
		assertEquals(4, munroSearchEngine.getMunroDataResult().size());
		assertTrue(munroType.equals(munroSearchEngine.getMunroDataResult().get(0).getMunroType()));
	}
	
	@Test
	void testMunroLimit1() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		String recordsLimit = "1";
		munroSearchEngine.limitResults(Optional.of(recordsLimit));
				
		assertEquals(Integer.parseInt(recordsLimit), munroSearchEngine.getMunroDataResult().size());
	}
	
	@Test
	void testMunroLimit3() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		String recordsLimit = "3";
		munroSearchEngine.limitResults(Optional.of(recordsLimit));
				
		assertEquals(Integer.parseInt(recordsLimit), munroSearchEngine.getMunroDataResult().size());
	}
	
	@Test
	void testMunroNoLimit() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		String recordsNoLimit = "0";
		int expectedNumberOfRecords = 7;
		
		munroSearchEngine.limitResults(Optional.of(recordsNoLimit));
				
		assertEquals(expectedNumberOfRecords, munroSearchEngine.getMunroDataResult().size());
	}
	
	@Test
	void testFilterByMinMaxHeight() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		
		BigDecimal minHeight = new BigDecimal("850.00");
		BigDecimal maxHeight = new BigDecimal("950.00");
		BigDecimal expectedHeightForMunro = new BigDecimal(900.0);
		int expectedNumberOfRecords = 1;
		
		munroSearchEngine.filterByMinMaxHeight(Optional.of(minHeight), Optional.of(maxHeight));
		
		assertEquals(expectedNumberOfRecords, munroSearchEngine.getMunroDataResult().size());
		assertEquals(expectedHeightForMunro, munroSearchEngine.getMunroDataResult().get(0).getHeightInM());
	}
	
	@Test
	void testFilterByMinMaxHeightWithNoHeightSet() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		int expectedNumberOfRecords = 7;
				
		munroSearchEngine.filterByMinMaxHeight(Optional.ofNullable(null), Optional.ofNullable(null));
		
		assertEquals(expectedNumberOfRecords, munroSearchEngine.getMunroDataResult().size());
		
	}
	
	
	private List<Munro> prepareMunroList() {
		List<Munro> munroList = new ArrayList<>();
		Munro m1 = new Munro("Ben Vorlich", new BigDecimal(1000.0), "NN773308", "TOP");
		Munro m2 = new Munro("Cruach Ardrain - Stob Garbh", new BigDecimal(1500.0), "NN629189", "MUN");
		Munro m3 = new Munro("Meall na Aighean", new BigDecimal(1500.0), "NN617174", "MUN");
		Munro m4 = new Munro("Stuca Chroin", new BigDecimal(1500.0), "NN432244", "TOP");
		Munro m5 = new Munro("An Stuc", new BigDecimal(1700.0), "NN438220", "TOP");
		Munro m6 = new Munro("Creise", new BigDecimal(900.0), "NN411221", "TOP");
		Munro emptyMunro = new Munro("", new BigDecimal(1000.0), "NN265264", "");
		munroList.add(m1);
		munroList.add(emptyMunro);
		munroList.add(m2);
		munroList.add(m3);
		munroList.add(m4);
		munroList.add(m5);
		munroList.add(m6);
		
		return munroList;
	}


}
