package hw1_single_inventory.handlers;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public class SearchHandler extends LineHandler{

	public SearchHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}

	@Override
	public void execute(String parseString) {
		ArrayList<String> arguments = splitStrings(parseString);
		// Syntactic checks, not logical. Check file extension as well.
		if (arguments.get(0).equals("SEARCH"))
		{
			if (arguments.size() == 2)
			{
				Command searchCommand = m_commandFactory.getSearchOkCommand(arguments.get(1));
				m_commandList.add(searchCommand);
			}
			else
			{
				// Invalid parameters, we set the error state in the command itself and add to the command list
				Command searchCommand = m_commandFactory.getSearchErrorCommand(ErrorStates.WRONG_ARGUMENT_COUNT);
				m_commandList.add(searchCommand);
			}
		}
		else
		{
			// If it isn't a search instruction, defer to superclass
			super.execute(parseString);
		}
	}
}
