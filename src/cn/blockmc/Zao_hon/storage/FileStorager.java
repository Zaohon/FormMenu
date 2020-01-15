package cn.blockmc.Zao_hon.storage;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.blockmc.Zao_hon.FormMenu;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.ConfigSection;

public class FileStorager extends DataStorager {
	private static final String FOLDER = "menus";
	private FormMenu plugin;
	private File folder;

	public FileStorager(FormMenu plugin) {
		this.plugin = plugin;
		this.folder = new File(plugin.getDataFolder(), FOLDER);
		if (!folder.exists()) {
			plugin.Debug("创建初始菜单...");
			folder.mkdir();
			plugin.saveResource("menus/default-menu.yml");
		}
	}

}
