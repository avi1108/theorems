package com.av.math;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author Avinash KM
 * @description Implementation of Wilson's Theorem for identifying all prime
 * numbers between a lower and upper bound. Has been tested with an upper bound of 10000.
 * 
 * {@link} https://en.wikipedia.org/wiki/Wilson%27s_theorem
 * */

public class WilsonsTheorem {

	private final static BigInteger lowerBound = new BigInteger("2");
	private final static BigInteger upperBound = new BigInteger("1000");

	public static void main(String... args) {

		BigInteger n = WilsonsTheorem.lowerBound;
		System.out.println("Start: " + new Date());
		Long currMillis = System.currentTimeMillis();
		Long count = 0L;

		do {
			final BigInteger factorial = getFactorial(n.subtract(BigInteger.ONE));

			if ((n.subtract(factorial.mod(n))).equals(BigInteger.ONE)) {
				System.out.print("  " + n);
				count++;
			}

			n = n.add(BigInteger.ONE);
		} while (n.compareTo(WilsonsTheorem.upperBound) != 0);

		System.out.println("\nPrime numbers found: "+count+
				"\nStop: " + new Date() + "\nRuntime (seconds): " + (System.currentTimeMillis() - currMillis) / 1000);

	}

	private static BigInteger getFactorial(BigInteger n) {

		if (n.longValue() == 1L) {
			return BigInteger.ONE;
		}
		if (n.longValue() == 2L) {
			return new BigInteger("2");
		}
		return (n.multiply(getFactorial(n.subtract(BigInteger.ONE))));
	}

}