package ecrf.user.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum CRFStatus {
	NOT_PUBLISHED("Not Published", 0),
	IN_PROGRESS("In Progress", 1),
	COMPLETE("Complete", 2);
	
	private String fullValue;
	private int numValue;
	
	private static Map map = new HashMap<>();
	
	private CRFStatus(String full, int num) {
		this.fullValue = full;
		this.numValue = num;
	}
	
	static {
		for (CRFStatus status : CRFStatus.values()) {
			map.put(status.numValue, status);
		}
	}
	
	public String getFull() {
		return this.fullValue;
	}
	
	public int getNum() {
		return this.numValue;
	}
	
	public static CRFStatus valueOf(int num) {
		return (CRFStatus) map.get(num);
	}
}
