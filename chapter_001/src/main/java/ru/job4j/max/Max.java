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
	int result;
	result = first > second ? first : second;
	return result;
	}
}	