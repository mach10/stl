package uk.co.robshield.stl;

import org.junit.Test;

import uk.co.robshield.stl.domain.DiskFormatCode;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class DiskFormatCodeTest {

	DiskFormatCode undertest;
	
	@Test
	public void itHandles25FPS(){
		undertest = new DiskFormatCode("STL25.01");
		assertThat(undertest.getFramesPerSecond(), is(25));
	}
	
	@Test
	public void itHandles30FPS(){
		undertest = new DiskFormatCode("STL30.01");
		assertThat(undertest.getFramesPerSecond(), is(30));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void itWillRejectInValidCodes(){
		undertest = new DiskFormatCode("STL45.01");
	}
}
