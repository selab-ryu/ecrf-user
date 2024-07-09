package ecrf.user.constants.type;

import java.util.HashMap;
import java.util.Map;

public enum QueryType {	
	AUTO("Auto", 0),
	MINIMUM_VALUE_ERROR("Minimum Value Error", 1),
	MAXIMUM_VALUE_ERROR("Maximum Value Error", 2),
	OUT_OF_RANGE("Out of Range", 3),
	MISSING_FLOATING_POINT("Missing Floating Point", 4),
	UNMATCH_FLOATING_POINT_LENGTH("Unmatch Floating Point Length", 5);
	
	private String fullValue;
	private int numValue;
	
	private static Map map = new HashMap<>();
	
	private QueryType(String full, int num) {
		this.fullValue = full;
		this.numValue = num;
	}
	
	static {
		for(QueryType type : QueryType.values()) {
			map.put(type.numValue, type);
		}
	}
	
	public String getFull() {
		return this.fullValue;
	}
	
	public int getNum() {
		return this.numValue;
	}
	
	public static QueryType valueOf(int num) {
		return (QueryType) map.get(num);
	}
}
