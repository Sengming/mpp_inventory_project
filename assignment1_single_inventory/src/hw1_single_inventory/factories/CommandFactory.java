package hw1_single_inventory.factories;

import java.util.ArrayList;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.commands.CommandLoad;

public class CommandFactory {

	private ArrayList<DataEntry> m_database;
	private ArrayList<String> m_outStrings;
	
	public CommandFactory(ArrayList<DataEntry> database, ArrayList<String> outStrings) {
		m_database = database;
		m_outStrings = outStrings;
	}

	public Command getLoadOkCommand(String csvurl)
	{
		return new CommandLoad(csvurl, m_database, m_outStrings);
	}
	
	public Command getLoadErrorCommand(ErrorStates error)
	{
		return new CommandLoad(error, m_outStrings);
	}
	
}
