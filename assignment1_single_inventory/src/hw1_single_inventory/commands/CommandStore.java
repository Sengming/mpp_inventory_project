package hw1_single_inventory.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;

public class CommandStore extends Command {

	private File m_outputCsvFile;
	private ArrayList<DataEntry> m_database;
	private static String s_commandName = "STORE";
	
	public CommandStore(ErrorStates error, ArrayList<String> outStrings) {
		super(error, outStrings);
		// TODO Auto-generated constructor stub
	}

	public CommandStore(String csvurl, ArrayList<DataEntry> database, ArrayList<String> outStrings) {
		super(ErrorStates.NO_ERROR, outStrings);
		m_outputCsvFile = new File(csvurl);
		m_database = database;
	}

	@Override
	public void execute() {
		if (m_errorState == ErrorStates.NO_ERROR)
		{
			// Write lines from database into csv
			try {
				m_outputCsvFile.createNewFile();
				FileWriter m_fileWriter = new FileWriter(m_outputCsvFile);
				SimpleDateFormat dateformatter = new SimpleDateFormat("MM/dd/yyyy");
				int numberOfEntries=0;
				for (DataEntry entry : m_database) {
					m_fileWriter.write(entry.getName()+","+entry.getCompany()+","+dateformatter.format(entry.getDate())+","+entry.getQuantity()+"\n");
					++numberOfEntries;
				}
				m_outputStrings.add(s_commandName+": OK " + numberOfEntries + "\n");
				m_fileWriter.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		else 
		{
			// Error State is already set, so we just post it
			postCurrentErrorState(s_commandName);
		}

	}

}
