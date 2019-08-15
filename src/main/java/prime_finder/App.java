package prime_finder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.pmw.tinylog.Logger;

import helpers.FileCheckHelper;
import helpers.PrimeHelper;
import structures.AVLTree;

/**
 * This should take in a file path to create a prime file, a checked number file, and a pseudo prime file. 
 *
 */
public class App 
{
	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
    public static void main( String[] args ) throws FileNotFoundException
    {
    	
    	if (args.length < 2) {
    		Logger.error("Please enter a number to raise the power to and a file to check");
    		return;
    	}
    	int n = Integer.parseInt(args[0]);
    	int number = ((int) Math.pow(2d, n)) - 1;
    	String path = args[1];
    	checkFiles(path);
    	AVLTree tree = setupTree(path);
    	PrimeHelper.climb(number, path, tree);
    }
    /**
     * Checks or sets up 
     * @param path
     */
    private static void checkFiles(String path) {
    	FileCheckHelper fch1 = new FileCheckHelper(path, Constants.PRIME_FILE);
    	FileCheckHelper fch2 = new FileCheckHelper(path, Constants.PSEUDO_FILE);
    	FileCheckHelper fch3 = new FileCheckHelper(path, Constants.TRIED_FILE);
    	fch1.start();
    	fch2.start();
    	fch3.start();
    }

    /**
     * Sets up a self balancing tree with the numbers that have already been tried
     * @param path
     * @return
     * @throws FileNotFoundException
     */
    private static AVLTree setupTree(String path) throws FileNotFoundException {
    	String filePath = path + Constants.TRIED_FILE;
    	File f = new File(filePath);
    	Logger.debug("building tree");
    	AVLTree tree = new AVLTree();
    	Scanner myScan = new Scanner(f);
    	while(myScan.hasNext()) {
    		tree.insert(myScan.nextInt());
    	}
    	tree.inorder();
    	myScan.close();
    	return tree;
    }
}
