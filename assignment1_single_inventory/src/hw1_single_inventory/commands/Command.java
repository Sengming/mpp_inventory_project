package hw1_single_inventory.commands;

import java.util.ArrayList;

import hw1_single_inventory.ErrorStates;

public abstract class Command {
	
	protected ErrorStates m_errorState;
	protected ArrayList<String> m_outputStrings;
	
	protected Command(ErrorStates error, ArrayList<String> outStrings)
	{
		m_errorState = error;
		m_outputStrings = outStrings;
	}
	
	public abstract void execute();
	
	protected void postCurrentErrorState(String commandName)
	{
		// Construct error message 
		m_outputStrings.add(commandName + ": ERROR " + m_errorState.toString() + "\n");
	}
	
	protected void postErrorState(String commandName, ErrorStates error)
	{
		// Construct error message 
		m_errorState = error;
		postCurrentErrorState(commandName);
	}
}
