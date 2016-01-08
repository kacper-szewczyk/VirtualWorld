/**
 * 
 */
package swiat;

/**
 * @author 
 *
 */
public class Wilk extends Organizm {

	public static final char znak = 'W';
	
	/**
	 * 
	 */
	public Wilk() {
		
	}
	
	/**
	 * @param swiat
	 * @param polozenie
	 */
	public Wilk(WirtualnySwiat swiat, Polozenie polozenie){
		sila = 9;
		inicjatywa = 5;
		this.polozenie = polozenie;
		this.swiat = swiat;
	}
	
	/**
	 * @return
	 */
	public char getZnak(){
		return znak;
	}
	
	/**
	 * 
	 */
	public void rysowanie(){
		swiat.rysujOrganizm(znak, polozenie.x, polozenie.y);
	}
	
	/**
	 * @param swiat
	 * @param polozenie
	 * @return
	 */
	public Organizm nowyOrganizm(WirtualnySwiat swiat, Polozenie polozenie){
		return new Wilk(swiat, polozenie);
	}
}
