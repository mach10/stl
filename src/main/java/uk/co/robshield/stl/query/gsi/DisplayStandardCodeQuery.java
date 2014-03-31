package uk.co.robshield.stl.query.gsi;

import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;

import uk.co.robshield.stl.GSIComponent;
import uk.co.robshield.stl.GSIComponentQuery;
import uk.co.robshield.stl.domain.gsi.DisplayStandardCode;

public class DisplayStandardCodeQuery implements GSIComponentQuery {

	private static final int START = 12;
	private static final int END = 13;
	
	public GSIComponent find(byte[] src) {
		final byte[] bytes = Arrays.copyOfRange(src, START, END);
		final String cpn = Hex.encodeHexString( bytes );
		return new DisplayStandardCode(cpn);
	}

}
