package hw1_single_inventory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import hw1_single_inventory.factories.LineHandlerFactory;
import hw1_single_inventory.handlers.LineHandler;



public class Parser {
	LineHandlerFactory m_lineFactory;
	
	public Parser(LineHandlerFactory lineFactory) {
		m_lineFactory = lineFactory;
	}
	
	public void parseFile(File fileToParse)
	{
		// Create a chain of responsibility pattern for parsing file, add more if more commands added:
		LineHandler load = m_lineFactory.getLoadHandler();
		LineHandler store = m_lineFactory.getStoreHandler();
		LineHandler clear = m_lineFactory.getClearHandler();
		LineHandler add = m_lineFactory.getAddHandler();
		LineHandler status = m_lineFactory.getStatusHandler();
		LineHandler buy = m_lineFactory.getBuyHandler();
		LineHandler sell = m_lineFactory.getSellHandler();
		LineHandler quanGreater = m_lineFactory.getQuanGreaterHandler();
		LineHandler quanFewer = m_lineFactory.getQuanFewerHandler();
		LineHandler quanBetween = m_lineFactory.getQuanBetweenHandler();
		LineHandler search = m_lineFactory.getSearchHandler();
		LineHandler errorhandler = m_lineFactory.getErrorHandler();
		
		load.add(store);
		store.add(clear);
		clear.add(add);
		add.add(status);
		status.add(buy);
		buy.add(sell);
		sell.add(quanGreater);
		quanGreater.add(quanFewer);
		quanFewer.add(quanBetween);
		quanBetween.add(search);
		search.add(errorhandler);
		
		// Read lines from file and feed into the head of chain
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileToParse));
			String line = reader.readLine();
			while (line != null)
			{
				// Execute chain head and delegate filtering/handling to chain
				load.execute(line);
				line = reader.readLine();
			}
			
			reader.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
