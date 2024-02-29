package ecrf.user.constants;

public enum ExperimentalGroup {
	EXPERIMENTAL_GROUP("Experimental Group", "EXP.", 0),
	CONTROL_GROUP("Control Group", "CONTROL.", 1),
	NOT_ASSIGN("Not Assign", "NOT", 2);
	
	private String fullValue;
	private String abbrValue;
	private int numValue;
	
	private ExperimentalGroup(String full, String abbr, int num) {
		this.fullValue = full;
		this.abbrValue = abbr;
		this.numValue = num;
	}
	
	public String getFullString() {
		return fullValue;
	}
	
	public String getAbbrString() {
		return abbrValue;
	}
	
	public int getNum() {
		return numValue;
	}
}