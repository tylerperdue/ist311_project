
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class SearchWindowController 
{
    String searchTerm;
    
    SearchWindowController(String st)
    {
        searchTerm = st;
        search(searchTerm);
    }
    
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
}
