package swiat;

import java.util.Random;

public class Lis extends Organizm {

public static final char znak = 'L';
	
	public Lis() {
	}
	
	public Lis(WirtualnySwiat wirtualnySwiat, Polozenie polozenie) {
		sila = 3;
		inicjatywa = 7;
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
	
	public void akcja(){
		Random randomNumber = new Random();
		int x = randomNumber.nextInt() % 3 - 1;
		int y = randomNumber.nextInt()  % 3 - 1;
		if (x == 0 && y == 0)
		{
			while (y == 0)
			{
				y = randomNumber.nextInt() % 3 - 1;
			}
		}
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
			System.out.println(getZnak() +" przemiescil sie z " +
					polozenie.x + "," + polozenie.y + " na " +
					nowePolozenie.x + "," + nowePolozenie.y);
			polozenie = nowePolozenie;
		}
		else {
			if(this.sila >= przeciwnik.getSila()){
				this.kolizja(przeciwnik, true);
				if(this.getZnak() != przeciwnik.getZnak()){
					przeciwnik.kolizja(this, false);
				}
			}
		}
		
	}
	
	public void rysowanie() {
		swiat.rysujOrganizm(znak, polozenie.x, polozenie.y);
	}
	
	public Organizm nowyOrganizm(WirtualnySwiat swiat, Polozenie polozenie){
		return new Lis(swiat, polozenie);
	}

}
