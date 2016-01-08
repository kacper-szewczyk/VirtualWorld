package swiat;

import java.util.Random;

public class Roslina extends Organizm{
	public static final char znak = ' ';

	public Roslina(){
		inicjatywa = 0;
	}
	
	public void akcja(){
		Random randomNumber = new Random();
		int x = randomNumber.nextInt() % 3 - 1;
		int y = randomNumber.nextInt()  % 3 - 1;

		if (polozenie.x + x < 0 || polozenie.x + x > 19)
		{
			x *= -1;
		}
		if (polozenie.y + y < 0 || polozenie.y + y > 19)
		{
			y *= -1;
		}

		Polozenie nowePolozenie = new Polozenie(polozenie.x + x, polozenie.y + y);
		Organizm przeciwnik = null;
		if (swiat.czyPuste(przeciwnik, nowePolozenie))
		{
			System.out.println("Nowa " + getZnak() +" na " + 
					nowePolozenie.x + "," + nowePolozenie.y);
			swiat.dodajOrganizm(nowyOrganizm(swiat, nowePolozenie));
		}
	}
	
	public void kolizja(Organizm przeciwnik, boolean atakujacy){
	}
	
}
