package uk.co.robshield.stl.query.gsi;

import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;

import uk.co.robshield.stl.GSIComponent;
import uk.co.robshield.stl.GSIComponentQuery;
import uk.co.robshield.stl.domain.gsi.CharacterCode;
import uk.co.robshield.stl.domain.gsi.DisplayStandardCode;

public class CharacterCodeQuery implements GSIComponentQuery {
	
	private static final int START = 12;
	private static final int END = 14;

	public GSIComponent find(byte[] src) {
		final byte[] codePageNumber = Arrays.copyOfRange(src, START, END);
		String x = new String(codePageNumber);
		System.out.println(x);
		final String cpn = Hex.encodeHexString( codePageNumber );
		return new CharacterCode(cpn);
	}

}
