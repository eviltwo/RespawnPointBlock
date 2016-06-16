package com.eviltwo.rpb;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;

public class RPBConfigLoader {
	
	private Plugin plugin;
	private String blockName;
	private boolean isDisplayText;
	private String displayText;
	private boolean isPlaySound;
	private String soundName;
	
	public RPBConfigLoader(Plugin plugin){
		this.plugin = plugin;
		LoadConfig();
	}
	
	private void LoadConfig(){
		plugin.saveDefaultConfig();
		
		blockName = plugin.getConfig().getString("blockName").toUpperCase();
		if(Material.getMaterial(blockName)==null){
			plugin.getLogger().warning("\""+blockName+"\" block is not exist!");
			blockName = "DIAMOND_BLOCK";
		}
		isDisplayText = plugin.getConfig().getBoolean("enableDisplayText");
		displayText = plugin.getConfig().getString("displayText");
		isPlaySound = plugin.getConfig().getBoolean("enableSound");
		soundName = plugin.getConfig().getString("soundName");
		
		plugin.saveConfig();
	}
	
	public String GetSaveBlockName(){
		return blockName;
	}
	
	public boolean IsDisplayText(){
		return isDisplayText;
	}
	
	public String GetDisplayText(){
		return displayText;
	}
	
	public boolean IsPlaySound(){
		return isPlaySound;
	}
	
	public String GetSoundName() {
		return soundName;
	}
}
