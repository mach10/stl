package uk.co.robshield.stl.query.gsi;

import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;

import uk.co.robshield.stl.GSIComponent;
import uk.co.robshield.stl.GSIComponentQuery;
import uk.co.robshield.stl.domain.gsi.CodePageNumber;

public class CodePageNumberQuery implements GSIComponentQuery {

	private static final int START = 0;
	private static final int END = 3;

	public GSIComponent find(byte[] src) {
		//the first 3 bytes are the CodePageNumber
		final byte[] codePageNumber = Arrays.copyOfRange(src, START, END);
	
		final String cpn = Hex.encodeHexString( codePageNumber );
		StringBuilder b = new StringBuilder(cpn.substring(1, 2));
		b.append(cpn.substring(3,4));
		b.append(cpn.substring(5,6));
		
		return new CodePageNumber(Integer.valueOf(b.toString()));
	}

}
