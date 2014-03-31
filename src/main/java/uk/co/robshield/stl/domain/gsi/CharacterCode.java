package uk.co.robshield.stl.domain.gsi;

import java.util.HashMap;
import java.util.Map;

import uk.co.robshield.stl.GSIComponent;

public class CharacterCode extends GSIComponent{
	
	private static Map<String, String> codeMap = new HashMap<String, String>();
	private final String code;
	static {
		codeMap.put("3030", "00");
		codeMap.put("3031", "01");
		codeMap.put("3032", "02");
		codeMap.put("3033", "03");
		codeMap.put("3034", "4");
	}
	
	
	public CharacterCode(String code){
		this.code = code;
	}
	//@todo make a factory returning CharacterCode objects which contain all the data
	public String getCode(){
		return codeMap.get(this.code);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterCode other = (CharacterCode) obj;
		return other.getCode().equals(this.getCode());
	}
	
	

}
