package de.haeherfeder.DeDePlEngine.Pl.Accounts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GenerateLogin {
	Properties p = new Properties();
	public GenerateLogin() throws IOException {
		System.out.println("create players.txt");
		File props = new File("Accounts/players.txt");
		File folder = new File("Accounts");
		folder.mkdirs();
		props.createNewFile();
		FileOutputStream os = new FileOutputStream(props);
		p.setProperty("", "");
		p.store(os, "gen File");
		os.close();
	}
}