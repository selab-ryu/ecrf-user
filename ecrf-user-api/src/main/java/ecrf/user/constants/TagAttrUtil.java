package ecrf.user.constants;

public class TagAttrUtil {
	
	// compare menu and targets
	// if not matched then return ' inactive'
	
	public static final int TYPE_MENU = 0;
	public static final int TYPE_ICON = 1;
	
	public static String inactive(String menu, String... targets) {
		String result = " inactive";
		
		for(String target : targets)
			if(menu.equals(target)) result = "";
		
		return result;
	}
	
	public static String inactive(String menu, int type, String... targets) {
		String result = " inactive";
		switch(type) {
			case TYPE_MENU:
				result = " inactive";
				break;
			case TYPE_ICON:
				result = "-inactive";
				break;
			default:
				result = " inactive";
		}
		
		for(String target : targets)
			if(menu.equals(target)) result = "";
		
		return result;
	}
	
	public static String inactive_notMove(String menu, String... targets) {
		String result = " inactive sidebar-not-move";
		
		for(String target : targets)
			if(menu.equals(target)) result = "";
		
		return result;
	}
	
	public static String notMove(String menu, String... targets) {
		String result = " sidebar-not-move";
		
		for(String target : targets)
			if(menu.equals(target)) result = "";
		
		return result;
	}
	
	// if false then return ' inactive'
	public static String inactive(boolean isActive) {
		return isActive ? "" : " inactive";
	}
	
	public static String inactive(boolean isInactive, int type) {
		String result = "";
		switch(type) {
			case TYPE_MENU:
				result = " inactive";
				break;
			case TYPE_ICON:
				result = "-inactive";
				break;
			default:
				result = " inactive";
		}
		
		if(!isInactive) {
			result = "";
		}
		
		return result;
	}
	
	
}
