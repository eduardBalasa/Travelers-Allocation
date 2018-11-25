package procesare;

import java.util.ArrayList;
import java.util.List;

public class Repartizare {

	private Destinatie destinatie;
	private List<Situatie> situatii;
	
	public List<Situatie> getSituatii() {
		return situatii;
	}

	public void setSituatii(List<Situatie> situatii) {
		this.situatii = situatii;
	}

	public Destinatie getDestinatie() {
		return destinatie;
	}

	public void setDestinatie(Destinatie destinatie) {
		this.destinatie = destinatie;
	}


	public void addSituatie(Situatie situatie) {
		if (situatii == null) {
			situatii = new ArrayList<Situatie>();
		}
		situatii.add(situatie);
	}
}
