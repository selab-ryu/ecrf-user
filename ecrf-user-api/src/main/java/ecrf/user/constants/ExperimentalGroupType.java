package ecrf.user.constants;

import java.util.HashMap;
import java.util.Map;

public enum ExperimentalGroupType {
	EXPERIMENTAL_GROUP("Experimental Group", "EXP.", 0),
	CONTROL_GROUP("Control Group", "CONTROL.", 1),
	NOT_ASSIGN("Not Assign", "NOT", 2);
	
	private String fullValue;
	private String abbrValue;
	private int numValue;
	
	private static Map map = new HashMap<>();
	
	private ExperimentalGroupType(String full, String abbr, int num) {
		this.fullValue = full;
		this.abbrValue = abbr;
		this.numValue = num;
	}
	
	static {
		for(ExperimentalGroupType expGroup : ExperimentalGroupType.values()) {
			map.put(expGroup.numValue, expGroup);
		}
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
	
	public static ExperimentalGroupType valueOf(int num) {
		return (ExperimentalGroupType) map.get(num);
	}
}