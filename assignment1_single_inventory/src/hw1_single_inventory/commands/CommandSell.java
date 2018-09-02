package hw1_single_inventory.commands;

import java.util.ArrayList;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;

public class CommandSell extends Command {

	private ArrayList<DataEntry> m_database;
	private static String s_commandName = "SELL";
	private String m_name;
	private String m_company;
	private int m_quantity;
	
	
	public CommandSell(ErrorStates error, ArrayList<String> outStrings) {
		super(error, outStrings);
		m_database = null;
		m_name = null;
		m_company = null;
		m_quantity = 0;
	}

	public CommandSell(ArrayList<DataEntry> database, ArrayList<String> outStrings, String name, String company,
			int quantity) 
	{
		super(ErrorStates.NO_ERROR, outStrings);
		m_database = database;
		m_name = name;
		m_company = company;
		m_quantity = quantity;
	}

	@Override
	public void execute() {
		if (m_errorState == ErrorStates.NO_ERROR)
		{
			for (DataEntry entry : m_database) {
				// Check if entry exists. Strip the string of double quotes first before comparing as database is stored without double quotes
				if ((entry.getName().equals(m_name.replace("\"", ""))) && (entry.getCompany().equals(m_company.replace("\"", ""))))
				{
					try 
					{
						entry.subtractFromQuantity(m_quantity);
						m_outputStrings.add(s_commandName+": OK "+m_name+" "+m_company+" "+entry.getQuantity()+"\n");
					}
					catch (IllegalArgumentException e)
					{
						if (e.getMessage().equals("CSQMTS"))
						{
							postErrorState(s_commandName, ErrorStates.CANNOT_SELL_QUANTITY_MORE_THAN_STOCK);
						}
						else if (e.getMessage().equals("IQ"))
						{
							postErrorState(s_commandName, ErrorStates.INVALID_QUANTITY);							
						}
					}
					return;
				}
			}
			
			// Come here if entry not found:
			postErrorState(s_commandName, ErrorStates.CANNOT_SELL_BEFORE_ADD);
		}
		else 
		{
			// Error State is already set, so we just post it
			postCurrentErrorState(s_commandName);
		}

	}

}
