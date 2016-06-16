package com.eviltwo.rpb;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RPBCommandExcutor implements CommandExecutor {
	/*
	private final RPB plugin;
	 
	public RPBCommandExcutor(RPB plugin) {
		this.plugin = plugin;
	}
	*/
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("rpb")) {
			if(args.length >= 1){
				if(args[0].equals("test")){
					return true;
				}
			}
		}
		return false;
	}
}
