/**
 * 
 */
package de.haeherfeder.DeDePlEngine.Pl.Accounts;
import java.io.IOException;

import de.haeherfeder.DeDePlEngine.all.*;




/**
 * @author benjamin 
 *
 */
public class Main implements IPlugin{
	String GameVersion = null;
	private PluginManager manager;
	String Name;
	@Override
	public void GameStart() {
		// TODO Auto-generated method stub
	}
	@Override
	public void GameWindowStart(String arg0) {
		// TODO Auto-generated method stub
		manager.SinglePosition("Login");
//		manager.setStartPosition("Login");
	}
	@Override
	public void PlayerInput(String arg0,String pos) {
		// TODO Auto-generated method stub
		if(pos=="Login") {
			try {
				this.Name = arg0;
				System.out.println("Name: "+Name);
				new Login(Name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Login failed");
			}
		}
	}
	@Override
	public boolean setEngineVersion(String arg0) {
		// TODO Auto-generated method stub
		this.GameVersion = arg0;
		return true;
	}

	public void setPluginManager(PluginManager manager) {
	    this.manager = manager;
	}

	@Override
	public boolean start() {
		// TODO Auto-generated method stub
		try {
			new Start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendPosition(String arg0) {
		// TODO Auto-generated method stub
		try {
			new Login().setPosition(arg0, Name);
			System.out.println("Login set position");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}