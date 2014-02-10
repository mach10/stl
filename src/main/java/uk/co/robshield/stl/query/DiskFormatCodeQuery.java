package uk.co.robshield.stl.query;


import java.util.Arrays;

import uk.co.robshield.stl.GSIComponent;
import uk.co.robshield.stl.GSIComponentQuery;
import uk.co.robshield.stl.domain.DiskFormatCode;

public class DiskFormatCodeQuery implements GSIComponentQuery{
	
	private static final int START = 3;
	private static final int END = 11;

	public GSIComponent find(byte[] src) {
		final byte[] dfc = Arrays.copyOfRange(src, START, END);
		return new DiskFormatCode(new String(dfc));
	}

}
