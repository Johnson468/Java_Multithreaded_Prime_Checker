package PrimeFind.PrimeFind;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import helpers.PrimeHelper;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PrimeNumberTest extends TestCase {
	
	int[] primeNumbers = {13,7
			,11
			,13
			,17
			,19
			,23
			,29
			,31
			,37
			,47
			,53
			,59
			,61
			,67
			,71
			,73
			,79
		,	83
		,	89
		,	97
		,	101
		,	103
		,	107
		,	109
		,	113
		,	127
		,	131
		,	137
		,	139
		,	149
		,	151
		,	157
		,	163
		,	167
		,	173
		,	179
		,	181
		,	191
		,	193
		,	197
		,	199
		,	211
		,	223
		,	227
		,	229
		,	233
		,	239
		,	241
		,	251
		,	257
		,	263
		,	269
		,	271
		,	277
		,	281
		,	283
		,	293
		,	307
		,	311
		,	313
		,	317
		,	331
		,	337
		,	347
		,	349
			,353
		,	359
		,	367
		,	373
		,	379
			,383};
	
	public PrimeNumberTest() {
		
	}
	public void testThisShit() {
		PrimeHelper ph = new PrimeHelper();
		List primeList = Arrays.asList(primeNumbers).stream().filter(x -> ph.isPrime(x)).collect(Collectors.toList());
	}
	
	
}
