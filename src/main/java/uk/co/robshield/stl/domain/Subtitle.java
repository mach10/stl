package uk.co.robshield.stl.domain;

import org.joda.time.DateTime;

public class Subtitle {

	private final DateTime start;
	private final DateTime end;
	private final String speech;
	
	public Subtitle(DateTime start, DateTime end, String speech){
		assert(end.isAfter(start));
		this.start = start;
		this.end = end;
		this.speech = speech;
	}
	
	

	public DateTime getStart() {
		return start;
	}



	public DateTime getEnd() {
		return end;
	}



	public String getSpeech() {
		return speech;
	}



	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Subtitle))return false;
		Subtitle other = (Subtitle)obj;
		if(other.getStart().equals(this.start))return false;
		if(other.getEnd().equals(this.end))return false;
		return other.getSpeech().equals(this.speech);
	}

	@Override
	public int hashCode() {
		return this.start.hashCode()+this.end.hashCode()+this.speech.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("Subtitle{start: ")
		.append(this.start.toString())
		.append(", end: ")
		.append(this.end.toString())
		.append(", speech: ");
		if(this.speech.length()>10){
		  b.append(this.speech.substring(0,10));	
		}else{
			b.append(this.speech);
		}
		b.append("}");
		return b.toString();
	}
	
	
}
