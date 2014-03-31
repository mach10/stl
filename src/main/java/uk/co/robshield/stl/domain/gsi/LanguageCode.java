package uk.co.robshield.stl.domain.gsi;

import uk.co.robshield.stl.GSIComponent;

public class LanguageCode extends GSIComponent{

	private final String code;

	public LanguageCode(String code){
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(false == obj instanceof LanguageCode)return false;
		LanguageCode that = (LanguageCode)obj;
		return this.getCode().equals(that.getCode());
	}

	@Override
	public int hashCode() {
		return this.getCode().hashCode();
	}

	@Override
	public String toString() {
		return this.getCode();
	}
	
}
