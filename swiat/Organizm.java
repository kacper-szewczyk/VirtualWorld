package swiat;

/**
 * @author 
 *
 */
public class Organizm {
	/**
	 * 
	 */
	protected Integer sila;
	/**
	 * 
	 */
	protected Integer inicjatywa;
	/**
	 * 
	 */
	protected Integer wiek;
	/**
	 * 
	 */
	protected Integer tury;
	/**
	 * 
	 */
	protected Boolean zyje;
	/**
	 * 
	 */
	protected Polozenie polozenie;

	/**
	 * 
	 */
	protected WirtualnySwiat swiat;
	/**
	 * 
	 */
	static final char znak = ' ';
	
	public Organizm() {
		wiek = 0;
		tury = 0;
		inicjatywa = 0;
		sila = 0;
		zyje = true;
	}
	
	/**
	 * @return the sila
	 */
	public Integer getSila() {
		return sila;
	}

	/**
	 * @param sila the sila to set
	 */
	public void setSila(Integer sila) {
		this.sila = sila;
	}

	/**
	 * @return the inicjatywa
	 */
	public Integer getInicjatywa() {
		return inicjatywa;
	}

	/**
	 * @param inicjatywa the inicjatywa to set
	 */
	public void setInicjatywa(Integer inicjatywa) {
		this.inicjatywa = inicjatywa;
	}

	/**
	 * @return the wiek
	 */
	public Integer getWiek() {
		return wiek;
	}

	/**
	 * @param wiek the wiek to set
	 */
	public void setWiek(Integer wiek) {
		this.wiek = wiek;
	}

	/**
	 * @return the tury
	 */
	public Integer getTury() {
		return tury;
	}

	/**
	 * @param tury the tury to set
	 */
	public void setTury(Integer tury) {
		this.tury = tury;
	}

	/**
	 * @return the zyje
	 */
	public Boolean getZyje() {
		return zyje;
	}

	/**
	 * @param zyje the zyje to set
	 */
	public void setZyje(Boolean zyje) {
		this.zyje = zyje;
	}

	/**
	 * @return the polozenie
	 */
	public Polozenie getPolozenie() {
		return polozenie;
	}

	/**
	 * @param polozenie the polozenie to set
	 */
	public void setPolozenie(Polozenie polozenie) {
		this.polozenie = polozenie;
	}

	/**
	 * 
	 */
	void akcja(){
		
	}
	
	/**
	 * @param przeciwnik
	 * @param atakujacy
	 */
	void kolizja(Organizm przeciwnik, Boolean atakujacy){
		
	}
	
	/**
	 * 
	 */
	void rysowanie(){
		
	}
	/**
	 * @param swiat
	 * @param polozenie
	 * @return
	 */
	Organizm nowyOrganizm(WirtualnySwiat swiat, Polozenie polozenie){
		return null;
		
	}
	
	/**
	 * @return
	 */
	char getZnak(){
		return znak;
		
	}
	
	/**
	 * 
	 */
	public void dodajWiek(){
		wiek++;
	}
	
	public void zabij() {
		zyje = false;
	}
	
	
}
