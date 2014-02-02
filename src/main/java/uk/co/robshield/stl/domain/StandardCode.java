package uk.co.robshield.stl.domain;

public enum StandardCode {
    
	OPEN_SUBTITLING(0){
		
		public String getDisplayStandard(){
			return "Open subtitling";
		}
	},
	
	LEVEL_1_TELETEXT(1){
		
		public String getDisplayStandard(){
			return "Level-1 teletext";
		}
	},
	
	LEVEL_2_TELETEXT(2){
		
		public String getDisplayStandard(){
			return "Level-2 teletext";
		}
	},
    
	UNDEFINED(-1){
		public String getDisplayStandard(){
			return "undefined";
		}
	};
	
	StandardCode(int dsc){
		this.dsc = dsc;
	}
	private int dsc;
	
	public int getDsc() {
		return this.dsc;
	}
	
	
}
