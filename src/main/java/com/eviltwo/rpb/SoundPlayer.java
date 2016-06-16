package com.eviltwo.rpb;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundPlayer {
	
	public void playSound(Location location, Sound sound){
		location.getWorld().playSound(location, sound, 1.0f, 1.0f);
	}
	
	public void playSound(Player player, Sound sound){
		player.playSound(player.getLocation(), sound, 1.0f, 1.0f);
	}
	
	public void playSoundAllPlayer(Sound sound){
		Collection<? extends Player> players = Bukkit.getOnlinePlayers();
		for (Player player : players) {
			playSound(player, sound);
		}
	}
	
}
