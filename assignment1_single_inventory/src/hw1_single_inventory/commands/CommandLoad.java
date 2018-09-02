package hw1_single_inventory.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;

public class CommandLoad extends Command {

	private String m_csvUrl;
	private ArrayList<DataEntry> m_database;
	private static String s_commandName = "LOAD";
	
	// Normal Constructor
	public CommandLoad(String csvurl, ArrayList<DataEntry> database, ArrayList<String> outStrings) {
		super(ErrorStates.NO_ERROR, outStrings);
		m_csvUrl = csvurl;
		m_database = database;
	}
	
	// Error State Constructor
	public CommandLoad(ErrorStates error, ArrayList<String> outStrings)
	{
		super(error, outStrings);
		m_csvUrl = null;
	}
	

	@Override
	public void execute() {
		if (m_errorState == ErrorStates.NO_ERROR)
		{
			// Read lines from csv file into database
			try 
			{
				BufferedReader reader = new BufferedReader(new FileReader(m_csvUrl));
				String line = reader.readLine();
				int numberOfEntries = 0;
				while (line != null)
				{
					String[] csvData = line.split(",");
					checkLineAndUpdateDb(csvData);
					++numberOfEntries;
					line = reader.readLine();
				}
				
				m_outputStrings.add(s_commandName+": OK " + numberOfEntries + "\n");
				reader.close();
			} 
			catch (FileNotFoundException e)
			{
				postErrorState(s_commandName, ErrorStates.FILE_NOT_FOUND);
			}
			catch (IOException e) 
			{
				
			}
		}
		else 
		{
			// Error State is already set, so we just post it
			postCurrentErrorState(s_commandName);
		}

	}
	
	// Helper function
	private void checkLineAndUpdateDb(String[] splitline)
	{
		// First, clear db of existing entries
		m_database.clear();

		if (splitline.length == 3)
		{
			DataEntry entry = new DataEntry();
			entry.setName(splitline[0]);
			entry.setCompany(splitline[1]);
			if(!entry.setDate(splitline[2]))
			{
				postErrorState(s_commandName, ErrorStates.INVALID_DATE);
			}
			entry.setQuantity(Integer.parseInt(splitline[3]));
		}
		else
		{
			// If we assume correct shouldn't have issues here
		}
		
	}

}
