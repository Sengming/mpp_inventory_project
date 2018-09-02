package hw1_single_inventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CommandLoad implements Command {

	private String m_csvUrl;
	public CommandLoad(String csvurl, ArrayList<DataEntry> database) {
		m_csvUrl = csvurl;
	}

	@Override
	public void execute() {
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

}
