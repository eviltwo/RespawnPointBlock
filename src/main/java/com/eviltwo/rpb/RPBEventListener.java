package com.eviltwo.rpb;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class RPBEventListener implements Listener {
	
	private final RPB plugin;
	private TitleSender titleSender;
	private SoundPlayer soundPlayer;
	
	public RPBEventListener(RPB plugin){
		this.plugin = plugin;
		titleSender = new TitleSender();
		soundPlayer = new SoundPlayer();
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		Player player = e.getPlayer();
		if(player.isFlying()){
			return;
		}
		Location loc = player.getLocation();
		Location b_loc = new Location(player.getWorld(), loc.getX(), loc.getY()-1, loc.getZ());
		if(b_loc.getBlock().getType().equals(Material.valueOf(plugin.configLoader.GetSaveBlockName())) == false){
			return;
		}
		Location l = new Location(player.getWorld(), 0, 0, 0);
		l.setX(Math.floor(loc.getX())+0.5);
		l.setY(Math.floor(loc.getY()));
		l.setZ(Math.floor(loc.getZ())+0.5);
		if(player.getBedSpawnLocation() != null){
			Location r_loc = player.getBedSpawnLocation();
			Location r = new Location(player.getWorld(), 0, 0, 0);
			r.setX(Math.floor(r_loc.getX())+0.5);
			r.setY(Math.floor(r_loc.getY()));
			r.setZ(Math.floor(r_loc.getZ())+0.5);
			if(l.getX()==r.getX()&&l.getY()==r.getY()&&l.getZ()==r.getZ()){
				return;
			}
		}
		player.setBedSpawnLocation(loc, true);
		if(plugin.configLoader.IsDisplayText()){
			titleSender.setTime_second(player, 0.2, 1.0, 2.0);
			titleSender.sendTitle(player, null, plugin.configLoader.GetDisplayText());
		}
		if(plugin.configLoader.IsPlaySound()){
			soundPlayer.playSound(player, Sound.valueOf(plugin.configLoader.GetSoundName()));
		}
	}
}
