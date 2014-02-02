package uk.co.robshield.stl.domain;

/**
 * The GSI Block is the first 1024 bytes
 * of the stl file. 
 * @author robert
 *
 */
public class GSIBlock {

	private  final CodePageNumber codePageNumber;
	private  final DiskFormatCode diskFormatCode;
	private  int displayStandardCode;
	
	
	public GSIBlock(CodePageNumber cpn, DiskFormatCode dfc){
		this.codePageNumber = cpn;
		this.diskFormatCode = dfc;
	}

	public CodePageNumber getCodePageNumber() {
		return codePageNumber;
	}

	public DiskFormatCode getDiskFormatCode() {
		return diskFormatCode;
	}

	public int getDisplayStandardCode() {
		return displayStandardCode;
	}
	
	
}
