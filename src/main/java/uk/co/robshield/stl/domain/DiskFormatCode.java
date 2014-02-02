package uk.co.robshield.stl.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiskFormatCode {

	
	private String code;
	private final Pattern pattern = Pattern.compile("STL([23][05])\\.01");
	private final Matcher matcher;

	public DiskFormatCode(String code){
		this.code = code;
		matcher = pattern.matcher(this.code);
		final boolean valid = matcher.find();
		if(!valid)throw new IllegalArgumentException("invalid code");
	}

	public int getFramesPerSecond() {
		return Integer.valueOf(matcher.group(1));
	}
	
	
}
