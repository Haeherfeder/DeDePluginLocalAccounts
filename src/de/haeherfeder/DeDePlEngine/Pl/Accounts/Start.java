package de.haeherfeder.DeDePlEngine.Pl.Accounts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Start {
	public Start() throws FileNotFoundException, IOException {
		Properties pr = new Properties();
		FileInputStream input = new FileInputStream(new File("Accounts/players.txt"));
		pr.load(input);
		pr.setProperty("CurrentPlayer", "");
		FileOutputStream output = new FileOutputStream(new File("Accounts/players.txt"));
		pr.store( output , "comments");
	}
}