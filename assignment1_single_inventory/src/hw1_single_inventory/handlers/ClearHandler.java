package hw1_single_inventory.handlers;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public class ClearHandler extends LineHandler {

	public ClearHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}
	

	@Override
	public void execute(String parseString) {
		ArrayList<String> arguments = splitStrings(parseString);
		// Syntactic checks, not logical. Check file extension as well.
		if (arguments.get(0).equals("CLEAR"))
		{
			if (arguments.size() == 1)
			{
				Command clearCommand = m_commandFactory.getClearOkCommand();
				m_commandList.add(clearCommand);
			}
			else
			{
				// Invalid parameters, we set the error state in the command itself and add to the command list
				Command clearCommand = m_commandFactory.getClearErrorCommand(ErrorStates.WRONG_ARGUMENT_COUNT);
				m_commandList.add(clearCommand);
			}
		}
		else
		{
			// If it isn't a clear instruction, defer to superclass
			super.execute(parseString);
		}
	}
}
