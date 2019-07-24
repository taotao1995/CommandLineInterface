package cli;

import java.io.BufferedReader;
// it is preferred to use maven or gradle if we have more depedencies in large project.
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import cli.Plant.PlantBuilder;


/**
 * @author taota
 *
 */

public class Cli {
	private static final String COMMA = ",";
	static private String dirPath = "./Resource";  
	static private File[] InputFiles;
	static private FileReader fileReader;
	static private List<Plant> plantList = new ArrayList<Plant>();
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		InputFiles = getInputFiles(dirPath);

		for( File inputFile : InputFiles ) {
			setPlantList(inputFile);
		}
		
		 
		

	}
	


	/**
	 * 
	 * @param dirPath
	 * @return
	 */
	public static File[] getInputFiles(String dirPath) {
		//This function returns input files with dynamic file extensions.
		File dir = new File(dirPath);

		 return dir.listFiles(new FilenameFilter() { 
             public boolean accept(File dir, String filename){ return filename.endsWith(".csv"); }
		 } );

	}
	
	public static List<Plant> setPlantList(File inputFile) {
		try {
	      InputStream in = new FileInputStream(inputFile);
	      BufferedReader br = new BufferedReader(new InputStreamReader(in));
	      plantList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
		}catch (Exception e) { 
	        e.printStackTrace(); 
	    }
		
		return plantList;
	}
	

	/**
	 * 
	 * @param <String>
	 * @param <Plant>
	 * @return
	 */
	private static Function<String, Plant> mapToItem = (line) -> {
		// Lambda expression feature in java 8
	  String[] cells =  line.split(COMMA);// a CSV has comma separated lines
	  
	  Plant plant = new Plant.PlantBuilder().setGid(cells[2]).build();

	  return plant;
	};
	
}
