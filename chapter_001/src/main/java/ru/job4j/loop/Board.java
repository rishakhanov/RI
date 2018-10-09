package ru.job4j.loop;

/**
 * @author Rajes Ishakhanov (rishakhanov@rambler.ru)
 * @version $ID$
 * @since 0.1
 */
 
public class Board {
	/**
	 * Шахматная доска в псевдографике.
	 * @param height,weight Числа
	 * @return Шахматная доска
	 */
	public String paint(int weight, int height){
		StringBuilder screen = new StringBuilder();
		String ln = System.lineSeparator();
		for (int ht = 1; ht <= height; ht++){
			for (int wt = 1; wt <= weight;wt++) {
				if ((ht+wt) %2==0) {
					screen.append("X");
				} else {
					screen.append(" ");	
				}	
			}		
		}		
		return screen.toString();	
	}
}