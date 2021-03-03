package com.oleksii;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class MunroCsvEngine {
	
	public static List<Munro> processCsv() throws FileNotFoundException, IOException, CsvException {
		List<Munro> munroList = new ArrayList<>();
		try (CSVReader reader = new CSVReader(new FileReader("munrotab_test.csv"))) {
		      List<String[]> r = reader.readAll();
		      
		      //List<String[]> munroArr = r.stream().filter(munroArr -> munroArr[10] != null);
		      //System.out.println(Arrays.toString(r.get(0)));
		      
		      //r.forEach(x -> System.out.println(Arrays.toString(x)));
		      r.stream().skip(1).filter(munroData -> munroData[10] != null).forEach(munroArr -> {
		    	  Munro munro = createMunro(munroArr);
		    	  munroList.add(munro);
		      });
		  }
		return munroList;
	}
	
	public static Munro createMunro(String[] munroArr) {
		return new Munro(munroArr[5], new BigDecimal(munroArr[10]), munroArr[27]);
	}

}
