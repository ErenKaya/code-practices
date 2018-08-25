package kim.eren.code_practices.tpoint.command;

public class Television {
	
	public CommanderResponse open() {
		return new CommanderResponse("1","Television is opened.");
	}
	
	public CommanderResponse close() {
		return new CommanderResponse("0","Television is closed.");
	}

}
