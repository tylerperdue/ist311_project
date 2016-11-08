import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddCredentialsController{

	String strSysName;
	String strCategory;
	String newUsername; 
	char[] newPassword;
	LoggedInUser loggedUser;
	boolean added = false;

	public AddCredentialsController(String ct, LoggedInUser lu, String sysN, String nU, char[] nP){
		this.strCategory = ct;
		this.newUsername = nU; 
		this.newPassword = nP;
		this.loggedUser = lu;
		this.strSysName = sysN;
	}

	public boolean addCredential(){
		String passwordString = new String(newPassword);
		String categoryString = new String(strCategory);
		String SystemNameString = new String(strSysName);
		boolean credentialExists = false;
		String user = loggedUser.getUser();
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("CREDENTIALS.txt", true)));
			out.print(user + ";");
			out.print(categoryString + ";");
			out.print(SystemNameString + ";");
			out.print(newUsername + ";");
			out.print(passwordString);
			out.println();
			out.close();
			added = true;
    	}
        catch (FileNotFoundException e) {
            System.out.print("FileNotFoundException: ");
            System.out.println(e.getMessage());
		}
		catch (IOException ie) {
			System.out.print("IOException: ");
            System.out.println(ie.getMessage());
		}
		return added;
	}
}

