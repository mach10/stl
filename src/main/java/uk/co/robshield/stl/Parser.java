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
	
	public DiskFormatCode findDiskFormatCode() throws Exception{
		final byte[] gsiBlock = new byte[GSI_LENGTH];
		this.in.read(gsiBlock);
		GSIComponentQuery<DiskFormatCode> query = new GSIComponentQuery<DiskFormatCode>(){
			public DiskFormatCode find(byte[] src) {
				final byte[] dfc = Arrays.copyOfRange(src, 3, 11);
				return new DiskFormatCode(new String(dfc));
			}
			
		};
		return query.find(gsiBlock);
	}
	
	public DisplayStandardCode findDisplayStandardCode() throws Exception {
		final byte[] gsiBlock = new byte[GSI_LENGTH];
		this.in.read(gsiBlock);
		
		GSIComponentQuery<DisplayStandardCode> query = new GSIComponentQuery<DisplayStandardCode>(){

			public DisplayStandardCode find(byte[] src) {
				final byte[] codePageNumber = Arrays.copyOfRange(src, 12, 13);
				final String cpn = Hex.encodeHexString( codePageNumber );
				return new DisplayStandardCode(cpn);
			}
			
		};
		
		return query.find(gsiBlock);
	}
	
	public CodePageNumber findCodePageNumber() throws Exception {
		final byte[] gsiBlock = new byte[GSI_LENGTH];
		this.in.read(gsiBlock);
		GSIComponentQuery<CodePageNumber> query = new GSIComponentQuery<CodePageNumber>(){

			public CodePageNumber find(byte[] src) {
				//the first 3 bytes are the CodePageNumber
				final byte[] codePageNumber = Arrays.copyOfRange(src, 0, CPN_LENGTH);
			
				final String cpn = Hex.encodeHexString( codePageNumber );
				StringBuilder b = new StringBuilder(cpn.substring(1, 2));
				b.append(cpn.substring(3,4)).append(cpn.substring(5,6));
				
				return new CodePageNumber(Integer.valueOf(b.toString()));
			}
			
		};
		return query.find(gsiBlock);
	}
	
	
}
