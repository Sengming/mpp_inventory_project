package hw1_single_inventory;

import java.util.ArrayList;

public abstract class LineHandler {

	//Members:
	private LineHandler m_nextInChain;
	protected ArrayList<Command> m_commandList;
	
	public LineHandler(ArrayList<Command> commandList)
	{
		m_nextInChain = null;
		m_commandList = commandList;
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
    
}
