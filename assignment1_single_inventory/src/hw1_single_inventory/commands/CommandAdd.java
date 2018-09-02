package hw1_single_inventory.commands;

import java.util.ArrayList;
import java.util.Date;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;

public class CommandAdd extends Command {
	
	private ArrayList<DataEntry> m_database;
	private static String s_commandName = "ADD";
	private String m_name;
	private String m_company;
	private Date m_date;
	
	// Normal overload constructor
	public CommandAdd(ArrayList<DataEntry> database, ArrayList<String> outStrings, String name, String company, Date date) {
		super(ErrorStates.NO_ERROR, outStrings);
		m_database = database;
		m_name = name;
		m_company = company;
		m_date = date;
	}
	
	// Error overload constructor
	public CommandAdd(ErrorStates error, ArrayList<String> outStrings) {
		super(error, outStrings);
		m_database = null;
		m_name = null;
		m_company = null;
		m_date = null;
	}

	@Override
	public void execute() {
		if (m_errorState == ErrorStates.NO_ERROR)
		{
			for (DataEntry entry : m_database) {
				// Check for duplicate entry. Strip the string of double quotes first before comparing as database is stored without double quotes
				if ((entry.getName().equals(m_name.replace("\"", ""))) && (entry.getCompany().equals(m_company.replace("\"", ""))))
				{
					postErrorState(s_commandName, ErrorStates.DUPLICATE_ENTRY);
					return;
				}
			}
			
			// All good, no duplicates, add entry quantity is 0 since we are just adding the entry, without buy/sell
			DataEntry entryToAdd = new DataEntry(m_name, m_company, m_date, 0);
			m_database.add(entryToAdd);
			m_outputStrings.add(s_commandName+": OK "+m_name+" "+m_company+"\n");
		}
		else 
		{
			// Error State is already set, so we just post it
			postCurrentErrorState(s_commandName);
		}
	}

}
