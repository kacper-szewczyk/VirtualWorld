/**
 * 
 */
package swiat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author 
 *
 */
public class WirtualnySwiat {
	/**
	 * 
	 */
	ArrayList<Organizm> organizmy;
	
	/**
	 * 
	 */
	ArrayList<Organizm> noweOrganizmy;
	
	/**
	 * 
	 */
	public char[][] plansza;
	
	/**
	 * 
	 */
	public WirtualnySwiat() {
		organizmy = new ArrayList<>();
		noweOrganizmy = new ArrayList<>();
		plansza = new char[20][20];
		wypelnijZerami();
		zainicjalizujPlansze();

		zainicjalizujOrganizmy();
		posortuj();
		
		narysujWszystkieOrganizmy();
	}

	/**
	 * 
	 */
	private void narysujWszystkieOrganizmy() {
		for (Organizm organizm : organizmy) {
			System.out.println(organizm.getZnak());
			organizm.rysowanie();
		}
	}

	/**
	 * 
	 */
	private void zainicjalizujOrganizmy() {
		organizmy.add(new Owca(this, new Polozenie(1, 4)));
		organizmy.add(new Owca(this, new Polozenie(2, 7)));
		organizmy.add(new Wilk(this, new Polozenie(8, 7)));
		organizmy.add(new Wilk(this, new Polozenie(3, 14)));
		organizmy.add(new Trawa(this, new Polozenie(4, 3)));
		organizmy.add(new Trawa(this, new Polozenie(0, 2)));
		organizmy.add(new Jez(this, new Polozenie(19, 0)));
		organizmy.add(new Jez(this, new Polozenie(19, 19)));
		organizmy.add(new Lis(this, new Polozenie(14, 17)));
		organizmy.add(new Lis(this, new Polozenie(15, 14)));
		organizmy.add(new Ciern(this, new Polozenie(18, 8)));
		organizmy.add(new Ciern(this, new Polozenie(7, 16)));
		organizmy.add(new Koka(this, new Polozenie(10, 10)));
		organizmy.add(new Koka(this, new Polozenie(13, 7)));
		organizmy.add(new Kura(this, new Polozenie(2, 1)));
		organizmy.add(new Kura(this, new Polozenie(5, 4)));
	}

	/**
	 * 
	 */
	private void zainicjalizujPlansze() {
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				plansza[i][j] = 's';
			}
		}
	}

	/**
	 * 
	 */
	private void wypelnijZerami() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				plansza[i][j] = 0;
			}
		}
	}

	/**
	 * @return the organizmy
	 */
	public ArrayList<Organizm> getOrganizmy() {
		return organizmy;
	}

	/**
	 * @param organizmy the organizmy to set
	 */
	public void setOrganizmy(ArrayList<Organizm> organizmy) {
		this.organizmy = organizmy;
	}

	/**
	 * @return the noweOrganizmy
	 */
	public ArrayList<Organizm> getNoweOrganizmy() {
		return noweOrganizmy;
	}

	/**
	 * @param noweOrganizmy the noweOrganizmy to set
	 */
	public void setNoweOrganizmy(ArrayList<Organizm> noweOrganizmy) {
		this.noweOrganizmy = noweOrganizmy;
	}

	/**
	 * @return the plansza
	 */
	public char[][] getPlansza() {
		return plansza;
	}

	/**
	 * @param plansza the plansza to set
	 */
	public void setPlansza(char[][] plansza) {
		this.plansza = plansza;
	}
	
	/**
	 * 
	 */
	void wykonajTure() {
		for (Organizm organizm : organizmy) {
			wykonajTureDlaJednego(organizm);
		}
		dodajNoweOrganizmy();
		usunMartweOrganizmy();
		posortuj();
		
	}

	/**
	 * @param organizm
	 */
	private void wykonajTureDlaJednego(Organizm organizm) {
		if(organizm.getZyje()){
			Integer tury = organizm.getTury();
			if(tury < 0) {
				organizm.setTury(tury+1);
			}
			for (int i = tury; i >= 0; i--) {
				organizm.akcja();
				if(organizm.getZyje()){
					if(i == 0) {
						organizm.dodajWiek();
					}
				}
				else {
					break;
				}
			}
			if(organizm.getTury() > 0) {
				organizm.setTury(organizm.getTury() - tury);
			}
		}
	}

	/**
	 * 
	 */
	private void posortuj() {
		for (int i = 0; i < organizmy.size(); i++) {
			for (int j = 0; j < organizmy.size(); j++) {
				if(!porownajOrganizmy(organizmy.get(i), organizmy.get(j))) {
					Collections.swap(organizmy, i, j);
				}
			}
		}
	}

	/**
	 * 
	 */
	private void usunMartweOrganizmy() {
		for (Iterator<Organizm> iterator = organizmy.iterator(); iterator.hasNext();) {
			Organizm organizm = (Organizm) iterator.next();
			if(!organizm.getZyje()) {
				iterator.remove();			
			}
		}
	}

	/**
	 * 
	 */
	private void dodajNoweOrganizmy() {
		for (Organizm organizm : noweOrganizmy) {
			organizmy.add(organizm);
		}
	}
	
	public boolean porownajOrganizmy(Organizm pierwszy,
			Organizm drugi) {
		if (pierwszy.getInicjatywa() == drugi.getInicjatywa())
		{
			return pierwszy.getWiek() > drugi.getWiek();
		}
		return (pierwszy.getInicjatywa() > drugi.getInicjatywa());
	}
	
	public Organizm stworzOrganizm(char znak, Polozenie polozenie, int wiek) {
		Organizm nowyOrganizm = null;
		switch (znak) {
		case Wilk.znak:
			nowyOrganizm = new Wilk(this, polozenie);
			break;
		case Owca.znak:
			nowyOrganizm = new Owca(this, polozenie);
			break;
		case Trawa.znak:
			nowyOrganizm = new Trawa(this, polozenie);
			break;
		case Jez.znak:
			nowyOrganizm = new Jez(this, polozenie);
			break;
		case Lis.znak:
			nowyOrganizm = new Lis(this, polozenie);
			break;
		case Kura.znak:
			nowyOrganizm = new Kura(this, polozenie);
			break;
		case Ciern.znak:
			nowyOrganizm = new Ciern(this, polozenie);
			break;
		case Koka.znak:
			nowyOrganizm = new Koka(this, polozenie);
			break;
		}
		if (nowyOrganizm != null) {
			nowyOrganizm.setPolozenie(polozenie);
			nowyOrganizm.setWiek(wiek);
		}
		return nowyOrganizm;
	}

	public boolean czyPuste(Organizm organizm, Polozenie pol) {
		Polozenie sprawdzane;
		for (Organizm organizm2 : organizmy) {
			sprawdzane = organizm2.getPolozenie();
			if(sprawdzane.x == pol.x &&
					sprawdzane.y == pol.y &&
					organizm2.getZyje()){
				organizm = organizm2;
				return false;
			}
		}
		for (Organizm organizm2 : noweOrganizmy) {
			sprawdzane = organizm2.getPolozenie();
			if(sprawdzane.x == pol.x &&
					sprawdzane.y == pol.y &&
					organizm2.getZyje()){
				organizm = organizm2;
				return false;
			}
		}
		
		return true;
	}

	public void dodajOrganizm(Organizm nowyOrganizm) {
		noweOrganizmy.add(nowyOrganizm);
		
	}

	public void rysujOrganizm(char znak, Integer x, Integer y) {
		plansza[x][y] = znak;
	}
	
	public void rysujSwiat()
	{
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				plansza[i][j] = ' ';
			}
		}
		for (Organizm organizm : organizmy) {
			organizm.rysowanie();
		}

		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 20; j++)
			{
				System.out.print(plansza[i][j]);
			}
			System.out.println();
		}
	}
	
}
