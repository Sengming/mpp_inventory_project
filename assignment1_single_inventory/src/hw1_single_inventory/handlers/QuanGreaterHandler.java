package hw1_single_inventory.handlers;

import java.util.ArrayList;

import hw1_single_inventory.commands.Command;
import hw1_single_inventory.factories.CommandFactory;

public class QuanGreaterHandler extends LineHandler{

	public QuanGreaterHandler(ArrayList<Command> commandList, CommandFactory commandFactory) {
		super(commandList, commandFactory);
	}
	
	@Override
	public void execute(String parseString) {
		// TODO Auto-generated method stub
		super.execute(parseString);
	}
}
