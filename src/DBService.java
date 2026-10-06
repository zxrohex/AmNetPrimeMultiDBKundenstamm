
import java.sql.*;
import java.util.ArrayList;
import org.sqlite.*;

public class DBService {	

	public static ArrayList<Kunde> liesKundenAusDB(boolean nutzeSQLite) {
		ArrayList<Kunde> kunden = new ArrayList<Kunde>();
		
		String sqLiteUrl = "sqlite:C:\\Users\\Sasha\\Nextcloud\\amnetprime_kundenstamm.sqlite3";
		
		String mySqlUrl = "mysql://localhost:3306/amnetprime";
	    
	
		try (Connection con = DriverManager.getConnection("jdbc:" + (nutzeSQLite ? sqLiteUrl : mySqlUrl), (nutzeSQLite ? "" : "root"), "")) {
			Statement stm = con.createStatement();
		
			ResultSet set = stm.executeQuery("SELECT ID, vorname, nachname, geburtsdatum, strasse, plz, kundeSeit, geschlecht, familienstand, aboTyp FROM kunde");
			
			while (set.next()) {
				
				for (int i = 1; i <= set.getMetaData().getColumnCount(); i += 10) {
					int kundenId = set.getInt(i);

					String vorname = set.getString(i + 1);

					String nachname = set.getString(i + 2);

					Date geburtsdatum = Date.valueOf(set.getString(i + 3));

					String strasse = set.getString(i + 4);
					
					int plz = set.getInt(i + 5);
					
					Date kundeSeit = Date.valueOf(set.getString(i + 6));
					
					String geschlecht = set.getString(i + 7);
					
					String familienstand = set.getString(i + 8);
					
					int aboTyp = set.getInt(i + 9);

					Kunde kunde = new Kunde(kundenId, vorname, nachname, geburtsdatum, strasse, plz, kundeSeit, geschlecht, familienstand, aboTyp);
					
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
}
