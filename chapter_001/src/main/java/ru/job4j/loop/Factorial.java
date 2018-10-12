package ru.job4j.loop;

/**
 * @author Rajes Ishakhanov (rishakhanov@rambler.ru)
 * @version $ID$
 * @since 0.1
 */
 
public class Factorial {
	/**
	 * Подсчет суммы чётных чисел в диапазоне.
	 * @param start,finish Числа
	 * @return Сумма чётных чисел
	 */
	public int calc(int n) {
		int sum = 1;
		if (n == 0) {
			sum = 1;
		}
		else {
			for (int i = 1; i <= n; i++) sum = sum * i;
		}		
		return sum;	
	}
		
}	