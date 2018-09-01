package hw1_single_inventory;

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
