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
		try (CSVReader reader = new CSVReader(new FileReader("munrotab_v6.2.csv"))) {
		      List<String[]> r = reader.readAll();
		      
		      r.stream().skip(1).filter(munroData -> munroData[0] != null && !"".equals(munroData[0]))
		      			.forEach(munroArr -> {
				    	  Munro munro = createMunro(munroArr);
				    	  munroList.add(munro);
		      			});
		}
		return munroList;
	}
	
	public static Munro createMunro(String[] munroArr) {
		return new Munro(munroArr[5], new BigDecimal(munroArr[10]), munroArr[13], munroArr[27]);
	}

}
