package com.eviltwo.rpb;

import org.bukkit.plugin.java.JavaPlugin;

public class RPB extends JavaPlugin {
	
	public RPBConfigLoader configLoader;
	public RPBCommandSender commandSender;
	
	@Override
	public void onEnable() {
		configLoader = new RPBConfigLoader(this);
		commandSender = new RPBCommandSender();
		getServer().getPluginManager().registerEvents(new RPBEventListener(this),this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
