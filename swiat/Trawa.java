package swiat;

public class Trawa extends Roslina {

	public static final char znak = '*';
	
	public Trawa() {
	}
	
	public Trawa(WirtualnySwiat wirtualnySwiat, Polozenie polozenie) {
		sila = 0;
		this.polozenie = polozenie;
		this.swiat = swiat;
	}
	
	public char getZnak() {
		return znak;
	}
	public void rysowanie() {
		swiat.rysujOrganizm(znak, polozenie.x, polozenie.y);
	}
	
	public Organizm nowyOrganizm(WirtualnySwiat swiat, Polozenie polozenie){
		return new Trawa(swiat, polozenie);
	}

}
