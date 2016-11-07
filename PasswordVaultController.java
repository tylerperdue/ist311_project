import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;


public class PasswordVaultController 
{
	
	String strCategory;
	String strUsername;
	String strPassword;
	String strSystemName;
	

	public PasswordVaultController(String currentUsername,
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
		String tempSemicCapture;
		String tempLine;
		
		while(fileIn.hasNextLine())
		{
			tempLine = fileIn.nextLine().toString(); // store the line in tempLine variable
			if(!(tempLine.isEmpty()))	// if the tempLine is not empty, then add tempLine to the ArrayList
			username.add(tempLine);
		}
		
		for(int i = 0; i < username.size(); i++)
		{
			
			tempSemicCapture = username.get(i).toString();
			String parts[] = tempSemicCapture.split(";");
		
		System.out.println("Array " + i + ":" + username.get(i));
		
			if(parts[0].equals(strUsername))
			{
				System.out.println("Current Username: " + parts[0]);
				System.out.println("Category: " + parts[1]);
				System.out.println("System Name: " + parts[2]);
				System.out.println("Credential Name: " + parts[3]);
				System.out.println("Credential Password: " + parts[4]);
			}
		
		}
		
		}catch(FileNotFoundException e)
		{
			System.err.println("Error");
			System.out.println(e.getMessage());
		}
	}

}
