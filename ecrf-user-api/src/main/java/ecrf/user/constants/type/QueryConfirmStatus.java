package ecrf.user.constants.type;

import java.util.HashMap;
import java.util.Map;

public enum QueryConfirmStatus {	
	PROCESSING("processing", 0),
	REFUSE("refuse", 1),
	ACCEPT("accept", 2);
	
	private String fullValue;
	private int numValue;
	
	private static Map map = new HashMap<>();
	
	private QueryConfirmStatus(String full, int num) {
		this.fullValue = full;
		this.numValue = num;
	}
	
	static {
		for(QueryConfirmStatus status : QueryConfirmStatus.values()) {
			map.put(status.numValue, status);
		}
	}
	
	public String getFull() {
		return this.fullValue;
	}
	
	public int getNum() {
		return this.numValue;
	}
	
	public static QueryConfirmStatus valueOf(int num) {
		return (QueryConfirmStatus) map.get(num);
	}	
}
