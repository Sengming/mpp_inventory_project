package hw1_single_inventory;

import java.util.ArrayList;

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
