package hw1_single_inventory.factories;

import java.util.ArrayList;
import java.util.Date;

import hw1_single_inventory.DataEntry;
import hw1_single_inventory.ErrorStates;
import hw1_single_inventory.commands.Command;
import hw1_single_inventory.commands.CommandAdd;
import hw1_single_inventory.commands.CommandBuy;
import hw1_single_inventory.commands.CommandClear;
import hw1_single_inventory.commands.CommandLoad;
import hw1_single_inventory.commands.CommandQuanBetween;
import hw1_single_inventory.commands.CommandQuanFewer;
import hw1_single_inventory.commands.CommandQuanGreater;
import hw1_single_inventory.commands.CommandSearch;
import hw1_single_inventory.commands.CommandSell;
import hw1_single_inventory.commands.CommandStatus;
import hw1_single_inventory.commands.CommandStore;
import hw1_single_inventory.commands.CommandUnhandledError;

public class CommandFactory {

	private ArrayList<DataEntry> m_database;
	private ArrayList<String> m_outStrings;
	
	public CommandFactory(ArrayList<DataEntry> database, ArrayList<String> outStrings) {
		m_database = database;
		m_outStrings = outStrings;
	}

	public Command getLoadOkCommand(String csvurl)
	{
		return new CommandLoad(csvurl, m_database, m_outStrings);
	}
	
	public Command getLoadErrorCommand(ErrorStates error)
	{
		return new CommandLoad(error, m_outStrings);
	}
	
	public Command getStoreOkCommand(String csvurl)
	{
		return new CommandStore(csvurl, m_database, m_outStrings);
	}
	
	public Command getStoreErrorCommand(ErrorStates error)
	{
		return new CommandStore(error, m_outStrings);
	}
	
	public Command getUnhandledCommand(ErrorStates error)
	{
		return new CommandUnhandledError(error, m_outStrings);
	}
	
	public Command getClearOkCommand()
	{
		return new CommandClear(m_database, m_outStrings);
	}
	
	public Command getClearErrorCommand(ErrorStates error)
	{
		return new CommandClear(error, m_outStrings);
	}
	
	public Command getAddOkCommand(String name, String company, Date releaseDate)
	{
		return new CommandAdd(m_database, m_outStrings, name, company, releaseDate);
	}
	
	public Command getAddErrorCommand(ErrorStates error)
	{
		return new CommandAdd(error, m_outStrings);
	}
	
	public Command getStatusOkCommand()
	{
		return new CommandStatus(m_database, m_outStrings);
	}
	
	public Command getStatusErrorCommand(ErrorStates error)
	{
		return new CommandStatus(error, m_outStrings);
	}
	
	public Command getBuyOkCommand(String name, String company, int quantity)
	{
		return new CommandBuy(m_database, m_outStrings, name, company, quantity);
	}
	
	public Command getBuyErrorCommand(ErrorStates error)
	{
		return new CommandBuy(error, m_outStrings);
	}
	
	public Command getSellOkCommand(String name, String company, int quantity)
	{
		return new CommandSell(m_database, m_outStrings, name, company, quantity);
	}
	
	public Command getSellErrorCommand(ErrorStates error)
	{
		return new CommandSell(error, m_outStrings);
	}
	
	public Command getQuanGreaterOkCommand(int comparator)
	{
		return new CommandQuanGreater(m_database, m_outStrings, comparator);
	}
	
	public Command getQuanGreaterErrorCommand(ErrorStates error)
	{
		return new CommandQuanGreater(error, m_outStrings);
	}
	
	public Command getQuanFewerOkCommand(int comparator)
	{
		return new CommandQuanFewer(m_database, m_outStrings, comparator);
	}
	
	public Command getQuanFewerErrorCommand(ErrorStates error)
	{
		return new CommandQuanFewer(error, m_outStrings);
	}
	
	public Command getQuanBetweenOkCommand(int low, int high)
	{
		return new CommandQuanBetween(m_database, m_outStrings, low, high);
	}
	
	public Command getQuanBetweenErrorCommand(ErrorStates error)
	{
		return new CommandQuanBetween(error, m_outStrings);
	}
	
	public Command getSearchOkCommand(String needle)
	{
		return new CommandSearch(m_database, m_outStrings, needle);
	}
	
	public Command getSearchErrorCommand(ErrorStates error)
	{
		return new CommandSearch(error, m_outStrings);
	}
	
}
