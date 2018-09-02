package hw1_single_inventory.commands;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;

public class CommandSearch extends Command {

	private ArrayList<DataEntry> m_database;
	private ArrayList<String> m_tempList;
	private static String s_commandName = "SEARCH";
	private String m_needle;
	
	public CommandSearch(ErrorStates error, ArrayList<String> outStrings) {
		super(error, outStrings);
		m_needle = null;
		m_tempList = null;
		m_database = null;
	}

	public CommandSearch(ArrayList<DataEntry> database, ArrayList<String> outStrings, String needle) 
	{
		super(ErrorStates.NO_ERROR, outStrings);
		m_needle = needle;
		m_tempList = new ArrayList<String>();
		m_database = database;
	}

	@Override
	public void execute() {
		if (m_errorState == ErrorStates.NO_ERROR)
		{
			SimpleDateFormat dateformatter = new SimpleDateFormat("MM/dd/yyyy");
			int numberOfHits = 0;
			for (DataEntry entry : m_database) {
				// If the name or company contains the needle, consider that a hit
				if (entry.getName().contains(m_needle) || entry.getCompany().contains(m_needle))
				{
					++numberOfHits;
					m_tempList.add(entry.getName()+","+entry.getCompany()+","+dateformatter.format(entry.getDate())+","+entry.getQuantity()+"\n");
				}
			}
			m_outputStrings.add(s_commandName+": OK " + numberOfHits + "\n");
			m_outputStrings.addAll(m_tempList);
		}
		else 
		{
			// Error State is already set, so we just post it
			postCurrentErrorState(s_commandName);
		}

	}

}
