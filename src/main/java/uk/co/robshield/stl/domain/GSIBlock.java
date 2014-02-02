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
	private  final DisplayStandardCode displayStandardCode;
	
	
	public GSIBlock(CodePageNumber cpn, DiskFormatCode dfc, DisplayStandardCode dsc){
		this.codePageNumber = cpn;
		this.diskFormatCode = dfc;
		this.displayStandardCode = dsc;
	}

	public CodePageNumber getCodePageNumber() {
		return codePageNumber;
	}

	public DiskFormatCode getDiskFormatCode() {
		return diskFormatCode;
	}

	public DisplayStandardCode getDisplayStandardCode() {
		return displayStandardCode;
	}

	
	
	
}
