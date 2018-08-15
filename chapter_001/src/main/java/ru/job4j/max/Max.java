package ru.job4j.max;

/**
 * @author Rajes Ishakhanov (rishakhanov@rambler.ru)
 * @version $ID$
 * @since 0.1
 */
 
public class Max {
	/**
	 * Возвращает максимальное число.
	 * @param first,second Числа
	 * @return Максимум
	 */
	public int max(int first, int second){
		return first > second ? first : second;
	}
	
	public int max(int first, int second, int third){
		int temp = this.max(first, second);
		return this.max(temp,third);
	}	
}	