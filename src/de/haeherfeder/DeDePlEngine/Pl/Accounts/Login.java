/**
 * 
 */
package de.haeherfeder.DeDePlEngine.Pl.Accounts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import de.haeherfeder.DeDePlEngine.all.*;

/**
 * @author benjamin
 *
 */
public class Login {
	public Login() {
		
	}
	FileInputStream hi = null;
	Properties p = new Properties();
	File props = new File("Accounts/players.txt");
	String Name;
	public Login(String Name) throws IOException {
		System.out.println("Login Input");
		this.Name = Name;
		if(!(props.exists())) 
		{
			System.out.println("generate");
			new GenerateLogin();
		}
		this.hi = new FileInputStream(props);
		System.out.println("fileinput");
		p.load(hi);
//		hi.close();
		if(p.containsKey(Name)) {
			Properties Pn = new Properties();
			FileInputStream P = new FileInputStream("Accounts/"+Name+".xml");
			Pn.loadFromXML(P);
			P.close();
			String CurrentWindow = Pn.getProperty("CurrentWindow");
			PluginManager manager = new PluginManager();
			manager.setStartPosition(CurrentWindow);
		}
		else {
			System.out.println("Register");
			new Register(Name);
		}
		p.setProperty("CurrentPlayer", Name);
		FileWriter writer = new FileWriter(props);
		p.store(writer, "Set current player");
		writer.close();
	}
	void setPosition(String position,String Name) throws IOException{
		Properties pr = new Properties();
		pr.load(new FileInputStream(props));
		Name = pr.getProperty("CurrentPlayer");
		p.setProperty("CurrentWindow", position);
		FileOutputStream hi = new FileOutputStream("Accounts/"+Name+".xml");
		p.storeToXML(hi, "hi"+position);
		hi.close();
	}
}