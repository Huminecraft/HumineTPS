package com.huminecraft.huminetps;

import java.util.logging.Level;

import org.bukkit.Bukkit;
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
	Bukkit.getServer().getScheduler().runTaskTimer(this, new Runnable() {

	    long secstart;
	    long secend;

	    int ticks;

	    @Override
	    public void run() {
		secstart = (System.currentTimeMillis() / 1000);

		if (secstart == secend) {
		    ticks++;
		} else {
		    secend = secstart;
		    tps = (tps == 0) ? ticks : ((tps + ticks) / 2);
		    ticks = 1;
		}
	    }

	}, 0, 1);
	
	Bukkit.getServer().getScheduler().runTaskTimer(this, new Runnable() {
	    @Override
	    public void run() {
		if (tps < 18.5) {
		    Bukkit.getServer().shutdown();
		}
		consoleLog(Level.INFO, "Current TPS : " + Math.round(tps));
	    }

	}, 1200, 1200);
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
