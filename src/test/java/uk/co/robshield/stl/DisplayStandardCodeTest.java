package uk.co.robshield.stl;

import org.junit.Test;

import uk.co.robshield.stl.domain.DisplayStandardCode;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DisplayStandardCodeTest {

	@Test(expected = IllegalArgumentException.class)
	public void itShouldRejectInvalidNumbersWhenLower(){
		DisplayStandardCode invalid = new DisplayStandardCode(-2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void itShouldRejectInvalidNumbersWhenHigher(){
		DisplayStandardCode invalid = new DisplayStandardCode(3);
	}
	
	@Test
	public void itReturnsCorrectDisplayStandards(){
		DisplayStandardCode undefined = new DisplayStandardCode(-1);
		DisplayStandardCode open = new DisplayStandardCode(0);
		DisplayStandardCode level1 = new DisplayStandardCode(1);
		DisplayStandardCode level2 = new DisplayStandardCode(2);
		
		assertThat(undefined.getCodeStandard(), is("Undefined"));
		assertThat(open.getCodeStandard(), is("Open subtitling"));
		assertThat(level1.getCodeStandard(), is("Level-1 teletext"));
		assertThat(level2.getCodeStandard(), is("Level-2 teletext"));
	}
}
