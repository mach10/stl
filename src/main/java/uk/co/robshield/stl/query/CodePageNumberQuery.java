package uk.co.robshield.stl.query;

import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;

import uk.co.robshield.stl.GSIComponent;
import uk.co.robshield.stl.GSIComponentQuery;
import uk.co.robshield.stl.domain.CodePageNumber;

public class CodePageNumberQuery implements GSIComponentQuery {

	private static final int CPN_LENGTH = 3;

	public GSIComponent find(byte[] src) {
		//the first 3 bytes are the CodePageNumber
		final byte[] codePageNumber = Arrays.copyOfRange(src, 0, CPN_LENGTH);
		//to get the code, we take chars 2,4 and 6 of the Hex value and concat
		final String cpn = Hex.encodeHexString( codePageNumber );
		StringBuilder b = new StringBuilder(cpn.substring(1, 2));
		b.append(cpn.substring(3,4));
		b.append(cpn.substring(5,6));
		
		return new CodePageNumber(Integer.valueOf(b.toString()));
	}

}
