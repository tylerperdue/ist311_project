import java.util.Random;


public class PasswordGenController 
{

	
	public  String GenerateCapLetters(int Length, boolean checkBoxState) // add another paramater (boolean to determine if user checked the text box
	{
		int nLength = Length;
		char charGenLetters;
		
		
		
		String GenLetters = "";
		
		final String CapAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		final int nAlphabetSize = CapAlphabet.length();
		
		final int nAlphaSize = nAlphabetSize;
		
		Random r = new Random();
		
		
		if(checkBoxState == true)
		{
			for(int i = 0; i < nLength; i++)
			{
			
				charGenLetters = CapAlphabet.charAt(r.nextInt(nAlphaSize));
			
				GenLetters = GenLetters + String.valueOf(charGenLetters);
			}
		}
		
		
		return GenLetters;
		
	}
	
	public  String GenerateSmallLetters(int Length, boolean checkBoxState)
	{
		int nLength = Length;
		char charGenLetters;
		
		String GenLetters = "";
		
		final String SmaAlphabet = "abcdefghjklmnopqrstuvwxyzi";
		
		final int nAlphabetSize = SmaAlphabet.length();
		
		final int nAlphaSize = nAlphabetSize;
		
		Random r = new Random();
		
		if(checkBoxState == true)
		{
			for(int i = 0; i < nLength; i++)
			{
			
				charGenLetters = SmaAlphabet.charAt(r.nextInt(nAlphaSize));
			
				GenLetters = GenLetters + String.valueOf(charGenLetters);
			}
		}
		return GenLetters;
		
	}
	
	public  String GenerateNumbers(int Length, boolean checkBoxState)
	{
		int nLength = Length;
		char charGenNumber;
		
		String GenNumbers = "";
		
		final String strNumbers = "0123456789";
		
		final int nNumbersSize = strNumbers.length();
		
		final int nNumSize = nNumbersSize;
		
		Random r = new Random();
		
		
		if(checkBoxState == true)
		{
			for(int i = 0; i < nLength; i++)
			{
				
				charGenNumber = strNumbers.charAt(r.nextInt(nNumSize));
			
				GenNumbers = GenNumbers + String.valueOf(charGenNumber);
			}
		}
		
		return GenNumbers;
		
	}
	
	public  String GenerateSymbols(int Length, boolean checkBoxState)
	{
		int nLength = Length;
		char charGenSymbol;
		
		String GenSymbol = "";
		
		final String strSymbols = "!@#$%^&*,_";
		
		final int nSymbolsSize = strSymbols.length();
		
		final int nSymSize = nSymbolsSize;
		
		Random r = new Random();
		
		if(checkBoxState == true)
		{
			for(int i = 0; i < nLength; i++)
			{
			
				charGenSymbol = strSymbols.charAt(r.nextInt(nSymSize));
			
				GenSymbol = GenSymbol + String.valueOf(charGenSymbol);
			}
		}
		
		return GenSymbol;
		
	}


}
