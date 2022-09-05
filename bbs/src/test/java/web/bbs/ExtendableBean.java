package web.bbs;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class ExtendableBean {
	public String name;
	public String attr;
	private Map<String, String> properties;
	
	public ExtendableBean() {
		properties = new HashMap<String, String>();
	}
	
	public ExtendableBean(final String name, final String attr) {
		this.name = name;
		this.attr = attr;
		properties = new HashMap<String, String>();
	}
	
	public ExtendableBean(final String name) {
		this.name = name;		
		properties = new HashMap<String, String>();
	}
	
	@JsonAnySetter
	public void add(final String key, final String value) {
		properties.put(key, value);		
	}
	
	@JsonAnyGetter
	public Map<String, String> getProperties(){
		return properties;
	}
	
}
