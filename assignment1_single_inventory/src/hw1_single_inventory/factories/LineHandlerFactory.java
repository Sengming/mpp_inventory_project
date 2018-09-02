package hw1_single_inventory.factories;

import java.util.ArrayList;

import hw1_single_inventory.commands.Command;
import hw1_single_inventory.handlers.AddHandler;
import hw1_single_inventory.handlers.BuyHandler;
import hw1_single_inventory.handlers.ClearHandler;
import hw1_single_inventory.handlers.LineErrorHandler;
import hw1_single_inventory.handlers.LineHandler;
import hw1_single_inventory.handlers.LoadHandler;
import hw1_single_inventory.handlers.QuanBetweenHandler;
import hw1_single_inventory.handlers.QuanFewerHandler;
import hw1_single_inventory.handlers.QuanGreaterHandler;
import hw1_single_inventory.handlers.SearchHandler;
import hw1_single_inventory.handlers.SellHandler;
import hw1_single_inventory.handlers.StatusHandler;
import hw1_single_inventory.handlers.StoreHandler;

public class LineHandlerFactory {

	private ArrayList<Command> m_commandList;
	private CommandFactory m_commandFactory;
	
	public LineHandlerFactory(ArrayList<Command> commandList, CommandFactory commandFactory) {
		m_commandList = commandList;
		m_commandFactory = commandFactory;
	}
	
	public LineHandler getLoadHandler()
	{
		return new LoadHandler(m_commandList, m_commandFactory);
	}
	
	public LineHandler getStoreHandler()
	{
		return new StoreHandler(m_commandList, m_commandFactory);
	}

	public LineHandler getClearHandler()
	{
		return new ClearHandler(m_commandList, m_commandFactory);
	}
	
	public LineHandler getAddHandler()
	{
		return new AddHandler(m_commandList, m_commandFactory);
	}
	
	public LineHandler getStatusHandler()
	{
		return new StatusHandler(m_commandList, m_commandFactory);
	}
	
	public LineHandler getBuyHandler()
	{
		return new BuyHandler(m_commandList, m_commandFactory);
	}
	
	public LineHandler getSellHandler()
	{
		return new SellHandler(m_commandList, m_commandFactory);
	}
	
	public LineHandler getQuanGreaterHandler()
	{
		return new QuanGreaterHandler(m_commandList, m_commandFactory);
	}
	
	public LineHandler getQuanFewerHandler()
	{
		return new QuanFewerHandler(m_commandList, m_commandFactory);
	}
	
	public LineHandler getQuanBetweenHandler()
	{
		return new QuanBetweenHandler(m_commandList, m_commandFactory);
	}
	
	public LineHandler getSearchHandler()
	{
		return new SearchHandler(m_commandList, m_commandFactory);
	}
	
	public LineHandler getErrorHandler()
	{
		return new LineErrorHandler(m_commandList, m_commandFactory);
	}
}
