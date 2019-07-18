package zhong.JJS.A1612.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class AllCollection {
	private List<String> listElement;
	private String[] arrayElement;
	private Set<String> setElement;
	private Map<String, String> mapElement;
	private Properties properElement;
	
	public List<String> getListElement() {
		return listElement;
	}

	public void setListElement(List<String> listElement) {
		this.listElement = listElement;
	}

	public String[] getArrayElement() {
		return arrayElement;
	}

	public void setArrayElement(String[] arrayElement) {
		this.arrayElement = arrayElement;
	}

	public Set<String> getSetElement() {
		return setElement;
	}

	public void setSetElement(Set<String> setElement) {
		this.setElement = setElement;
	}

	public Map<String, String> getMapElement() {
		return mapElement;
	}

	public void setMapElement(Map<String, String> mapElement) {
		this.mapElement = mapElement;
	}

	public Properties getProperElement() {
		return properElement;
	}

	public void setProperElement(Properties properElement) {
		this.properElement = properElement;
	}

	@Override
	public String toString() {
		String strContent = null;
		for(String str:arrayElement) {
			strContent = str+",";
		}
		return "listElement:"+this.listElement+"\nsetElement:"+this.setElement+"\nmap:"+this.mapElement+"\nproperElement:"
					+this.properElement+"\narray:"+strContent;
	}
	
	
	
	
	
	
	
}
