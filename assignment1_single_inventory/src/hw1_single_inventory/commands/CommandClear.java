package hw1_single_inventory.commands;

import java.util.ArrayList;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;

public class CommandClear extends Command {

	private ArrayList<DataEntry> m_database;
	private static String s_commandName = "CLEAR";
	
	// Normal overload constructor
	public CommandClear(ArrayList<DataEntry> database, ArrayList<String> outStrings) {
		super(ErrorStates.NO_ERROR, outStrings);
		m_database = database;
	}
	
	// Error constructor
	public CommandClear(ErrorStates error, ArrayList<String> outStrings) {
		super(error, outStrings);
	}

	@Override
	public void execute() {
		if (m_errorState == ErrorStates.NO_ERROR)
		{
			m_database.clear();
			m_outputStrings.add(s_commandName+": OK\n");
		}
		else 
		{
			// Error State is already set, so we just post it
			postCurrentErrorState(s_commandName);
		}

	}

}
