import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserAccountController{

	String username; 
	char[] oldPassword;
	char[] newPassword;
	char[] newVerifyPassword;
	String result;
	boolean accountExists = false;

	public UserAccountController(String u, char[] oP, char[] nP, char[] vP){
		this.username = u; 
		this.oldPassword = oP;
		this.newPassword = nP;
		this.newVerifyPassword = vP;
	}

	public String update(){
		// Convert Password Char Fields to Usable Strings
		String oldPasswordString = new String(oldPassword);
		String newPasswordString = new String(newPassword);
		String verifyPasswordString = new String(newVerifyPassword);
		// Array List to save contents of the current file
		ArrayList<String> currentFile = new ArrayList<String>();

		if(!newPasswordString.equals(verifyPasswordString)){
			result = "Passwords don't match";
		}else{
			try{
				// Read the current file and save its contents line by line to the Array List
				File file = new File("USERLIST.txt");
				Scanner fileScanner = new Scanner(file);
				while(fileScanner.hasNextLine()){
					String tempLine = fileScanner.nextLine();
					currentFile.add(tempLine);
				}
				for(int i = 0; i < currentFile.size(); i++){
					if((username+";"+oldPasswordString).equals(currentFile.get(i))){
						accountExists = true;
					}else{
						result = "Current password is incorrect.";
					}
				}
				// Print writer to write to new file - overwriting old USERLIST.txt textfile 
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USERLIST.txt", false)));
				// If the username matches in the old text file, update the password
				for(int i = 0; i < currentFile.size(); i++){
					if(currentFile.get(i).equals(username+";"+oldPasswordString) && accountExists){
						currentFile.set(i, username + ";" + newPasswordString);
					}
					out.println(currentFile.get(i));
				}
				out.close();
				result = "OK";
			}catch(FileNotFoundException e) {
		        System.out.print("FileNotFoundException: ");
		        System.out.println(e.getMessage());
	    	}
	    	catch (IOException ie) {
	    		System.out.print("IOException: ");
		        System.out.println(ie.getMessage());
	    	}
		}
		return result;
	}
}
