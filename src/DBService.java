
import java.sql.*;
import java.util.ArrayList;
import org.sqlite.*;

public class DBService {	
	
	private static String sqLiteUrl = "sqlite:C:\\Users\\Sasha\\Nextcloud\\amnetprime_kundenstamm.sqlite3";
	
	private static String mySqlUrl = "mysql://localhost:3306/amnetprime";
	

	public static ArrayList<Kunde> liesKundenAusDB(boolean nutzeSQLite) {
		ArrayList<Kunde> kunden = new ArrayList<Kunde>();
		
		String query = "SELECT kunde.ID, vorname, nachname, geburtsdatum, strasse, kunde.plz, ort.ort, kundeSeit, geschlecht.geschlecht, familienstand.familienstand, abo.ID FROM kunde, ort, geschlecht, "
				+ "familienstand, abo WHERE kunde.plz = ort.plz AND kunde.geschlecht = geschlecht.ID AND kunde.familienstand = familienstand.ID AND kunde.aboTyp = abo.ID;";
	    
		try (Connection con = DriverManager.getConnection("jdbc:" + (nutzeSQLite ? sqLiteUrl : mySqlUrl), (nutzeSQLite ? "" : "root"), "")) {
			Statement stm = con.createStatement();
		
			ResultSet set = stm.executeQuery(query);
			
			while (set.next()) {
				
				for (int i = 1; i <= set.getMetaData().getColumnCount(); i += 11) {
					int kundenId = set.getInt(i);

					String vorname = set.getString(i + 1);

					String nachname = set.getString(i + 2);

					Date geburtsdatum = Date.valueOf(set.getString(i + 3));

					String strasse = set.getString(i + 4);
					
					int plz = set.getInt(i + 5);
					
					String ort = set.getString(i + 6);
					
					Date kundeSeit = Date.valueOf(set.getString(i + 7));
					
					String geschlecht = set.getString(i + 8);
					
					String familienstand = set.getString(i + 9);
					
					int aboTyp = set.getInt(i + 10);

					Kunde kunde = new Kunde(kundenId, vorname, nachname, geburtsdatum, strasse, plz, ort, kundeSeit, geschlecht, familienstand, aboTyp);
					
					kunden.add(kunde);
				}
			}
			
			stm.close();

			set.close();

			return kunden;
		}
		catch (SQLException sqlEx) {
			System.out.println(sqlEx.getMessage());
		}
	
		return null;
	}
	
	public static void fuegeKundeZuDB(Kunde neuerKunde, boolean nutzeSQLite) {
		String query = "INSERT INTO kunde (ID, vorname, nachname, geburtsdatum, strasse, plz, kundeSeit, geschlecht, familienstand, aboTyp)\r\n"
				+ "VALUES (%d, \"%s\", \"%s\", \"%s\", \"%s\", (SELECT ort.plz FROM ort WHERE ort.ort = \"%s\"), \"%s\", (SELECT geschlecht.ID FROM geschlecht\r\n"
				+ "WHERE geschlecht.geschlecht = \"%s\"), (SELECT familienstand.ID FROM familienstand WHERE familienstand.familienstand = \"%s\"), %d);";
	    

	    
		try (Connection con = DriverManager.getConnection("jdbc:" + (nutzeSQLite ? sqLiteUrl : mySqlUrl), (nutzeSQLite ? "" : "root"), "")) {
			Statement stm = con.createStatement();
		
			int rows = stm.executeUpdate(String.format(query, neuerKunde.getKundenId(), neuerKunde.getVorname(), neuerKunde.getNachname(), neuerKunde.getGeburtsdatum(),
					neuerKunde.getStrasse(), neuerKunde.getOrt(), neuerKunde.getKundeSeit(), neuerKunde.getGeschlecht(), neuerKunde.getFamilienstand(),
					neuerKunde.getAboTyp()));
	
			
			stm.close();
		}
		catch (SQLException sqlEx) {
			System.out.println(sqlEx.getMessage());
		}
	}
	
	public static void updateKundeInDB(Kunde kundeAusDb, boolean nutzeSQLite) {
		
	}
}
