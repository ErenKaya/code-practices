package kim.eren.code_practices.tpoint.command;

public class CommanderResponse {
	
	private String code;
	private String details;
	
	public CommanderResponse(String code, String details) {
		super();
		this.code = code;
		this.details = details;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
