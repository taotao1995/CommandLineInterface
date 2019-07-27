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
 * @author TaoTao
 *
 */

public class Cli {
	private static final String COMMA = ",";
	private static final int LIMIT = 0 ;
	static private String dirPath = "./Resource";  
	static private File[] InputFiles;
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
	      //if we have not read a file, generate plantList
	      if(plantList != null) {
	    	  plantList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
	      //if we have read any file, add new list items after plantList
	      }else {
	    	  plantList.addAll(br.lines().skip(1).map(mapToItem).collect(Collectors.toList()));
	      }
	      
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
		Plant plant = null;
		try {
		// Lambda expression feature in java 8, read in a line and seperate the line into cells of different data types.
	  String[] cells =  line.split(COMMA, LIMIT);// a CSV has comma separated lines
		  
	  
	  plant = new Plant.PlantBuilder()
		  // if the cell is not empty, set the plant data.
		  .setEntryType(cells[0].isEmpty() ?  null : cells[0])
           //.addCount()
		  .setPlantingDate(cells[1].isEmpty() ?  null : cells[1])
           //.addCount()
		  .setGid(cells[2].isEmpty() ?  null: cells[2])
           //.addCount()
		  .setDesignation(cells[3].isEmpty() ?  null: cells[3])
           //.addCount()
		  .setEntryNo(cells[4].isEmpty() ?  null: Integer.parseInt(cells[4]))
           //.addCount()
		  .setEH(cells[5].isEmpty() ? null: Float.parseFloat(cells[5]))
           //.addCount()
		  .setPH(cells[6].isEmpty() ?  null: Float.parseFloat(cells[6]))
           //.addCount()
		  .setDTA(cells[7].isEmpty() ?  null: Integer.parseInt(cells[7]))
           //.addCount()
		  .setDTS(cells[8].isEmpty() ?  null: Integer.parseInt(cells[8]))
           //.addCount()
		  .setMOI(cells[9].isEmpty() ?  null: Float.parseFloat(cells[9]))
           //.addCount()
		  .setGW(cells[10].isEmpty() ?  null: Integer.parseInt(cells[10]))
           //.addCount()
		  .setEarHvst(cells[11].isEmpty() ?  null: Integer.parseInt(cells[11]))
           //.addCount()
		  .setRlodg(cells[12].isEmpty() ?  null: Integer.parseInt(cells[12]))
           //.addCount()
		  .setSlodg(cells[13].isEmpty() ?  null: Integer.parseInt(cells[13]))
           //.addCount()
		  .setRepNo(cells[14].isEmpty() ?  null: Integer.parseInt(cells[14]))
           //.addCount()
		  .setPlotNo(cells[15].isEmpty() ?  null: Integer.parseInt(cells[15]))
           //.addCount()
		  .setColumn(cells[16].isEmpty() ?  null: Integer.parseInt(cells[16]))
           //.addCount()
		  .setRow(cells[17].isEmpty() ?  null: Integer.parseInt(cells[17]))
		  .build();
	  
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		
		return plant;
		
	};
	
}
