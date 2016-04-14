package org.hc;

import java.util.HashMap;

public class ingredient extends HashMap<String, String> implements Comparable<ingredient>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String enummer;
	public int color;
	
	public static String KEY_NAME = "name";
	public static String KEY_ENUMMER = "enummer";

	public ingredient(String name, String enummer, int color){
		this.name = name;
		this.enummer = enummer;
		this.color = color;
	}
	@Override
	public String get(Object k) {
		String key = (String) k;
		if (KEY_NAME.equals(key))
			return name;
		else if (KEY_ENUMMER.equals(key))
			return enummer;
		return null;
	}
	public int compareTo(ingredient another) {
        String name2 = another.name;
        String name = this.name;

        if (name.toLowerCase() == name2.toLowerCase()) {
                return 0;
        } else if (name.toLowerCase().compareTo(name2.toLowerCase()) > 0)
                return 1;
        else
                return -1;
	}
}
