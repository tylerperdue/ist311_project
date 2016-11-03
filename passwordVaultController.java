import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;


public class passwordVaultController 
{
	
	String strCategory;
	String strUsername;
	String strPassword;
	String strSystemName;
	

	public passwordVaultController(String currentUsername,
			String selectedCategory, String sysName)
	{
		strCategory = selectedCategory;
		strUsername = currentUsername;
		strSystemName = sysName;
	}
	
	public void readCredentials()
	{
		
		try{
			
		Scanner fileIn = new Scanner(new File("CREDENTIALS.txt"));
		ArrayList<String> username = new ArrayList<String>();
		String[] parts;
		String tempSemicCapture;
		String firstPart;
	//	String secondPart;
		
		while(fileIn.hasNextLine())
		{
			username.add(fileIn.nextLine());
		}
		
		for(int i = 0; i < username.size(); i++)
		{
			tempSemicCapture = username.get(i);
			parts = tempSemicCapture.split(";");
			firstPart = parts[0];
			//secondPart = parts[1];
			
			System.out.println("Array " + i + ":" + username.get(i));
			
			if(firstPart.equals(strUsername))
			{
				System.out.println("Captured: " + firstPart);
			}
			
		}
		
		
		}
		catch(FileNotFoundException e)
		{
			System.err.println("Error");
			System.out.println(e.getMessage());
		}
	}

}
