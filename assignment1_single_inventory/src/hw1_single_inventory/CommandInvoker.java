package hw1_single_inventory;

import hw1_single_inventory.commands.Command;

public class CommandInvoker {

	Command m_command;
	public CommandInvoker(Command commandToRun) {
		m_command = commandToRun;
	}

	public void runCommand()
	{
		m_command.execute();
	}
}
