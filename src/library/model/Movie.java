package library.model;

import java.util.HashMap;

public class Movie {

	
	private HashMap<String,String> attributes;
	
	public Movie(HashMap<String,String> attributes) {
		this.attributes = attributes;
	}
	
	public Movie() {
		attributes = new HashMap<>();
	}
	
	public void addAttribute(String key, String value) {
		this.attributes.put(key, value);
	}
	
	public String getAttribute(String key) {
		return attributes.get(key);
	}
}
