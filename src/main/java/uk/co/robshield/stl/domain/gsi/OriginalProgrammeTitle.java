package uk.co.robshield.stl.domain.gsi;

import uk.co.robshield.stl.GSIComponent;

public class OriginalProgrammeTitle extends GSIComponent {

	private final String title;

	public OriginalProgrammeTitle(String title) {
		this.title = title.trim();
	}

	public String getTitle() {
		return title;
	}

	@Override
	public boolean equals(Object obj) {
		if(false == obj instanceof OriginalProgrammeTitle)return false;
		OriginalProgrammeTitle that = (OriginalProgrammeTitle)obj;
		return this.getTitle().equals(that.getTitle());
	}

	@Override
	public int hashCode() {
		return this.getTitle().hashCode();
	}

	@Override
	public String toString() {
		return this.getTitle();
	}

	
	
}
