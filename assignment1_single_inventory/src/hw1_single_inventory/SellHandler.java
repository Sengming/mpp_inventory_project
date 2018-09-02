package hw1_single_inventory;

import java.util.ArrayList;

public class SellHandler extends LineHandler{

	public SellHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}

	@Override
	public void execute(String parseString) {
		// TODO Auto-generated method stub
		super.execute(parseString);
	}
}
