package hw1_single_inventory.commands;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;

public class CommandUnhandledError extends Command {

	// Error State Constructor
	public CommandUnhandledError(ErrorStates error, ArrayList<String> outStrings)
	{
		super(error, outStrings);
	}

	@Override
	public void execute() {
		m_outputStrings.add(m_errorState.toString()+"\n");
	}

}
