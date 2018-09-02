/**
 * 
 */
package hw1_single_inventory;

import java.io.File;
import java.util.ArrayList;

import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;
import hw1_single_inventory.factories.LineHandlerFactory;

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
		ArrayList<String> outStrings = new ArrayList<String>();
		
		File inputFile = new File("in.txt");
		File outputFile = new File("out.txt");
		
		CommandFactory commandFactory = new CommandFactory(database, outStrings);
		LineHandlerFactory lineFactory = new LineHandlerFactory(commandList, commandFactory);
		
		Parser inputParser = new Parser(lineFactory);
		inputParser.parseFile(inputFile);
				
		// Execute all commands in list - I'm assuming this will be made multithreaded in future
		// Maybe some sort of producer/consumer problem. For now this will do.
		for (Command command : commandList) {
			command.execute();
		}
		
		Writer outputWriter = new Writer(outputFile, outStrings);
		outputWriter.writeAllStrings();
		
		
	}

}
