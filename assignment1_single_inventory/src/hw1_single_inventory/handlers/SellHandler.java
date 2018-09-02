package hw1_single_inventory.handlers;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public class SellHandler extends LineHandler{

	public SellHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}

	@Override
	public void execute(String parseString) {
		ArrayList<String> arguments = splitStrings(parseString);
		// Syntactic checks, not logical. 
		if (arguments.get(0).equals("SELL"))
		{
			if (arguments.size() == 4)
			{
				try {					
					int[] sellAmount = new int[1];
					sellAmount[0] = Integer.parseInt(arguments.get(3));
					if (sellAmount[0] >= 1)
					{
						Command sellCommand = m_commandFactory.getSellOkCommand(arguments.get(1), arguments.get(2), sellAmount[0]);
						m_commandList.add(sellCommand);
					}
					else
					{
						Command sellCommand = m_commandFactory.getSellErrorCommand(ErrorStates.INVALID_QUANTITY);
						m_commandList.add(sellCommand);
					}
				}
				catch (NumberFormatException e) {
					Command sellCommand = m_commandFactory.getSellErrorCommand(ErrorStates.INVALID_ARGUMENT);
					m_commandList.add(sellCommand);
				}
			}
			else
			{
				// Invalid parameters, we set the error state in the command itself and add to the command list
				Command sellCommand = m_commandFactory.getSellErrorCommand(ErrorStates.WRONG_ARGUMENT_COUNT);
				m_commandList.add(sellCommand);
			}
		}
		else
		{
			// If it isn't a sell instruction, defer to superclass
			super.execute(parseString);
		}
	}
}
