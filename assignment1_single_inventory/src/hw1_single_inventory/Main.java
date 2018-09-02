/**
 * 
 */
package hw1_single_inventory;

import java.io.File;
import java.util.ArrayList;

/**
 * @author sengming
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Command> commandList = new ArrayList<Command>();
		ArrayList<DataEntry> database = new ArrayList<DataEntry>();
		
		File inputFile = new File("src/hw1_single_inventory/in.txt");
		
		CommandFactory commandFactory = new CommandFactory(database);
		LineHandlerFactory lineFactory = new LineHandlerFactory(commandList, commandFactory);
		
		Parser inputParser = new Parser(lineFactory);
		inputParser.parseFile(inputFile);
		
		
		
	}

}
