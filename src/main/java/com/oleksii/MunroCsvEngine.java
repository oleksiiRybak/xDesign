package com.oleksii;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class MunroCsvEngine {
	
	public static void processCsv() throws FileNotFoundException, IOException, CsvException {
		try (CSVReader reader = new CSVReader(new FileReader("munrotab_test.csv"))) {
		      List<String[]> r = reader.readAll();
		      System.out.println(Arrays.toString(r.get(0)));
		      //r.forEach(x -> System.out.println(Arrays.toString(x)));
		  }
	}

}
