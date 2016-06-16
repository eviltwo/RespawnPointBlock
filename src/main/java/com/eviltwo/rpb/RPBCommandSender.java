package com.eviltwo.rpb;

import org.bukkit.Bukkit;

public class RPBCommandSender {
	
	public RPBCommandSender() {
	}
	
	public void sendCommand(String commandText){
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commandText);
	}
}
