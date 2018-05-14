package kim.eren.code_practices.command;

public class Commander {
	
	private Command[] command = new Command[2];

	public Commander() {
	
		Television television = new Television();
		command[1] = new TurnOnTv(television);
		command[0] = new TurnOffTv(television);
	}
	
	
	public CommanderResponse tusla(int tus) {
		if(tus>command.length || tus<0) {
			throw new RuntimeException();
		}
		return command[tus].execute();
	}
	
	
}
