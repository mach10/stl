package uk.co.robshield.stl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.HexDump;

import uk.co.robshield.stl.domain.CodePageNumber;
import uk.co.robshield.stl.domain.DiskFormatCode;
import uk.co.robshield.stl.domain.DisplayStandardCode;
import uk.co.robshield.stl.domain.GSIBlock;
import uk.co.robshield.stl.domain.StlFile;
import uk.co.robshield.stl.query.CodePageNumberQuery;

public class Parser {

	private static final int EBU_LENGTH = 448;
	private static final int GSI_LENGTH = 1024;
	private static final int CPN_LENGTH = 3;
	private final Path stlFile;
	private final InputStream in;
	
	public Parser(Path path) throws FileNotFoundException{
		this.stlFile = path;
		in = new FileInputStream(this.stlFile.toFile());
	}
	
	public Path getStlFile() {
		File file;
		synchronized(stlFile){
			file = stlFile.toFile();
		}
		return file.toPath();
	}

	public GSIComponent findGSIComponent(
			GSIComponentQuery query) throws IOException {
		final byte[] gsiBlock = new byte[GSI_LENGTH];
		in.read(gsiBlock);
		return query.find(gsiBlock);
	}
	
	
}
