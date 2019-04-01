package com.huminecraft.huminetps;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

public class HumineTPS extends JavaPlugin {
    public static HumineTPS instance;
    private final String VERSION = "1.0.0";

    public static HumineTPS getInstance() {
    	return HumineTPS.instance;
    }	
	public void onEnable() {
		consoleLog(Level.INFO, "Humine TPS " + VERSION + " by SDA loaded.");
	}
	
	public void onDisable() {
		
	}

    public void consoleLog(Level level, String message) {
    	this.getServer().getLogger().log(level, message);
    }		

}
