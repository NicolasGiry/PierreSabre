package histoire;

import personnages.Humain;
import personnages.Commercant;
import personnages.Yakuza;
import personnages.Ronin;

public class HistoireTP4 {
	public static void main(String[] args) {
		Humain prof = new Humain("prof","kombucha",54);
		Commercant marco = new Commercant("Marco", 20);
		Yakuza yakuLeNoir = new Yakuza("Yaku Le Noir", "whisky", 30, "Noir");
		Ronin roro = new Ronin("Roro", "shochu", 60);
		
		prof.direBonjour();
		prof.acheter("une boisson", 12);
		prof.boire();
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);
		System.out.println();
		
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();
		System.out.println();
		
		yakuLeNoir.direBonjour();
		yakuLeNoir.extorquer(marco);
		System.out.println();
		
		roro.direBonjour();
		roro.donner(marco);
		
	}
}
