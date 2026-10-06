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
		
		int auswahl = scanner.nextInt();
		
		if (auswahl == 1) {
			
		}
		else if (auswahl == 2) {
			ArrayList<Kunde> kunden = DBService.liesKundenAusDB(true);
			
			for (int i = 0; i < kunden.size(); i++) {
				Kunde kunde = kunden.get(i);

				System.out.println(kunde);
			}
		}
		else {
			
		}
	}

}
