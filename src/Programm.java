import java.util.ArrayList;
import java.util.Scanner;

public class Programm {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Wähle aus, aus welcher Datenbank die Kunden ausgelesen werden soll: ");
		System.out.println();
		System.out.println("1: MySQL");
		System.out.println("2: SQLite");
		System.out.println();
		System.out.print("> ");
		
		ArrayList<Kunde> kunden;
		
		int auswahl = scanner.nextInt();
		
		if (auswahl == 1) {
			System.out.println();
			System.out.println("MySQL Daten:");
			
			Kunde neuerKunde = new Kunde();
			
			neuerKunde.setKundenId(2);
			
			neuerKunde.setVorname("Max");
			
			neuerKunde.setNachname("Mustermann");
			
			neuerKunde.setGeburtsdatum("1999-07-01");
			
			neuerKunde.setStrasse("Musterstrasse 04");
			
			neuerKunde.setPlz(45657);
			
			neuerKunde.setOrt("Recklinghausen");
			
			neuerKunde.setKundeSeit("2002-01-01");
			
			neuerKunde.setGeschlecht("w");
			
			neuerKunde.setFamilienstand("ledig");
			
			neuerKunde.setAboTyp(1);
			
			DBService.fuegeKundeZuDB(neuerKunde, false);
			
			kunden = DBService.liesKundenAusDB(false);
			
			for (int i = 0; i < kunden.size(); i++) {
				Kunde kunde = kunden.get(i);

				System.out.println(kunde);
			}
		}
		else if (auswahl == 2) {
			System.out.println();
			System.out.println("SQLite Daten:");
			
	Kunde neuerKunde = new Kunde();
			
			neuerKunde.setKundenId(2);
			
			neuerKunde.setVorname("Max");
			
			neuerKunde.setNachname("Mustermann");
			
			neuerKunde.setGeburtsdatum("1999-07-01");
			
			neuerKunde.setStrasse("Musterstrasse 04");
			
			neuerKunde.setPlz(45657);
			
			neuerKunde.setOrt("Recklinghausen");
			
			neuerKunde.setKundeSeit("2002-01-01");
			
			neuerKunde.setGeschlecht("w");
			
			neuerKunde.setFamilienstand("ledig");
			
			neuerKunde.setAboTyp(1);
			
			DBService.fuegeKundeZuDB(neuerKunde, true);
			
			kunden = DBService.liesKundenAusDB(true);
			
			for (int i = 0; i < kunden.size(); i++) {
				Kunde kunde = kunden.get(i);

				System.out.println(kunde);
			}
		}
		else {
			
		}
	}

}
