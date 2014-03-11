package uk.co.robshield.stl.query;

import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;

import uk.co.robshield.stl.GSIComponent;
import uk.co.robshield.stl.GSIComponentQuery;
import uk.co.robshield.stl.domain.DisplayStandardCode;

public class DisplayStandardCodeQuery implements GSIComponentQuery<DisplayStandardCode> {

	private static final int START = 12;
	private static final int END = 13;
	
	public DisplayStandardCode find(byte[] src) {
		final byte[] codePageNumber = Arrays.copyOfRange(src, START, END);
		final String cpn = Hex.encodeHexString( codePageNumber );
		return new DisplayStandardCode(cpn);
	}

}
