package uk.co.robshield.stl.query.gsi;

import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;

import uk.co.robshield.stl.GSIComponent;
import uk.co.robshield.stl.GSIComponentQuery;
import uk.co.robshield.stl.domain.gsi.LanguageCode;

public class LanguageCodeQuery implements GSIComponentQuery {

	/*
	 * zero index
	 */
	private static final int START = 14;
	/*
	 * 1 index
	 */
	private static final int END = 16;

	public GSIComponent find(byte[] src) {
		final byte[] bytes = Arrays.copyOfRange(src, START, END);
		return new LanguageCode( new String(bytes));
	}
}
