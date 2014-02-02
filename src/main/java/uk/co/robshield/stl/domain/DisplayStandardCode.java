package uk.co.robshield.stl.domain;

import java.util.HashMap;
import java.util.Map;

public class DisplayStandardCode {
	
	private final static Map<Integer,String> codeStandards = new HashMap<Integer,String>();
	private final int dsc;
	
	static{
		codeStandards.put(new Integer(-1), "Undefined");
		codeStandards.put(new Integer(0), "Open subtitling");
		codeStandards.put(new Integer(1), "Level-1 teletext");
		codeStandards.put(new Integer(2), "Level-2 teletext");
	}
	
	public DisplayStandardCode(int dsc){
		if(dsc < -1 || dsc > 2) throw new IllegalArgumentException("code must be between -1 and 2");
		this.dsc = dsc;
	}
	
	public String getCodeStandard(){
		return codeStandards.get(this.dsc);
	}

	public int getDsc() {
		return dsc;
	}

	
}
