package com.oleksii;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.opencsv.exceptions.CsvException;

@RestController
public class MunroController {

	
	@GetMapping(path="/characters", produces="application/json")	
	//List<String> allMarvelCharacters() 
	String allMarvelCharacters() 
				 throws NoSuchAlgorithmException, 
				 FileNotFoundException, IOException, CsvException {		
		String tt = "";
		MunroCsvEngine.processCsv();
		//List<String> recordingArr = marvelConnector.fetchAllRecords();
				
	  return "Lolo";
	}
		
	 @GetMapping(path="/characters/{id}", produces="application/json")
	 String one(@PathVariable String id) { 
		 //Character marvelCharacter = marvelConnector.fetchRecordById(id);
		 Gson gson = new Gson();		 
		 //String marvelCharacterJson = gson.toJson(marvelCharacter);

		 return "Polo"; 
	 }
	
}
