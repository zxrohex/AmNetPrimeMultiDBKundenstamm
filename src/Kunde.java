import java.text.DateFormat;
import java.util.Date;

public class Kunde {
	private int kundenId;
	private String vorname;
	private String nachname;
	private Date geburtsdatum;
	private String strasse;
	private int plz;
	private String ort;
	private Date kundeSeit;
	private String geschlecht;
	private String familienstand;
	private int aboTyp;
	
	public Kunde() {
	}
	
	public Kunde(int kundenId, String vorname, String nachname, Date geburtsdatum, String strasse, int plz, String ort, Date kundeSeit, String geschlecht, String familienstand, int aboTyp) {
		this.kundenId = kundenId;
		
		this.vorname = vorname;
		
		this.nachname = nachname;
		
		this.geburtsdatum = geburtsdatum;
		
		this.strasse = strasse;
		
		this.plz = plz;
		
		this.ort = ort;
		
		this.kundeSeit = kundeSeit;
		
		this.geschlecht = geschlecht;
		
		this.familienstand = familienstand;
		
		this.aboTyp = aboTyp;
	}

	
	public int getKundenId() {
		return this.kundenId;
	}
	
	public String getVorname() {
		return this.vorname;
	}
	
	public String getNachname() {
		return this.nachname;
	}
	
	public Date getGeburtsdatum() {
		return this.geburtsdatum;
	}
	
	public String getStrasse() {
		return this.strasse;
	}
	
	public int getPlz() {
		return this.plz;
	}
	
	public String getOrt() {
		return this.ort;
	}
	
	public Date getKundeSeit() {
		return this.kundeSeit;
	}
	
	public String getGeschlecht() {
		return this.geschlecht;
	}
	
	public String getFamilienstand() {
		return this.familienstand;
	}
	
	public int getAboTyp() {
		return this.aboTyp;
	}
	
	public void setKundenId(int kundenId) {
		this.kundenId = kundenId;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public void setNachname(String nachname) {
	    this.nachname = nachname;
	}
	
	public void setGeburtsdatum(String geburtsdatum) {
		 this.geburtsdatum = java.sql.Date.valueOf(geburtsdatum);
	}
	
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	
	public void setPlz(int plz) {
		this.plz = plz;
	}
	
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	public void setKundeSeit(String kundeSeit) {
		this.kundeSeit = java.sql.Date.valueOf(kundeSeit);
	}
	
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	public void setFamilienstand(String familienstand) {
		this.familienstand = familienstand;
	}
	
	public void setAboTyp(int aboTyp) {
		this.aboTyp = aboTyp;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s (%d); %d %s; %s", this.vorname, this.nachname, this.kundenId, this.plz, this.ort, this.geburtsdatum);
	}
}
