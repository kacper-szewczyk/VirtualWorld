package swiat;

import java.util.Random;

public class Kura extends Zwierze {

	public static final char znak = 'K';
	
	public Kura() {
	}
	
	public Kura(WirtualnySwiat swiat, Polozenie polozenie) {
		sila = 1;
		inicjatywa = 5;
		this.polozenie = polozenie;
		this.swiat = swiat;
	}
	
	public char getZnak() {
		return znak;
	}
	
	void kolizja(Organizm przeciwnik, Boolean atakujacy){
		if (this.getZnak() == przeciwnik.getZnak())
		{
			for (int i = polozenie.x - 1; i <= polozenie.x + 1; i++)
			{
				if (i < 0 || i > 19)
				{
					continue;
				}
				for (int j = polozenie.y - 1; j <= polozenie.y + 1; j++)
				{
					if (j < 0 || j > 19)
					{
						continue;
					}
					if (swiat.czyPuste(przeciwnik, new Polozenie(i, j)))
					{
						System.out.println("Nowy " + getZnak() + " na " + i + "," + j);
						swiat.dodajOrganizm(nowyOrganizm(swiat, new Polozenie(i, j)));
						i = polozenie.x + 1;
						break;
					}
				}
			}
		}
		else
		{
			if (this.sila > przeciwnik.getSila() || (this.sila == przeciwnik.getSila() && atakujacy))
			{
				System.out.println(getZnak() + " z " + polozenie.x + "," + polozenie.y +
						" zabija " + przeciwnik.getZnak() + " na " +
						przeciwnik.getPolozenie().x + "," + przeciwnik.getPolozenie().y);
				przeciwnik.zabij();
				Polozenie poprzednie = polozenie;
				polozenie = przeciwnik.getPolozenie();
				if (przeciwnik.getZnak() == '*')
				{
					System.out.println("Nowy " + getZnak() + " na " +
							polozenie.x + "," + polozenie.y + " po zjedzeniu trawy");
					this.swiat.dodajOrganizm(nowyOrganizm(this.swiat, poprzednie));
				}
			}
		}
	}
	
	public void rysowanie() {
		swiat.rysujOrganizm(znak, polozenie.x, polozenie.y);
	}
	
	public Organizm nowyOrganizm(WirtualnySwiat swiat, Polozenie polozenie){
		return new Kura(swiat, polozenie);
	}

}
