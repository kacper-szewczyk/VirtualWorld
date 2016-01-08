package swiat;

import java.util.Random;

public abstract class Zwierze extends Organizm{

	public Zwierze() {
		
	}
	
	@Override
	void akcja() {
		Random randomNumber = new Random();
		Integer x = randomNumber.nextInt() % 3 - 1;
		Integer y = randomNumber.nextInt() % 3 - 1;
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

		Polozenie nowePolozenie = new Polozenie();
		nowePolozenie.setX(polozenie.x + x);
		nowePolozenie.setY(polozenie.y + y);
		Organizm przeciwnik = null;
		if (swiat.czyPuste(przeciwnik, nowePolozenie))
		{
			System.out.println(getZnak() + " przemiescil sie z " 
					+ polozenie.x + "," + polozenie.y + " na " +
					nowePolozenie.x + "," + nowePolozenie.y);
			polozenie = nowePolozenie;
		}
		else
		{
			this.kolizja(przeciwnik, true);
			if (this.getZnak() != przeciwnik.getZnak())
			{
				przeciwnik.kolizja(this, false);
			}
		}
	}

	@Override
	void kolizja(Organizm przeciwnik, Boolean atakujacy) {
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
					Polozenie pol = new Polozenie();
					pol.setX(i);
					pol.setY(i);
					if (swiat.czyPuste(przeciwnik, pol))
					{
						System.out.println("Nowy " + this.getZnak() + " na " + i + "," + j);
						swiat.dodajOrganizm(nowyOrganizm(swiat, pol));
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
				System.out.println(this.getZnak() + " z " + polozenie.x + "," + polozenie.y + 
						" zabija " +  przeciwnik.getZnak() + " na " 
						+ przeciwnik.getPolozenie().x + "," + przeciwnik.getPolozenie().y);
				przeciwnik.zabij();
				polozenie = przeciwnik.getPolozenie();
			}
		}
	}


}
