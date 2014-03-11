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

import uk.co.robshield.stl.domain.CharacterCode;
import uk.co.robshield.stl.domain.CodePageNumber;
import uk.co.robshield.stl.domain.DiskFormatCode;
import uk.co.robshield.stl.domain.DisplayStandardCode;
import uk.co.robshield.stl.domain.StlFile;
import uk.co.robshield.stl.query.CharacterCodeQuery;
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
		final CodePageNumber codePageNumber = (CodePageNumber) undertest.findGSIComponent(new CodePageNumberQuery());
		assertThat(codePageNumber.characterSet(), is("Multilingual"));
	}
	
	@Test
	public void itFindsTheDiskFormatCode() throws Exception {
		final DiskFormatCode dfc = (DiskFormatCode) undertest.findGSIComponent( new DiskFormatCodeQuery() );
		assertThat(dfc.getFramesPerSecond(), is(25));
	}

	@Test
	public void itGeneratesACorrectDisplayStandardCode() throws Exception {
		final DisplayStandardCode dsc = (DisplayStandardCode) undertest.findGSIComponent( new DisplayStandardCodeQuery() );
		DisplayStandardCode expected = new DisplayStandardCode(0);
		assertThat(dsc, is(expected));
	}
	
	@Test
	public void itGeneratesTheCorrectCharacterCode() throws Exception {
		final CharacterCode cc = (CharacterCode) undertest.findGSIComponent(new CharacterCodeQuery());
		CharacterCode expected = new CharacterCode("3030");
		assertThat(cc, is(expected));
	}

}
