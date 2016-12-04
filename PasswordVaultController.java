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
	
	public String[] getWebsites(String strCategory)
	{
	
		String[] empty = {};
		ArrayList<String> username = new ArrayList<String>();
		ArrayList<String> category = new ArrayList<String>();
		String tempSemicCapture;
		String tempLine;
		String tempWord;
		int count = 0;

		try{
			
		Scanner fileIn = new Scanner(new File("CREDENTIALS.txt"));

		
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
		
			if(parts[0].equals(strUsername))
			{
				if(strCategory.equals(parts[1]))
				{
				count++;		
				category.add(parts[2].toString());
				System.out.println(category.size());
				}
				else{
				System.out.println("Not the same category");
				}

			}

		}
		
		String[] strCategories = new String[count];
		for(int j = 0; j < category.size(); j++)
		{
			System.out.println(category.get(j));
			tempWord = category.get(j);
			System.out.println("temp word = " + tempWord);
			strCategories[j] = tempWord;
		}
		
		fileIn.close();
		return strCategories;
		
		
		}catch(FileNotFoundException e)
		{
			System.err.println("Error");
			System.out.println(e.getMessage());
		}
		
		return empty;

	}
	
	
	public String getUsername(String strCategory, String strWebsiteName)
	{
		
//		String strUsername = "";
		
		
		String[] empty = {};
		ArrayList<String> username = new ArrayList<String>();
		ArrayList<String> category = new ArrayList<String>();
		String tempSemicCapture;
		String tempLine;
		String tempWord;
		String tempUsername = "";
		
		int count = 0;

		try{
			
		Scanner fileIn = new Scanner(new File("CREDENTIALS.txt"));

		
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
			
		
			if(parts[0].equals(strUsername))
			{
				if(strCategory.equals(parts[1]))
				{
				count++;		
				category.add(parts[2].toString());
			
				for (int j = 0; j < category.size(); j++)
				{
					if(category.get(j).equals(strWebsiteName))
					{
						tempUsername = parts[3];
						return tempUsername;
					}
				}
				System.out.println(category.size());
				}
				else{
//				System.out.println("Not the same category");
				}

			}

		}
		
		String[] strCategories = new String[count];
		for(int j = 0; j < category.size(); j++)
		{
			System.out.println(category.get(j));
			tempWord = category.get(j);
			System.out.println("temp word = " + tempWord);
			strCategories[j] = tempWord;
		}
		
		fileIn.close();
		
		
		return tempUsername;
		
		
		}catch(FileNotFoundException e)
		{
			System.err.println("Error");
			System.out.println(e.getMessage());
		}
		
		return strUsername;
	}
	
	public String getPassword(String strCategory, String strWebsiteName)
	{
		
//		String strUsername = "";
		
		
		String[] empty = {};
		ArrayList<String> username = new ArrayList<String>();
		ArrayList<String> category = new ArrayList<String>();
		String tempSemicCapture;
		String tempLine;
		String tempWord;
		String tempUsername = "";
		
		int count = 0;

		try{
			
		Scanner fileIn = new Scanner(new File("CREDENTIALS.txt"));

		
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
			
		
			if(parts[0].equals(strUsername))
			{
				if(strCategory.equals(parts[1]))
				{
				count++;		
				category.add(parts[2].toString());
			
				for (int j = 0; j < category.size(); j++)
				{
					if(category.get(j).equals(strWebsiteName))
					{
						tempUsername = parts[4];
						return tempUsername;
					}
				}
				System.out.println(category.size());
				}
				else{
//				System.out.println("Not the same category");
				}

			}

		}
		
		String[] strCategories = new String[count];
		for(int j = 0; j < category.size(); j++)
		{
			System.out.println(category.get(j));
			tempWord = category.get(j);
			System.out.println("temp word = " + tempWord);
			strCategories[j] = tempWord;
		}
		
		fileIn.close();
		
		return tempUsername;
		
		
		}catch(FileNotFoundException e)
		{
			System.err.println("Error");
			System.out.println(e.getMessage());
		}
		
		return strUsername;
	}
	
	public int getCredentialsLength()
	{
		
		int count = 0;
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
			
				if(parts[0].equals(strUsername))
				{
					count++;
				
				}
				fileIn.close();
			
			}
			
			}catch(FileNotFoundException e)
			{
				System.err.println("Error");
				System.out.println(e.getMessage());
			}
	
		return count;
	}


}
