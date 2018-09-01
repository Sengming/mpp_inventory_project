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
		
		File inputFile = new File("/home/sengming/VT/MPP_5510/eclipse-workspace/assignment1_single_inventory/src/hw1_single_inventory/in.txt");
		Parser inputParser = new Parser(commandList);
		inputParser.parseFile(inputFile);
		
		
		
	}

}
