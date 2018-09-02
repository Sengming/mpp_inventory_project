package hw1_single_inventory.handlers;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public class QuanFewerHandler extends LineHandler{

	public QuanFewerHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}
	

	@Override
	public void execute(String parseString) {
		ArrayList<String> arguments = splitStrings(parseString);
		// Syntactic checks, not logical.
		if (arguments.get(0).equals("QUAN") && arguments.get(1).equals("FEWER"))
		{
			if (arguments.size() == 3)
			{
				try
				{
					int[] range = new int[1];
					range[0] = Integer.parseInt(arguments.get(2));
					Command quanFewerCommand = m_commandFactory.getQuanFewerOkCommand(range[0]);
					m_commandList.add(quanFewerCommand);
				}
				catch (NumberFormatException e)
				{
					Command quanFewerCommand = m_commandFactory.getQuanFewerErrorCommand(ErrorStates.INVALID_ARGUMENT);
					m_commandList.add(quanFewerCommand);
				}
			}
			else
			{
				// Invalid parameters, we set the error state in the command itself and add to the command list
				Command quanBetweenCommand = m_commandFactory.getQuanBetweenErrorCommand(ErrorStates.WRONG_ARGUMENT_COUNT);
				m_commandList.add(quanBetweenCommand);
			}
		}
		else
		{
			// If it isn't a quan fewer instruction, defer to superclass
			super.execute(parseString);
		}
	}
}
