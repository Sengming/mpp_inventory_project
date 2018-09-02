package hw1_single_inventory.handlers;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public class BuyHandler extends LineHandler {

	public BuyHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}

	@Override
	public void execute(String parseString) {
//		ArrayList<String> arguments = splitStrings(parseString);
//		// Syntactic checks, not logical. Check file extension as well.
//		if (arguments.get(0).equals("LOAD"))
//		{
//			if (arguments.size() == 2)
//			{
//				String regex = "^.*\\.(csv)$";
//				if (arguments.get(1).matches(regex))
//				{
//					// Passes CSV url to the load command after passing checks and ship it
//					Command loadCommand = m_commandFactory.getLoadOkCommand(arguments.get(1));
//					m_commandList.add(loadCommand);
//				}
//			}
//			else
//			{
//				// Invalid parameters, we set the error state in the command itself and add to the command list
//				Command loadCommand = m_commandFactory.getLoadErrorCommand(ErrorStates.WRONG_ARGUMENT_COUNT);
//				m_commandList.add(loadCommand);
//			}
//		}
//		else
//		{
//			// If it isn't a load instruction, defer to superclass
//			super.execute(parseString);
//		}
		super.execute(parseString);
	}
}
