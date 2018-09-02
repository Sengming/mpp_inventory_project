package hw1_single_inventory.commands;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;

public class CommandStatus extends Command {
	
	private ArrayList<DataEntry> m_database;
	private static String s_commandName = "STATUS";
	
	public CommandStatus(ErrorStates error, ArrayList<String> outStrings) {
		super(error, outStrings);
	}

	public CommandStatus(ArrayList<DataEntry> database, ArrayList<String> outStrings) {
		super(ErrorStates.NO_ERROR, outStrings);
		m_database = database;
	}

	@Override
	public void execute() {
		if (m_errorState == ErrorStates.NO_ERROR)
		{
			// Almost same as store, but just write to output file
			SimpleDateFormat dateformatter = new SimpleDateFormat("MM/dd/yyyy");
			m_outputStrings.add(s_commandName+": OK " + m_database.size() + "\n");
			for (DataEntry entry : m_database) {
				m_outputStrings.add(entry.getName()+","+entry.getCompany()+","+dateformatter.format(entry.getDate())+","+entry.getQuantity()+"\n");
			}
		}
		else 
		{
			// Error State is already set, so we just post it
			postCurrentErrorState(s_commandName);
		}
	}

}
