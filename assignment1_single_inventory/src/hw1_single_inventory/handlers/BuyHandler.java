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
		ArrayList<String> arguments = splitStrings(parseString);
		// Syntactic checks, not logical. 
		if (arguments.get(0).equals("BUY"))
		{
			if (arguments.size() == 4)
			{
				try {					
					int[] buyAmount = new int[1];
					buyAmount[0] = Integer.parseInt(arguments.get(3));
					if (buyAmount[0] >= 1)
					{
						Command buyCommand = m_commandFactory.getBuyOkCommand(arguments.get(1), arguments.get(2), buyAmount[0]);
						m_commandList.add(buyCommand);
					}
					else
					{
						Command buyCommand = m_commandFactory.getBuyErrorCommand(ErrorStates.INVALID_QUANTITY);
						m_commandList.add(buyCommand);
					}
				}
				catch (NumberFormatException e) {
					Command buyCommand = m_commandFactory.getBuyErrorCommand(ErrorStates.INVALID_QUANTITY);
					m_commandList.add(buyCommand);
				}
			}
			else
			{
				// Invalid parameters, we set the error state in the command itself and add to the command list
				Command buyCommand = m_commandFactory.getBuyErrorCommand(ErrorStates.WRONG_ARGUMENT_COUNT);
				m_commandList.add(buyCommand);
			}
		}
		else
		{
			// If it isn't a buy instruction, defer to superclass
			super.execute(parseString);
		}
	}
}
