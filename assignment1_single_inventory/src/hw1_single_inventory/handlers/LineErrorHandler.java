package hw1_single_inventory.handlers;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public class LineErrorHandler extends LineHandler{

	public LineErrorHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}
	

	@Override
	public void execute(String parseString) {
		// We shouldn't fall in here unless we don't currently handle the command
		Command unhandled = m_commandFactory.getUnhandledCommand(ErrorStates.UNKNOWN_COMMAND);
		m_commandList.add(unhandled);
	}
}
