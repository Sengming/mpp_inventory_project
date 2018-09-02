package hw1_single_inventory.handlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public class AddHandler extends LineHandler {

	public AddHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}

	@Override
	public void execute(String parseString) {
		ArrayList<String> arguments = splitStrings(parseString);
		// Syntactic checks, not logical. 
		if (arguments.get(0).equals("ADD"))
		{
			if (arguments.size() == 4)
			{
				try {
					SimpleDateFormat formatParser = new SimpleDateFormat("MM/dd/yyyy");
					Date date = new Date();
					date = formatParser.parse(arguments.get(3));
					Command addCommand = m_commandFactory.getAddOkCommand(arguments.get(1), arguments.get(2), date);
					m_commandList.add(addCommand);
				}
				catch (ParseException e) {
					// Wronte date format
					Command addCommand = m_commandFactory.getAddErrorCommand(ErrorStates.INVALID_DATE);
					m_commandList.add(addCommand);
				}
			}
			else
			{
				// Invalid parameters, we set the error state in the command itself and add to the command list
				Command addCommand = m_commandFactory.getAddErrorCommand(ErrorStates.WRONG_ARGUMENT_COUNT);
				m_commandList.add(addCommand);
			}
		}
		else
		{
			// If it isn't a load instruction, defer to superclass
			super.execute(parseString);
		}
	}

	
}
