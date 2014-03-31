package uk.co.robshield.stl.query.gsi;

import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;

import uk.co.robshield.stl.GSIComponent;
import uk.co.robshield.stl.GSIComponentQuery;
import uk.co.robshield.stl.domain.gsi.OriginalProgrammeTitle;

public class OriginalProgrammeTitleQuery implements GSIComponentQuery {

	private static final int START = 16;
	private static final int END = 48;
	
	public GSIComponent find(byte[] src) {
		final byte[] codePageNumber = Arrays.copyOfRange(src, START, END);
		final String title = new String(codePageNumber);//@todo implement language code
		return new OriginalProgrammeTitle(title);
	}
}
