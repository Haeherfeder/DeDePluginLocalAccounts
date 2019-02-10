package de.haeherfeder.DeDePlEngine.Pl.Accounts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import de.haeherfeder.DeDePlEngine.all.PluginManager;

public class Register {
	Properties pPlayers = new Properties();
	File players = new File("Accounts/players.txt");
	PluginManager manager  = new PluginManager();
	public Register(String Name) throws IOException {
		File player = new File("Accounts/"+Name+".xml");
		player.createNewFile();
		if(!players.exists()) {players.createNewFile();}
		try {
			FileInputStream Players = new FileInputStream(players);
			pPlayers.load(Players);
			Players.close();
			System.out.println("read players file");
			pPlayers.setProperty(Name, "true");
			FileOutputStream PlayersOu = new FileOutputStream(players);
			pPlayers.store(PlayersOu,"Added"+Name);
			System.out.println(PlayersOu);
			PlayersOu.close();
			System.out.println("write players file");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Not save player=true");
			e.printStackTrace();
		}
		Properties Pn = new Properties();
		/*try {
			FileInputStream P = new FileInputStream(player);
			Pn.loadFromXML(P);
			P.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Pn.setProperty("CurrentWindow", manager.getStory("FirstP"));
		FileOutputStream out = new FileOutputStream(player);
		Pn.storeToXML(out, Name);
		out.close();	
	}
}