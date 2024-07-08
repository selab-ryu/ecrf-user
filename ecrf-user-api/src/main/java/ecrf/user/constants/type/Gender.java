package ecrf.user.constants.type;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
	MALE("Male", 0),
	FEMALE("Female", 1);
	
	private String fullValue;
	private int numValue;
	
	private static Map map = new HashMap<>();
	
	private Gender(String full, int num) {
		this.fullValue = full;
		this.numValue = num;
	}
	
	static {
		for(Gender gender : Gender.values()) {
			map.put(gender.numValue, gender);
		}
 	}
	
	public String getFull() {
		return this.fullValue;
	}
	
	public int getNum() {
		return this.numValue;
	}
	
	public static Gender valueOf(int num) {
		return (Gender) map.get(num);
	}
}
