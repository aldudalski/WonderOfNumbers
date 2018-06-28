package palindromenumbers;

import java.math.BigInteger;

public class PalindromeNumber {

	BigInteger number;
	
	public BigInteger getPalindromeNumber() throws Exception{
		return number;
	}
		
	@Override
	public String toString() {
		return number.toString();
	}

	public PalindromeNumber(BigInteger x, BigInteger y) throws Exception{
		
		number=x.multiply(y);
		
		if (!isPalindromeNumber(number)) throw new Exception("Not a PalindromeNumber");
	}
		
	public static Boolean isPalindromeNumber(BigInteger i){
		String iStr = i.toString();
		char iChars[] = iStr.toCharArray();
		Integer iLength = iStr.length();
		Integer iMidChar = iLength/2; // this is what happens: (iCharCount%2 == 0) ? iCharCount / 2 : (iCharCount -1) /2;
		Integer step = 0;
		
		Boolean isPalindromeNumber = true;
		while (step  < iMidChar){
			if (iChars[step]!=iChars[iLength - step -1]) {
				isPalindromeNumber = false;
				break;
			}
			step++;
		}
		return isPalindromeNumber;		
	}
	
}
