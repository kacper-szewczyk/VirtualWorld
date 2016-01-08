package swiat;

public class Jez extends Organizm {

	public static final char znak = 'J';

	public Jez() {
	}
	
	public Jez(WirtualnySwiat swiat, Polozenie polozenie) {
		sila = 2;
		inicjatywa = 3;
		this.polozenie = polozenie;
		this.swiat = swiat;
	}
	
	public char getZnak() {
		return znak;
	}
	
	public void kolizja(Organizm przeciwnik, boolean atakujacy) {
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
						" zabija " + przeciwnik.getZnak() + " na " 
						+ przeciwnik.getPolozenie().x + "," + przeciwnik.getPolozenie().y);
				przeciwnik.zabij();
				polozenie = przeciwnik.getPolozenie();
			}
			else if (this.sila < przeciwnik.getSila())
			{
				System.out.println(getZnak() + " z " + polozenie.x + "," + polozenie.y +
						" ginac rani " + przeciwnik.getZnak() + " na " 
						+ przeciwnik.getPolozenie().x + "," + przeciwnik.getPolozenie().y);
				przeciwnik.setTury(-2);
			}
		}
	}
	
	public void rysowanie() {
		swiat.rysujOrganizm(znak, polozenie.x, polozenie.y);
	}
	
	public Organizm nowyOrganizm(WirtualnySwiat swiat, Polozenie polozenie) {
		return new Jez(swiat, polozenie);
	}
	

}
