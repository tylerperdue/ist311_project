package credentialmanagementapplication;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationController{

	String username; 
	char[] password;
	char[] verifyPassword;
	String result;

	public RegistrationController(String u, char[] p, char[] vp){
		this.username = u; 
		this.password = p;
		this.verifyPassword = vp;
	}

	public String register(){
		String passwordString = new String(password);
		String verifyPasswordString = new String(verifyPassword);
		boolean usernameExists = false;
		try{
			File file = new File("USERLIST.txt");
			Scanner fileScanner = new Scanner(file);
			ArrayList<String> usernames = new ArrayList<String>();
			while(fileScanner.hasNextLine()){
				String tempLine = fileScanner.nextLine();
				String[] tempLineArray = tempLine.split(";");
				usernames.add(tempLineArray[0]);
			}
			for(int i = 0; i < usernames.size(); i++){
				if(username.equals(usernames.get(i))){
					usernameExists = true;
					result = "usernameExists";
				}
			}
		}catch(FileNotFoundException e) {
	        System.out.print("FileNotFoundException: ");
	        System.out.println(e.getMessage());
    	}
		if(passwordString.equals(verifyPasswordString) && !usernameExists){
			try {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USERLIST.txt", true)));
				out.print(username + ";");
				out.print(passwordString);
				out.println();
				out.close();
				result = "registered";
        	}
	        catch (FileNotFoundException e) {
	            System.out.print("FileNotFoundException: ");
	            System.out.println(e.getMessage());
    		}
    		catch (IOException ie) {
    			System.out.print("IOException: ");
	            System.out.println(ie.getMessage());
    		}
		}else if(!passwordString.equals(verifyPasswordString)){
			 result = "pwds don't match";
		}
		return result;
	}
}
