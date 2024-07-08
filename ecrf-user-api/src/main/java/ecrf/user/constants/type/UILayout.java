package ecrf.user.constants.type;

import java.util.HashMap;
import java.util.Map;

public enum UILayout {
	TABLE("table", 0),
	VERTICAL("vertical", 1),
	STATIONX("station-x", 2);
	
	private String fullValue;
	private int numValue;
	
	private static Map map = new HashMap<>();
	
	private UILayout(String full, int num) {
		this.fullValue = full;
		this.numValue = num;
	}
	
	static {
		for(UILayout layout : UILayout.values()) {
			map.put(layout.numValue, layout);
		}
	}
	
	public String getFull() {
		return this.fullValue;
	}
	
	public int getNum() {
		return this.numValue;
	}
	
	public static UILayout valueOf(int num) {
		return (UILayout) map.get(num);
	}
}
