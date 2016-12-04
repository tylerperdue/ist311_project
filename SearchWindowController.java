
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class SearchWindowController 
{
    String sCategory;
    String strUsername;
    SearchWindowController(String currentUsername, String Category)
    {
        sCategory = Category;
        strUsername = currentUsername;
    }
    
    public void getTest(String strCategory, int index)
	{
		
//		String strUsername = "";
		
		
		String[] empty = {};
		ArrayList<String> username = new ArrayList<String>();
		ArrayList<String> category = new ArrayList<String>();
		String tempSemicCapture;
		String tempLine;
		String tempWord;
		String tempUsername = "";
		
		String[] strTestl;
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
						tempUsername = parts[2]; 
						System.out.println("tempUsername = " + tempUsername );
					
				}
				
				System.out.println("Index 1 = ");
				System.out.println("Index = " + index + " --- " + category.get(index).toString());
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
		
		
		
		
		}catch(FileNotFoundException e)
		{
			System.err.println("Error");
			System.out.println(e.getMessage());
		}
		
	}     
    
    
	public String getWebsite(String strCategory, int index)
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
						tempUsername = parts[2]; 
						return tempUsername;
					
				}
				
				System.out.println("Index" + category.get(index));
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
    
	
	public String[] getWebsite(String strCategory)
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
	
	public String[] getUsername(String strCategory)
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
				category.add(parts[3].toString());
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
	
//	public String getUsername(String strCategory, int index)
//	{
//		
////		String strUsername = "";
//		
//		
//		String[] empty = {};
//		ArrayList<String> username = new ArrayList<String>();
//		ArrayList<String> category = new ArrayList<String>();
//		String tempSemicCapture;
//		String tempLine;
//		String tempWord;
//		String tempUsername = "";
//		
//		int count = 0;
//
//		try{
//			
//		Scanner fileIn = new Scanner(new File("CREDENTIALS.txt"));
//
//		
//		while(fileIn.hasNextLine())
//		{
//			tempLine = fileIn.nextLine().toString(); // store the line in tempLine variable
//			if(!(tempLine.isEmpty()))	// if the tempLine is not empty, then add tempLine to the ArrayList
//			username.add(tempLine);
//		}
//		
//		for(int i = 0; i < username.size(); i++)
//		{
//			
//			tempSemicCapture = username.get(i).toString();
//			String parts[] = tempSemicCapture.split(";");
//			
//		
//			if(parts[0].equals(strUsername))
//			{
//				if(strCategory.equals(parts[1]))
//				{
//				count++;		
//				category.add(parts[2].toString());
//			
//				for (int j = 0; j < category.size(); j++)
//				{
//						tempUsername = parts[3];
//						return tempUsername;
//					
//				}
//				System.out.println(category.size());
//				}
//				else{
////				System.out.println("Not the same category");
//				}
//
//			}
//
//		}
//		
//		String[] strCategories = new String[count];
//		for(int j = 0; j < category.size(); j++)
//		{
//			System.out.println(category.get(j));
//			tempWord = category.get(j);
//			System.out.println("temp word = " + tempWord);
//			strCategories[j] = tempWord;
//		}
//		
//		fileIn.close();
//		
//		
//		return tempUsername;
//		
//		
//		}catch(FileNotFoundException e)
//		{
//			System.err.println("Error");
//			System.out.println(e.getMessage());
//		}
//		
//		return strUsername;
//	}
//    
    
    String search(String searchWord)
    {
        File file = new File("searchTestFile.txt");
        Scanner scanner;
        
        try 
        {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) 
            {
                String lineFromFile = scanner.nextLine();
                if (lineFromFile.contains(searchWord)) {
                    // found
                    System.out.println("I found " + searchWord);
                    break;
                }
            }
        } 
        catch (IOException e)
        {
            System.out.println(" cannot write to file " + file.toString());
        }  
        return "";
    }
    
	public int getCredentialsLength(String Category)
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
					if(parts[1].equals(Category))
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
