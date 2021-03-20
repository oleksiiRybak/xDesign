package com.oleksii;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.opencsv.exceptions.CsvException;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

@RestController
public class MunroController {

	
	@GetMapping(path="/munroHills", produces="application/json")	
	//List<String> allMarvelCharacters() 
	List filterByHillCategory(@QueryParam("hillCategory") @DefaultValue("") String hillCategory,
							  @QueryParam("sortByNameAsc") @DefaultValue("true") boolean sortByNameAsc,
							  @QueryParam("sortByHeightAsc") @DefaultValue("true") boolean sortByHeightAsc,
							  @QueryParam("limit") @DefaultValue("") String limit,
							  @QueryParam("minHeight") @DefaultValue(value = "0.0") BigDecimal minHeight,
							  @QueryParam("maxHeight") @DefaultValue(value = "0.0") BigDecimal maxHeight) 
							  throws NoSuchAlgorithmException, 
							  FileNotFoundException, IOException, CsvException {		
		
		MunroSearchEngine searchEngine = dataInSearchEngine();
		searchEngine.filterBy(Optional.ofNullable(hillCategory));
		searchEngine.filterByMinMaxHeight(Optional.ofNullable(minHeight), Optional.ofNullable(maxHeight));		
		searchEngine.sortByHeightAndName(sortByNameAsc, sortByHeightAsc);		
		
		searchEngine.limitResults(Optional.ofNullable(limit));
		//List<String> recordingArr = marvelConnector.fetchAllRecords();
		
	  return searchEngine.getMunroDataResult();
	}
	
	/*
	 * @GetMapping(path="/hillCategorySorted", produces="application/json")
	 * //List<String> allMarvelCharacters() List
	 * filterByHillCategory(@QueryParam("hillCat") String hillCategory,
	 * 
	 * @QueryParam("sortByNameAsc") boolean sortByNameAsc,
	 * 
	 * @QueryParam("sortByHeightAsc") boolean sortByHeightAsc) throws
	 * NoSuchAlgorithmException, FileNotFoundException, IOException, CsvException {
	 * MunroSearchEngine searchEngine = dataInSearchEngine(); //List<Munro>
	 * resultMunroList = searchEngine.filterBy(hillCategory);
	 * 
	 * 
	 * return null; }
	 */

	protected MunroSearchEngine dataInSearchEngine() throws FileNotFoundException, IOException, CsvException {
		List<Munro> munroList = MunroCsvEngine.processCsv();
		return new MunroSearchEngine(munroList);		
	}
	
	
	@GetMapping(path="/sort", produces="application/json")	
	//List<String> allMarvelCharacters() 
	List sortByHeightAndName(@QueryParam("hillCat") String hillCategory) 
				 throws NoSuchAlgorithmException, 
				 FileNotFoundException, IOException, CsvException {	
		return null;
	}
	
		
	 @GetMapping(path="/characters/{id}", produces="application/json")
	 String one(@PathVariable String id) { 
		 //Character marvelCharacter = marvelConnector.fetchRecordById(id);
		 Gson gson = new Gson();		 
		 //String marvelCharacterJson = gson.toJson(marvelCharacter);

		 return "Polo"; 
	 }
	
}
