package com.oleksii;

import static org.junit.jupiter.api.Assertions.*;

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

	private List<Munro> prepareMunroList() {
		List<Munro> munroList = new ArrayList<>();
		return munroList;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFilterBy() {
		//fail("Not yet implemented");
	}

}
