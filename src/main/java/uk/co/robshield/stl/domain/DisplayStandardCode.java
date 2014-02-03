package uk.co.robshield.stl.domain;

import java.util.HashMap;
import java.util.Map;

import uk.co.robshield.stl.GSIComponent;

public class DisplayStandardCode extends GSIComponent{
	
	private final static Map<Integer,String> codeStandards = new HashMap<Integer,String>();
	private final static Map<String,Integer> hexMap = new HashMap<String,Integer>();
	
	private final int dsc;
	
	static{
		codeStandards.put(new Integer(-1), "Undefined");
		codeStandards.put(new Integer(0), "Open subtitling");
		codeStandards.put(new Integer(1), "Level-1 teletext");
		codeStandards.put(new Integer(2), "Level-2 teletext");
		hexMap.put("20", -1 );
		hexMap.put("30", 0 );
		hexMap.put("31", 1 );
		hexMap.put("32", 2 );
	}
	
	public DisplayStandardCode(int dsc){
		if(dsc < -1 || dsc > 2) throw new IllegalArgumentException("code must be between -1 and 2");
		this.dsc = dsc;
	}
	
	public DisplayStandardCode(String hex){
		this(hexMap.get(hex));
	}
	
	public String getCodeStandard(){
		return codeStandards.get(this.dsc);
	}

	public int getDsc() {
		return dsc;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof DisplayStandardCode))return false;
		DisplayStandardCode other = (DisplayStandardCode) obj;
		return this.dsc == other.getDsc();
	}

	@Override
	public int hashCode() {
		return this.getCodeStandard().hashCode()+this.dsc;
	}

	@Override
	public String toString() {
		return new StringBuilder(this.dsc)
		.append(": ")
		.append(this.getCodeStandard())
		.toString();
	}
	
	

	
}
