package uk.co.robshield.stl.query;

import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;

import uk.co.robshield.stl.GSIComponent;
import uk.co.robshield.stl.GSIComponentQuery;
import uk.co.robshield.stl.domain.CharacterCode;
import uk.co.robshield.stl.domain.DisplayStandardCode;

public class CharacterCodeQuery implements GSIComponentQuery {
	
	private static final int START = 13;
	private static final int END = 15;

	public GSIComponent find(byte[] src) {
		final byte[] codePageNumber = Arrays.copyOfRange(src, START, END);
		final String cpn = Hex.encodeHexString( codePageNumber );
		System.out.println(">>>>>>>>>>> "+Integer.valueOf(cpn)+" <<<<<<<<<<<<<<<<<<");
		return new CharacterCode(cpn);
	}

}
