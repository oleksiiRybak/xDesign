package com.oleksii;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		munroSearchEngine.filterBy("MUN");
		
		assertEquals(2, munroSearchEngine.getMunroDataResult().size());
		assertTrue(munroType.equals(munroSearchEngine.getMunroDataResult().get(0).munroType));
	}
	
	@Test
	void testSortedMunro() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		boolean sortByNameAsc = true;
		boolean sortByHeightAsc = true;
		BigDecimal lowestMunro = new BigDecimal(900.0);
		BigDecimal highestMunro = new BigDecimal(1700.0);
		
		munroSearchEngine.sortByHeightAndName(sortByNameAsc, sortByHeightAsc);
		
		assertEquals(7, munroSearchEngine.getMunroDataResult().size());		
		assertEquals(lowestMunro, munroSearchEngine.getMunroDataResult().get(0).getHeightInM());
		assertEquals(highestMunro, munroSearchEngine.getMunroDataResult().get(6).getHeightInM());
	}
	
	@Test
	void testMunroSortedOrderOfNames() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		boolean sortByNameAsc = true;
		boolean sortByHeightAsc = true;
		BigDecimal lowestMunro = new BigDecimal(900.0);
		BigDecimal highestMunro = new BigDecimal(900.0);
		
		munroSearchEngine.sortByHeightAndName(sortByNameAsc, sortByHeightAsc);		
		
		int compareFirstCharacters = Character.compare(munroSearchEngine.getMunroDataResult().get(3).getName().charAt(0), 
										      		   munroSearchEngine.getMunroDataResult().get(4).getName().charAt(0)); 
		assertTrue(compareFirstCharacters < 0);
	}
	
	@Test
	void testFilterByTopType() {
		MunroSearchEngine munroSearchEngine = new MunroSearchEngine(prepareMunroList());
		String munroType = "TOP";
		munroSearchEngine.filterBy(munroType);
		
		assertEquals(4, munroSearchEngine.getMunroDataResult().size());
		assertTrue(munroType.equals(munroSearchEngine.getMunroDataResult().get(0).munroType));
	}
	
	
	private List<Munro> prepareMunroList() {
		List<Munro> munroList = new ArrayList<>();
		Munro m1 = new Munro("Ben Vorlich", new BigDecimal(1000.0), "TOP");
		Munro m2 = new Munro("Cruach Ardrain - Stob Garbh", new BigDecimal(1500.0), "MUN");
		Munro m3 = new Munro("Meall na Aighean", new BigDecimal(1500.0), "MUN");
		Munro m4 = new Munro("Stuca Chroin", new BigDecimal(1500.0), "TOP");
		Munro m5 = new Munro("An Stuc", new BigDecimal(1700.0), "TOP");
		Munro m6 = new Munro("Creise", new BigDecimal(900.0), "TOP");
		Munro emptyMunro = new Munro("", new BigDecimal(1000.0), "");
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
