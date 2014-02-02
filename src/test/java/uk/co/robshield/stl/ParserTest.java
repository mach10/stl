package uk.co.robshield.stl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.HexDump;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

import uk.co.robshield.stl.domain.CodePageNumber;
import uk.co.robshield.stl.domain.DisplayStandardCode;
import uk.co.robshield.stl.domain.StlFile;

public class ParserTest {

	public static final String FILENAME = "stlFile.stl";
	private URL rawSTL;
	private Path stlInput;
	private Parser undertest;

	@Before
	public void setUp() {
		rawSTL = ClassLoader.getSystemResource(FILENAME);
		stlInput = new File(rawSTL.getPath()).toPath();
		undertest = new Parser(stlInput);
	}

	@Test
	public void itGeneratesTheGSIBlock() throws Exception {
		final StlFile stl = undertest.parseToStlFormat();
		assertNotNull(stl.getGsiBlock());
	}

	@Test
	public void itGeneratesACorrectCodePageNumber() throws Exception {
		final CodePageNumber codePageNumber = undertest.parseToStlFormat()
				.getGsiBlock().getCodePageNumber();
		assertThat(codePageNumber.characterSet(), is("Multilingual"));
	}

	@Test
	public void itGeneratesACorrectDisplayStandardCode() throws Exception {
		final DisplayStandardCode dsc = undertest.parseToStlFormat()
				.getGsiBlock().getDisplayStandardCode();
		DisplayStandardCode expected = new DisplayStandardCode(0);
		assertThat(dsc, is(expected));
	}

}
