package com.huminecraft.huminetps.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.huminecraft.huminetps.HumineTPS;

public class EnableCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
	    sender.sendMessage("Command inconnue : utilisez /tps enable pour activer et /tps disable pour désactiver");
	} else if (args[0].equalsIgnoreCase("enable") && HumineTPS.getInstance().isTPSEnabled() == false) {
	    HumineTPS.getInstance().enableTPS(true);
	} else if (args[0].equalsIgnoreCase("disabled") && HumineTPS.getInstance().isTPSEnabled() == true) {
	    HumineTPS.getInstance().enableTPS(false);
	} else if ((args[0].equalsIgnoreCase("enable") && HumineTPS.getInstance().isTPSEnabled() == true)
		|| ((args[0].equalsIgnoreCase("disabled") && HumineTPS.getInstance().isTPSEnabled() == false))) {
	    sender.sendMessage("Le moniteur de TPS est déja " + HumineTPS.getInstance().isTPSEnabled());
	}

	return true;
    }

}
