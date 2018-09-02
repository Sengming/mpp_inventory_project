package hw1_single_inventory;

import java.util.ArrayList;

public class CommandFactory {

	private ArrayList<DataEntry> m_database;
	
	public CommandFactory(ArrayList<DataEntry> database) {
		m_database = database;
	}

	public Command getLoadCommand(String csvurl)
	{
		return new CommandLoad(csvurl, m_database);
	}
}
