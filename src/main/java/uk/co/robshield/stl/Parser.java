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
import uk.co.robshield.stl.domain.GSIBlock;
import uk.co.robshield.stl.domain.StlFile;

public class Parser {

	private static final int EBU_LENGTH = 448;
	private static final int GSI_LENGTH = 1024;
	private static final int CPN_LENGTH = 3;
	private final Path stlFile;
	
	public Parser(Path path){
		this.stlFile = path;
	}
	
	public StlFile parseToStlFormat() throws IOException{
		//byte[] data = new byte[(int) this.stlFile.toFile().length()];
		//first pull out the GSI Block
		return new StlFile(parseGSIBlock());
		
		
	}

	private GSIBlock parseGSIBlock() throws FileNotFoundException, IOException {
		final byte[] gsiBlock = new byte[GSI_LENGTH];
		
		final InputStream in = new FileInputStream(this.stlFile.toFile());
		in.read(gsiBlock);
		
		//we have dumped the entire GSI Block into out
		//into gsiBlock
		//EBU defined block is first 448 bytes of the GSI Block
	    //final byte[] ebuBlock = Arrays.copyOfRange(gsiBlock, 0, EBU_LENGTH);
		
		
		
		
		return new GSIBlock( parseCodePageNumber(gsiBlock), parseDiskFormatCode(gsiBlock));
	}

	private CodePageNumber parseCodePageNumber(final byte[] gsiBlock) {
		//the first 3 bytes are the CodePageNumber
		final byte[] codePageNumber = Arrays.copyOfRange(gsiBlock, 0, CPN_LENGTH);
		//to get the code, we take chars 2,4 and 6 of the Hex value and concat
		final String cpn = Hex.encodeHexString( codePageNumber );
		StringBuilder b = new StringBuilder(cpn.substring(1, 2));
		b.append(cpn.substring(3,4));
		b.append(cpn.substring(5,6));
		
		return new CodePageNumber(Integer.valueOf(b.toString()));
	}
	
	private DiskFormatCode parseDiskFormatCode(byte[] src){
		final byte[] dfc = Arrays.copyOfRange(src, 3, 11);
		return new DiskFormatCode(new String(dfc));
	}
	
	public Path getStlFile() {
		File file;
		synchronized(stlFile){
			file = stlFile.toFile();
		}
		return file.toPath();
	}
	
	
}
