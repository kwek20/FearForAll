package net.castegaming.plugins.fearforall;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FearForAll extends JavaPlugin{
	
	/**
	 * Main plugin instance
	 */
	private static FearForAll plugin;
	
	/**
	 * The base prefix of messages <br/>
	 * Looks like this: [FPSCaste]
	 */
	public static final String NamePrefix = ChatColor.GRAY + "[" + ChatColor.DARK_RED + "FPS" + ChatColor.DARK_GREEN + "Caste" + ChatColor.GRAY + "] ";
	
	/**
	 * FPSCaste command handler
	 */
	FFACommandHandler commandHandler = new FFACommandHandler();
	
	public void onEnable(){
		log("---------------[FearForAll]---------------", Level.INFO);
		log("Loading all maps, configs, and creating a match", Level.INFO);
		
		
	
		/*************************************/
		long time = System.currentTimeMillis();
		plugin = this;
		
		PluginManager PM = Bukkit.getServer().getPluginManager();
		PM.registerEvents(new FFAlistener(this), this);
		/*************************************/
		
		log("Loading done. Took " + (System.currentTimeMillis()-time) + " miliseconds.", Level.INFO);
		log("----------------------------------------", Level.INFO);
	}

	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		return commandHandler.handle(sender, cmd, args);
	}
	
	private void log(String string, Level info) {
		getServer().getLogger().log(info, NamePrefix + string);
	}
}
