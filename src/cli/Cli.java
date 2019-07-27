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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.cli.*;


import cli.Plant.PlantBuilder;


/**
 * @author TaoTao
 *
 */

public class Cli {
	private static final String COMMA = ",";
	private static final int LIMIT = 0 ;
	private static String dirPath = "./Resource";  
	private static File[] InputFiles;
	private static ArrayList<Integer> colNumList = new ArrayList<Integer>();
	private static List<Plant> plantList = new ArrayList<Plant>();
	private static List<Plant> topResults = new ArrayList<Plant>();
	private static String FIRST_LINE_IN_CSV;
	private static String[] FIRST_LINE_CELLS;
	private static Method[] BUILDER_METHODS_IN_ORDER;
	private static Method[] PLANT_METHODS_IN_ORDER;
	
	
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		InputFiles = getInputFiles(dirPath);

		for( File inputFile : InputFiles ) {
			setPlantList(inputFile);
		}
		
		//options in command line
		Options options = new Options();
		Option opt = new Option("h", "help", false,"Print help");
		opt.setRequired(false);
		options.addOption(opt);
		
		for(int m = 0; m < FIRST_LINE_CELLS.length; m++){
			Option option = new Option("eh"+m,""+m,false,"return top 3 results from the specified column");
			option.setRequired(false);
			options.addOption(option);
		}
		

		
		
		CommandLineParser parser = new DefaultParser();
//      CommandLineParser parser = new GnuParser ();
//      CommandLineParser parser = new PosixParser();

		try {
			//get the options to see what columns in csv need to be sorted, store in the colNumList.
			CommandLine cmd = parser.parse( options, args);
			System.out.println("please type -eh followed by a number to get the columns.eg. -eh2 -eh4");
	
			Option[] opts = cmd.getOptions();
			
            if (opts != null) {
            	for (Option opt1 : opts) {
            	String name = opt1.getLongOpt();
            	int colNum = Integer.parseInt(name);
            	colNumList.add(colNum);
            	}
            }
            
            PLANT_METHODS_IN_ORDER = getOrderedMethods(Plant.class);
            for(int col : colNumList) {
            	// sort all columns to get the top 3 values from each column, and compare again to get the top 3 values out of all columns
            	// get the final rows , and return all values in the row for each column.
            	
            	//sort all columns to get the top 3 values from each column
            	//get the final rows, and compare again to get the top 3 values of sum out for all columns.

            	//top3 = sort(col);
            	
            	sort(col);
            	
            	
            	
            }
            
		}catch(ParseException e) {
			e.printStackTrace();
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
	    	  //read the first line for use in mapToItem function.
	    	  FIRST_LINE_IN_CSV = br.readLine();
	    	  FIRST_LINE_CELLS = FIRST_LINE_IN_CSV .split(COMMA);
	    	  //BUILDER_METHODS_IN_ORDER = getOrderedMethods(PlantBuilder.class);
	    	  
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
	
	
	
	
	public static Method[] getOrderedMethods(Class cl) {
		  // Java reflection to get methods matching csv header order.
		  Method[] methods = cl.getDeclaredMethods();
		  Method[] tmpMds = new Method[FIRST_LINE_CELLS.length];
		  for(Method m : methods) {
			  String mdName = m.getName();
			  String tmpName = mdName.toLowerCase();
			  //only if the method names are not called access$
			  if(!mdName.contains("access")) {
				  //System.out.println(mdName);
				  for(int i = 0; i < FIRST_LINE_CELLS.length; i ++) {
					  String parameterName;
					  if(FIRST_LINE_CELLS[i].contains("_")) {
						  parameterName = FIRST_LINE_CELLS[i].substring(0,FIRST_LINE_CELLS[i].indexOf("_")).toLowerCase();
						  
					  }else {
						  parameterName = FIRST_LINE_CELLS[i].toLowerCase();
					  }
					  
					  if(tmpName.contains(parameterName)){
						  // return methods in ordered list, eg. add setColumn method to pos17 if a match is found.
						  tmpMds[i] = m;
					  }
				 }
			}	   
		  }
		  return tmpMds;
		}
		
		public static List<Plant> sort(int num) {
			Method m = PLANT_METHODS_IN_ORDER[num];
			if(! hasNumParameter(m.getName())){
				System.out.println("Sorry we cant sort on this column of strings, please change to another column of numbers");
			};
			
			for(Plant pl : plantList) {
				try {
					m.invoke(pl);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
			
			
		}
		
		
		public static boolean hasNumParameter(String methodName) {
			switch(methodName) {
			case("getGid"):
			case("getDesignation"):
			case("getPlantingDate"):
			case("getEntryType"):
				return false;
			default:
				return true;
			}

		
		
		
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
	  
	  //TODO - prepare cells as parameters 
	//	  for(int j=0;j<cells.length;j++) {
	//		  if(j == 0||1||2||3) {
	//		  cells[j] = cells[j].isEmpty() ?  null : cells[j];
	//		  }else if(j== 5||6||9){
	//			 cells[j] = cells[5].isEmpty() ? null: Float.parseFloat(cells[j]);
	//		  }else {
	//			  cells[j] = cells[5].isEmpty() ? null: Integer.parseInt(cells[j]);
	//		  }
	//	  }
		  
	  
	  //TODO - invoke methods for the plantBuilder object
	//	  	PlantBuilder builder = new Plant.PlantBuilder();
	//		  for(Method m : METHODS_IN_ORDER) {
	//			  m.invoke(builder,parameters); 
	//		  }
	  
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