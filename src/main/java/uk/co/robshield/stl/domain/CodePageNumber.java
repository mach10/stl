package uk.co.robshield.stl.domain;

import java.util.HashMap;
import java.util.Map;

public class CodePageNumber {

	private static Map<Integer, String> codeMap = new HashMap<Integer,String>();
	private final int code;
	
	static{
		codeMap.put(437, "United States");
		codeMap.put(850, "Multilingual");
		codeMap.put(860, "Portugal");
		codeMap.put(863, "Canada-French");
		codeMap.put(865, "Nordic");
	}
	
	
	public CodePageNumber(int code){
		this.code = code;
		
	}
	
	public String characterSet(){
		if(codeMap.containsKey(this.code)){
			return codeMap.get(this.code);
		}
		return "Country Specific";
	}
}
