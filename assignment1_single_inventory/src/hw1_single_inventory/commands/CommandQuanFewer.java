package hw1_single_inventory.commands;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;

public class CommandQuanFewer extends Command {
	
	private ArrayList<DataEntry> m_database;
	private ArrayList<String> m_tempList;
	private static String s_commandName = "QUAN";
	private int m_comparator;
	
	public CommandQuanFewer(ErrorStates error, ArrayList<String> outStrings) {
		super(error, outStrings);
		m_database = null;
		m_comparator = 0;
		m_tempList = null;
	}

	public CommandQuanFewer(ArrayList<DataEntry> database, ArrayList<String> outStrings, int comparator) {
		super(ErrorStates.NO_ERROR, outStrings);
		m_database = database;
		m_comparator = comparator;
		m_tempList = new ArrayList<String>();
	}

	@Override
	public void execute() {
		if (m_errorState == ErrorStates.NO_ERROR)
		{
			SimpleDateFormat dateformatter = new SimpleDateFormat("MM/dd/yyyy");
			int numberOfHits = 0;
			for (DataEntry entry : m_database) {
				// Check for entry quantities between range
				int entryQuantity = entry.getQuantity();
				if (entryQuantity < m_comparator)
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
