package swiat;

public class Owca extends Organizm {
	
	public static final char znak = 'O';

	public Owca(){
		
	}
	
	public Owca(WirtualnySwiat swiat, Polozenie polozenie){
		sila = 4;
		inicjatywa = 4;
		this.polozenie = polozenie;
		this.swiat = swiat;
	}
	
	public char getZnak(){
		return znak;
	}
	
	public void rysowanie(){
		swiat.rysujOrganizm(znak, polozenie.x, polozenie.y);
	}
	
	public Organizm nowyOrganizm(WirtualnySwiat swiat, Polozenie polozenie){
		return new Owca(swiat, polozenie);
	}

}
