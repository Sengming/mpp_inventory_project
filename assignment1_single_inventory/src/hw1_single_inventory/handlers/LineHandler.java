package hw1_single_inventory.handlers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public abstract class LineHandler {

	//Members:
	private LineHandler m_nextInChain;
	protected ArrayList<Command> m_commandList;
	protected CommandFactory m_commandFactory;
	
	public LineHandler(ArrayList<Command> commandList, CommandFactory commandFactory)
	{
		m_nextInChain = null;
		m_commandList = commandList;
		m_commandFactory = commandFactory;
	}
	
	public void add(LineHandler next)
	{
		m_nextInChain = next;
	}
	
    public void execute(String parseString) 
    {
    	if (m_nextInChain != null)
    	{
    		m_nextInChain.execute(parseString);
    	}
    	else
    	{
    		// We shouldn't get here. The final link in chain should be a catch-all for errors
    	}
    }
    
    protected ArrayList<String> splitStrings(String inputString)
    {
        String regex = "\"([^\"]*)\"|(\\S+)";
        ArrayList<String> splitStrings = new ArrayList<String>();
        Matcher match = Pattern.compile(regex).matcher(inputString);
        while (match.find()) 
        {
        	splitStrings.add(match.group());
        }
        
        return splitStrings;
    }
}
