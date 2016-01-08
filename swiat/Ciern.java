package swiat;

import java.util.Random;

public class Ciern extends Roslina {

	public static final char znak = ',';
	
	public Ciern() {
	}
	
	public Ciern(WirtualnySwiat wirtualnySwiat, Polozenie polozenie) {
		sila = 2;
		this.polozenie = polozenie;
		this.swiat = swiat;
	}
	
	public char getZnak() {
		return znak;
	}
	
	public void akcja() {
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
		else if(x != 0 || y != 0){
			if(przeciwnik.getSila() == 0){
				System.out.println("Nowa " + getZnak() +" na " + 
						nowePolozenie.x + "," + nowePolozenie.y +
						"wyrywajac " + przeciwnik.getZnak());
				przeciwnik.zabij();
				swiat.dodajOrganizm(nowyOrganizm(swiat,nowePolozenie));
			}
		}
	}
	
	public void rysowanie() {
		swiat.rysujOrganizm(znak, polozenie.x, polozenie.y);
	}
	
	public Organizm nowyOrganizm(WirtualnySwiat swiat, Polozenie polozenie){
		return new Ciern(swiat, polozenie);
	}
}
