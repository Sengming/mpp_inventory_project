package hw1_single_inventory;

import java.util.ArrayList;

public class LoadHandler extends LineHandler {

	public LoadHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}
	
	@Override
	public void execute(String parseString) {
		ArrayList<String> arguments = splitStrings(parseString);
		// Syntactic checks, not logical. Check file extension as well.
		if (arguments.size() == 2)
		{
			if (arguments.get(0).equals("LOAD"))
			{
				String regex = "^.*\\.(csv)$";
				if (arguments.get(1).matches(regex))
				{
					// Passes CSV url to the load command after passing checks and ship it
					Command loadCommand = m_commandFactory.getLoadCommand(arguments.get(1));
					m_commandList.add(loadCommand);
				}
				
			}
			else
			{
				// If it isn't a load instruction, defer to superclass
				super.execute(parseString);
			}
		}
		
		
	}
}
