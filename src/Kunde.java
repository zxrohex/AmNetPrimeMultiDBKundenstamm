import java.util.Date;

public class Kunde {
	private int kundenId;
	private String vorname;
	private String nachname;
	private Date geburtsdatum;
	private String strasse;
	private int plz;
	private Date kundeSeit;
	private String geschlecht;
	private String familienstand;
	private int aboTyp;
	
	public Kunde(int kundenId, String vorname, String nachname, Date geburtsdatum, String strasse, int plz, Date kundeSeit, String geschlecht, String familienstand, int aboTyp) {
		this.kundenId = kundenId;
		
		this.vorname = vorname;
		
		this.nachname = nachname;
		
		this.geburtsdatum = geburtsdatum;
		
		this.strasse = strasse;
		
		this.plz = plz;
		
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
	
	@Override
	public String toString() {
		return String.format("%s %s (%d)", this.vorname, this.nachname, this.kundenId);
	}
}
