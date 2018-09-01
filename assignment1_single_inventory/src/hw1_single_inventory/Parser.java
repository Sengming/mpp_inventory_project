package hw1_single_inventory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Parser {

	ArrayList<Command> m_commandList;
	
	public Parser(ArrayList<Command> commandList) {
		m_commandList = commandList;
	}
	
	public void parseFile(File fileToParse)
	{
		// Create a chain of responsibility pattern for parsing file, add more if more commands added:
		LineHandler load = new LoadHandler(m_commandList);
		LineHandler store = new StoreHandler(m_commandList);
		LineHandler clear = new ClearHandler(m_commandList);
		LineHandler add = new AddHandler(m_commandList);
		LineHandler status = new StatusHandler(m_commandList);
		LineHandler buy = new BuyHandler(m_commandList);
		LineHandler sell = new SellHandler(m_commandList);
		LineHandler quanGreater = new QuanGreaterHandler(m_commandList);
		LineHandler quanFewer = new QuanFewerHandler(m_commandList);
		LineHandler quanBetween = new QuanBetweenHandler(m_commandList);
		LineHandler search = new SearchHandler(m_commandList);
		LineHandler errorhandler = new LineErrorHandler(m_commandList);
		
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
