package uk.co.robshield.stl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

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
