package procesare;

public class Masina {
	private int idDestinatie;
	private int idAvion;
	private int id;
	private String nume;
	private String prenume;
	private String sex;
	private int varsta;

	public int getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}

	public int getIdDestinatie() {
		return idDestinatie;
	}

	public void setIdDestinatie(int idDestinatie) {
		this.idDestinatie = idDestinatie;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
