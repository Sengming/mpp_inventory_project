package hw1_single_inventory.commands;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;

public class CommandUnhandledError extends Command {

	private String m_parseString;
	// Error State Constructor
	public CommandUnhandledError(ErrorStates error, ArrayList<String> outStrings, String parseString)
	{
		super(error, outStrings);
		m_parseString = parseString;
	}

	@Override
	public void execute() {
		m_outputStrings.add(m_parseString+": ERROR "+m_errorState.toString()+"\n");
	}

}
