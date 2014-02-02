package uk.co.robshield.stl.domain;

import java.util.LinkedList;
import java.util.List;

public class StlFile {

	private GSIBlock gsiBlock;
	private List<Subtitle> subtitles = new LinkedList<Subtitle>();
	
	public StlFile(GSIBlock gsiBlock){
		this.gsiBlock = gsiBlock;
	}

	public GSIBlock getGsiBlock() {
		return gsiBlock;
	}

	public List<Subtitle> getSubtitles() {
		return subtitles;
	}
}
