package kim.eren.code_practices.command;

public class TurnOffTv implements Command{
	
	private Television television;

	public TurnOffTv(Television television) {
	
		this.television = television;
	}

	public CommanderResponse execute() {
		return this.television.close();
	}
	
	

}
