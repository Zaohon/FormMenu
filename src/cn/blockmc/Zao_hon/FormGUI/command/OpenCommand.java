package cn.blockmc.Zao_hon.FormGUI.command;

import java.util.List;
import java.util.Map;

import cn.blockmc.Zao_hon.FormGUI.FormMenu;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

public class OpenCommand implements ICommand {
	private FormMenu plugin;

	public OpenCommand(FormMenu plugin) {
		this.plugin = plugin;
	}

	@Override
	public String getName() {
		return "open";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public String[] getUsageString(String label, CommandSender sender) {

		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canBeConsole() {
		return false;
	}

	@Override
	public boolean canBeCommandBlock() {
		return false;
	}

	@Override
	public boolean onCommand(CommandSender sender, String label, String[] args) {
		Player player = (Player) sender;
		String menuName = args[0];
		
		
		return true;
	}

}
