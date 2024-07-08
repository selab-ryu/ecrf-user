package ecrf.user.constants.type;

import java.util.HashMap;
import java.util.Map;

public enum ResearcherPosition {
	PI("PI", "pi", 0),
	RESEARCHER("Researcher", "researcher", 1);
	
	private String fullValue;
	private String lowerValue;
	private int numValue;
	
	private static Map map = new HashMap<>();
	
	private ResearcherPosition(String full, String lower, int num) {
		this.fullValue = full;
		this.lowerValue = lower;
		this.numValue = num;
	}
	
	static {
		for(ResearcherPosition position : ResearcherPosition.values()) {
			map.put(position.numValue, position);
		}
 	}
	
	public String getFull() {
		return this.fullValue;
	}
	
	public String getLower() {
		return this.lowerValue;
	}
	
	public int getNum() {
		return this.numValue;
	}
	
	public static ResearcherPosition valueOf(int num) {
		return (ResearcherPosition) map.get(num);
	}
	
	public static ResearcherPosition findByLower(String lower) {
		for(ResearcherPosition position : ResearcherPosition.values()) {
			if(position.getLower().equals(lower)) {
				return position;
			}
		}
		return null;
	}
}
