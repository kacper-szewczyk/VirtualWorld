/**
 * 
 */
package swiat;

import java.util.Scanner;

/**
 * @author 
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WirtualnySwiat wirtualny = new WirtualnySwiat();
		wirtualny.rysujSwiat();
		String komenda;
		boolean graj = true;
		Scanner sc = new Scanner(System.in);
		wirtualny.rysujSwiat();
		while (graj)
		{
			
			komenda = sc.nextLine();
			if (komenda.getBytes()[0] == 'k')
			{
				graj = false;
			}
			else
			{
				wirtualny.wykonajTure();
			}
			wirtualny.rysujSwiat();
		}
	}

}
