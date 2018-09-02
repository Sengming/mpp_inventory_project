package hw1_single_inventory.commands;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;

public class CommandQuanBetween extends Command {

	private ArrayList<DataEntry> m_database;
	private ArrayList<String> m_tempList;
	private static String s_commandName = "QUAN";
	private int m_low;
	private int m_high;
	
	public CommandQuanBetween(ErrorStates error, ArrayList<String> outStrings) {
		super(error, outStrings);
		m_database = null;
		m_tempList = null;
		m_low = 0;
		m_high = 0;
	}

	public CommandQuanBetween(ArrayList<DataEntry> database, ArrayList<String> outStrings, int low, int high) {
		super(ErrorStates.NO_ERROR, outStrings);
		m_database = database;
		m_tempList = new ArrayList<String>();
		m_low = low;
		m_high = high;
	}

	@Override
	public void execute() {
		if (m_errorState == ErrorStates.NO_ERROR)
		{
			try
			{
				sanityCheck(m_low, m_high);
				SimpleDateFormat dateformatter = new SimpleDateFormat("MM/dd/yyyy");
				int numberOfHits = 0;
				for (DataEntry entry : m_database) {
					// Check for entry quantities between range
					int entryQuantity = entry.getQuantity();
					if ((entryQuantity > m_low) && (entryQuantity < m_high))
					{
						++numberOfHits;
						m_tempList.add(entry.getName()+","+entry.getCompany()+","+dateformatter.format(entry.getDate())+","+entry.getQuantity()+"\n");
					}
				}
				m_outputStrings.add(s_commandName+": OK " + numberOfHits + "\n");
				m_outputStrings.addAll(m_tempList);
			}
			catch (IllegalArgumentException e)
			{
				postErrorState(s_commandName, ErrorStates.INVALID_QUANTITY);
			}
		}
		else 
		{
			// Error State is already set, so we just post it
			postCurrentErrorState(s_commandName);
		}

	}
	
	private void sanityCheck(int low, int high)
	{
		if (low >= high || low < 0 || high < 0)
		{
			throw new IllegalArgumentException();
		}
	}

}
