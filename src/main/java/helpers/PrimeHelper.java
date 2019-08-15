package helpers;

import org.pmw.tinylog.Logger;

import prime_finder.Constants;
import structures.AVLTree;

public class PrimeHelper {
	
	
	public PrimeHelper() {
	}
	//Fermat primality test
	public static boolean canBePrime(int n) {
		Logger.info(Constants.TRYING,  n);
		return (n < 3 || n % 2 == 0 || n % 5 == 0) ? false : modPow(2, n-1l, n) == 1;
	}
	public static boolean isPrime(int n) {
		Logger.info("Trying: " + n);
		for (int i = 3 ; i < Math.sqrt(n); i+=2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Automatically increase the number given by 2 
	 * @param n
	 * @param filePath
	 * @param tree
	 */
	public static void climb(int n, String filePath, AVLTree tree) {
		while(n <= Integer.MAX_VALUE) {
			if (!hasBeenChecked(n, tree) && canBePrime(n)) {
				//Store the checked number
				FileWriteHelper fwh1 = new FileWriteHelper(filePath, Constants.TRIED_FILE, n);
				fwh1.start();
				//Adds the current number to the tree so it won't be checked in the future
				tree.insert(n);
				if (isPrime(n)) {
					Logger.info("Found prime: " + n);
					//Create a multithreaded write function for the prime numbers
					FileWriteHelper fwh = new FileWriteHelper(filePath, Constants.PRIME_FILE, n);
					//Write the number in the file in a seperate thread
					fwh.start();
					//Log pseudo prime numbers using another thread
				} else {
					FileWriteHelper fwh = new FileWriteHelper(filePath, Constants.PSEUDO_FILE, n);
					fwh.start();
				}
			}
			n+=2;
		}
	}
	/**
	 * Checks the tree in log(n) time for the number to search for.
	 * @param n
	 * @param tree
	 * @return
	 */
	private static boolean hasBeenChecked(int n, AVLTree tree) {
		return tree.search(n);
	}
	public static long modPow(long a, long b, long c)
    {
        long res = 1;
        for (int i = 0; i < b; i++)
        {
            res *= a;
            res %= c; 
        }
        return res % c;
    }    
}
