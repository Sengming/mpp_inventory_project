package hw1_single_inventory.handlers;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public class StoreHandler extends LineHandler {

	public StoreHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}

	@Override
	public void execute(String parseString) {
		ArrayList<String> arguments = splitStrings(parseString);
		// Syntactic checks, not logical. Check file extension as well.
		if (arguments.get(0).equals("STORE"))
		{
			if (arguments.size() == 2)
			{
				String regex = "^.*\\.(csv)$";
				if (arguments.get(1).matches(regex))
				{
					// Passes CSV url to the load command after passing checks and ship it
					Command storeCommand = m_commandFactory.getStoreOkCommand(arguments.get(1));
					m_commandList.add(storeCommand);
				}
			}
			else
			{
				// Invalid parameters, we set the error state in the command itself and add to the command list
				Command storeCommand = m_commandFactory.getStoreErrorCommand(ErrorStates.WRONG_ARGUMENT_COUNT);
				m_commandList.add(storeCommand);
			}
		}
		else
		{
			// If it isn't a store instruction, defer to superclass
			super.execute(parseString);
		}
	}
}
