package hw1_single_inventory.commands;

import java.util.ArrayList;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;

public class CommandBuy extends Command {

	private ArrayList<DataEntry> m_database;
	private static String s_commandName = "BUY";
	
	public CommandBuy(ErrorStates error, ArrayList<String> outStrings) {
		super(error, outStrings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		if (m_errorState == ErrorStates.NO_ERROR)
		{
			//TODO Fill
		}
		else 
		{
			// Error State is already set, so we just post it
			postCurrentErrorState(s_commandName);
		}
	}

}
