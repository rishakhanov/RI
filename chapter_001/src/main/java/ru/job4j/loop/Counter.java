package ru.job4j.loop;

/**
 * @author Rajes Ishakhanov (rishakhanov@rambler.ru)
 * @version $ID$
 * @since 0.1
 */
 
public class Counter {
	/**
	 * Подсчет суммы чётных чисел в диапазоне.
	 * @param start,finish Числа
	 * @return Сумма чётных чисел
	 */
	public int add(int start, int finish) {
		int sum = 0;
		for (int i  =start; i <= finish; i++) {
			if ((i%2)==0) {
				sum = sum + i;
			}
		}
		return sum;	
	}
		
}	