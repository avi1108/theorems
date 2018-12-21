package com.av.math;

import java.util.Date;

/**
 * @author Avinash KM
 * @description Implementation of Wilson's Theorem for identifying all prime
 * numbers between a lower and upper bound. upper bound larger than 30 does not work.
 * 
 * {@link} https://en.wikipedia.org/wiki/Wilson%27s_theorem
 * */

public class WilsonsTheoremLong {

	private final static Long lowerBound = 2L;
	private final static Long upperBound = 30L;

	public static void main(String... args) {

		Long n = WilsonsTheoremLong.lowerBound;
		System.out.println("Start: " + new Date());
		Long currMillis = System.currentTimeMillis();
		Long count = 0L;

		do {
			final Long factorial = getFactorial(n - 1);

			if ((n - (factorial % n)) == 1) {
				System.out.print("  " + n);
				count++;
			}

			n++;
		} while (n <= WilsonsTheoremLong.upperBound);

		System.out.println("\nPrime numbers found: "+count+
				"\nStop: " + new Date() + "\nRuntime (seconds): " + (System.currentTimeMillis() - currMillis) / 1000);

	}

	private static Long getFactorial(Long n) {

		if (n == 1 || n == 0) {
			return 1L;
		}
		if (n == 2) {
			return 2L;
		}
		return (n * getFactorial(n - 1));

	}

}
