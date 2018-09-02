package hw1_single_inventory.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;

public class CommandLoad implements Command {

	private String m_csvUrl;
	private ErrorStates m_errorState;
	private ArrayList<String> m_outputStrings;
	
	// Normal Constructor
	public CommandLoad(String csvurl, ArrayList<DataEntry> database, ArrayList<String> outStrings) {
		m_csvUrl = csvurl;
		m_errorState = ErrorStates.NO_ERROR;
		m_outputStrings = outStrings;
	}
	
	// Error State Constructor
	public CommandLoad(ErrorStates error, ArrayList<String> outStrings)
	{
		m_errorState = error;
		m_csvUrl = null;
		m_outputStrings = outStrings;
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
				while (line != null)
				{
					// Execute chain head and delegate filtering/handling to chain
	
					line = reader.readLine();
				}
				
				reader.close();
			} 
			catch (IOException e) 
			{
				
			}
		}
		else 
		{
			m_outputStrings.add("Load Error!!");
		}

	}

}
