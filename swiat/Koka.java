package swiat;

public class Koka extends Roslina {

	public static final char znak = '%';

	public Koka() {
	}
	
	public Koka(WirtualnySwiat swiat, Polozenie polozenie) {
		sila = 0;
		this.polozenie = polozenie;
		this.swiat = swiat;
	}
	
	public char getZnak() {
		return znak;
	}
	
	public void kolizja(Organizm przeciwnik, boolean atakujacy) {
		System.out.println(getZnak() + " daje dodatkowy ruch " + przeciwnik.getZnak());
		przeciwnik.setTury(przeciwnik.getTury() + 1);
	}
	
	public void rysowanie() {
		swiat.rysujOrganizm(znak, polozenie.x, polozenie.y);
	}
	
	public Organizm nowyOrganizm(WirtualnySwiat swiat, Polozenie polozenie) {
		return new Koka(swiat, polozenie);
	}

}
