package uk.co.robshield.stl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Path;

import org.junit.Before;
import org.junit.Test;

import uk.co.robshield.stl.domain.CodePageNumber;
import uk.co.robshield.stl.domain.DiskFormatCode;
import uk.co.robshield.stl.domain.DisplayStandardCode;
import uk.co.robshield.stl.domain.StlFile;
import uk.co.robshield.stl.query.CodePageNumberQuery;
import uk.co.robshield.stl.query.DiskFormatCodeQuery;
import uk.co.robshield.stl.query.DisplayStandardCodeQuery;

public class ParserTest {

	public static final String FILENAME = "stlFile.stl";
	private URL rawSTL;
	private Path stlInput;
	private Parser undertest;

	@Before
	public void setUp() throws FileNotFoundException {
		rawSTL = ClassLoader.getSystemResource(FILENAME);
		stlInput = new File(rawSTL.getPath()).toPath();
		undertest = new Parser(stlInput);
	}

	@Test
	public void itGeneratesACorrectCodePageNumber() throws Exception {
		final CodePageNumber codePageNumber = undertest.findCodePageNumber();
		assertThat(codePageNumber.characterSet(), is("Multilingual"));
	}
	
	@Test
	public void itFindsTheDiskFormatCode() throws Exception {
		final DiskFormatCode dfc = undertest.findDiskFormatCode();
		assertThat(dfc.getFramesPerSecond(), is(25));
	}

	@Test
	public void itGeneratesACorrectDisplayStandardCode() throws Exception {
		final DisplayStandardCode dsc = undertest.findDisplayStandardCode();
		DisplayStandardCode expected = new DisplayStandardCode(0);
		assertThat(dsc, is(expected));
	}

}
