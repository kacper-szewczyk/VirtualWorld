/**
 * 
 */
package swiat;

/**
 * @author 
 *
 */
public class Polozenie {
	
	/**
	 * 
	 */
	public Integer x;
	
	/**
	 * 
	 */
	public Integer y;
	
	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
	}

	
	public Polozenie(){
		x = 0;
		y = 0;
	}
	public Polozenie(int x, int y){
		this.x = x;
		this.y = y;
	}
}
