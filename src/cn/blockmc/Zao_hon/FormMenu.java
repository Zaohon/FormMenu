package cn.blockmc.Zao_hon;

import cn.blockmc.Zao_hon.command.CommandDispatcher;
import cn.blockmc.Zao_hon.command.OpenCommand;
import cn.blockmc.Zao_hon.configuration.Config;
import cn.blockmc.Zao_hon.event.EventListener;
import cn.blockmc.Zao_hon.form.event.IFormListener;
import cn.blockmc.Zao_hon.storage.DataStorager;
import cn.blockmc.Zao_hon.storage.FileStorager;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;

public class FormMenu extends PluginBase {
	public static final String PREFIX = "¡ìbServerMenu¡ìr";
	private CommandDispatcher commandDispatcher = null;
	private DataStorager dataStorager = null;

	@Override
	public void onEnable() {
		instance = this;

		commandDispatcher = new CommandDispatcher(this, "menu");
		commandDispatcher.addCommand(new OpenCommand(this));
		
		this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
		this.getServer().getPluginManager().registerEvents(new IFormListener(), this);
		

		PR("========================");
		PR("      FormMenu          ");
		PR("     Version: " + this.getDescription().getVersion());
		PR("     Author:Zao_hon           ");
		PR("Made for:STAR FIRE BURN GRASS");
		PR("========================");
	}
	@Override
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
		return this.commandDispatcher.onCommand(sender, cmd, label, args);
		
	}
	

	public void PR(String str) {
		this.getLogger().info(str);
	}

	public void Debug(String str) {
		if (Config.DEBUG)
			PR(str);
	}

	public DataStorager getDataStorager() {
		return dataStorager;
	}

	private static FormMenu instance = null;

	public static FormMenu getInstance() {
		return instance;
	}
	
	

}
