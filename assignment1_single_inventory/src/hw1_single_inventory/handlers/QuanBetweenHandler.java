package hw1_single_inventory.handlers;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public class QuanBetweenHandler extends LineHandler{

	public QuanBetweenHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}
	

	@Override
	public void execute(String parseString) {
		ArrayList<String> arguments = splitStrings(parseString);
		// Syntactic checks, not logical.
		if (arguments.get(0).equals("QUAN") && arguments.get(1).equals("BETWEEN"))
		{
			if (arguments.size() == 4)
			{
				try
				{
					int[] range = new int[2];
					range[0] = Integer.parseInt(arguments.get(2));
					range[1] = Integer.parseInt(arguments.get(3));
					Command quanBetweenCommand = m_commandFactory.getQuanBetweenOkCommand(range[0], range[1]);
					m_commandList.add(quanBetweenCommand);
				}
				catch (NumberFormatException e)
				{
					Command quanBetweenCommand = m_commandFactory.getQuanBetweenErrorCommand(ErrorStates.INVALID_ARGUMENT);
					m_commandList.add(quanBetweenCommand);
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
			// If it isn't a quan between instruction, defer to superclass
			super.execute(parseString);
		}
	}
}
