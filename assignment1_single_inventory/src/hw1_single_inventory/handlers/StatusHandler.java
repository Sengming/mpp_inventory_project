package hw1_single_inventory.handlers;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public class StatusHandler extends LineHandler {

	public StatusHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}

	@Override
	public void execute(String parseString) {
		ArrayList<String> arguments = splitStrings(parseString);
		// Syntactic checks, not logical.
		if (arguments.get(0).equals("STATUS"))
		{
			if (arguments.size() == 1)
			{
				Command statusCommand = m_commandFactory.getStatusOkCommand();
				m_commandList.add(statusCommand);
			}
			else
			{
				// Invalid parameters, we set the error state in the command itself and add to the command list
				Command statusCommand = m_commandFactory.getStatusErrorCommand(ErrorStates.WRONG_ARGUMENT_COUNT);
				m_commandList.add(statusCommand);
			}
		}
		else
		{
			// If it isn't a load instruction, defer to superclass
			super.execute(parseString);
		}
	}
}
