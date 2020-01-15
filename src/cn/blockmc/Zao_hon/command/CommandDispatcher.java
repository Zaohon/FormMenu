package cn.blockmc.Zao_hon.command;

import java.util.HashSet;
import java.util.Set;

import cn.blockmc.Zao_hon.FormMenu;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;

public class CommandDispatcher implements CommandExecutor {
	private final String cmdName;
	private FormMenu plugin;
	private Set<ICommand> commands = new HashSet<ICommand>();

	public CommandDispatcher(final FormMenu plugin, final String cmdName) {
		this.plugin = plugin;
		this.cmdName = cmdName;
	}

	public void addCommand(ICommand command) {
		commands.add(command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!cmd.getName().equalsIgnoreCase(cmdName))
			return false;

		String subcmd = args[0];
		ICommand subCommand = findCommand(subcmd);
		subCommand = subCommand == null ? findCommandByAliases(subcmd) : subCommand;

		if (subCommand == null) {
			return true;
		}

		String[] subArgs = new String[args.length - 1];
		for (int i = 1; i < args.length; i++) {
			subArgs[i - 1] = args[i];
		}

		return subCommand.onCommand(sender, label, subArgs);
	}

	private ICommand findCommand(String cmdName) {
		for (ICommand command : commands) {
			if (command.getName().equals(cmdName))
				return command;
		}
		return null;
	}

	private ICommand findCommandByAliases(String cmdName) {
		for (ICommand command : commands) {
			String[] aliaces = command.getAliases();
			if (aliaces != null) {
				for (String aliace : command.getAliases()) {
					if (aliace.equals(cmdName))
						return command;
				}
			}
		}
		return null;
	}

}
