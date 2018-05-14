package kim.eren.code_practices.command;

public class TurnOnTv implements Command{

	private Television television;

	public TurnOnTv(Television television) {
	
		this.television = television;
	}

	public CommanderResponse execute() {
		return this.television.open();
	}
	
	
}
