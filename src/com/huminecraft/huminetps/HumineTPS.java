package com.huminecraft.huminetps;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import com.huminecraft.huminetps.commands.EnableCommand;

public class HumineTPS extends JavaPlugin {
    public static HumineTPS instance;
    public boolean enabled = true;
    private final String VERSION = "1.0.0";
    private double tps;

    public static HumineTPS getInstance() {
	return HumineTPS.instance;
    }

    public void onEnable() {
	consoleLog(Level.INFO, "Humine TPS " + VERSION + " by SDA loaded.");
	getCommand("tpsEnable").setExecutor(new EnableCommand());
	getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
	    long sec;
	    long currentSec;
	    int ticks;
	    @Override
	    public void run() {
		if (enabled) {
		    sec = (System.currentTimeMillis() / 1000);

		    if (currentSec == sec) {
			ticks++;
		    } else {
			currentSec = sec;
			tps = (tps == 0 ? ticks : ((tps + ticks) / 2));
			ticks = 0;
		    }
		    
		    consoleLog(Level.INFO, "Current tps : " + tps);
		    
		    if (tps < 18.50) {
			HumineTPS.getInstance().getServer().dispatchCommand(HumineTPS.getInstance().getServer().getConsoleSender(), "restart");
		    }
		}
	   }
	},0,60);
    }

    public void onDisable() {

    }

    public boolean isTPSEnabled() {
	return enabled;
    }
    
    public void enableTPS(boolean bool) {
	this.enabled = bool;
    }
    
    public void consoleLog(Level level, String message) {
	this.getServer().getLogger().log(level, message);
    }

}
