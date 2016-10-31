import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class LoginController{

	String username; 
	char[] password;
	boolean authenticated;

	public LoginController(String u, char[] p){
		this.username = u; 
		this.password = p;
	}

	public boolean authenticate(){
		System.out.println("Login");
		try{
			File file = new File("USERLIST.txt");
			Scanner fileScanner = new Scanner(file);
			ArrayList<String> usernamesAndPasswords = new ArrayList<String>();
			String passwordString = new String(password);
			authenticated = false;
			while(fileScanner.hasNextLine()){
				usernamesAndPasswords.add(fileScanner.nextLine());
			}
			for(int i = 0; i < usernamesAndPasswords.size(); i++){
				if((username+";"+passwordString).equals(usernamesAndPasswords.get(i))){
					authenticated = true;
				}
			}
		}catch(FileNotFoundException e) {
	        System.out.print("FileNotFoundException: ");
	        System.out.println(e.getMessage());
    	}
    	return authenticated;
	}
}
