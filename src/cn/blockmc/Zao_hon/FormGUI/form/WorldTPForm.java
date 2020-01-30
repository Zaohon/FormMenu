package cn.blockmc.Zao_hon.FormGUI.form;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import cn.blockmc.Zao_hon.FormGUI.FormMenu;
import cn.blockmc.Zao_hon.form.IFormWindow;
import cn.blockmc.Zao_hon.form.element.IButton;
import cn.blockmc.Zao_hon.form.event.IFormButtonClickedEvent;
import cn.blockmc.Zao_hon.form.listener.ButtonListener;
import cn.nukkit.level.Level;

public class WorldTPForm extends IFormWindow {
	@SuppressWarnings("serial")
	public Map<String, String> world = new HashMap<String, String>() {
		{
			this.put("skycity", "空岛主城");
			this.put("skyisland", "空岛居民区");
			this.put("pve", "pve");
			this.put("rpg1", "rpg1");
			this.put("zc", "zc");
			this.put("zhucheng", "zhucheng");
			this.put("rpg", "rpg1");
		}
	};

	public WorldTPForm() {
		super("世界传送菜单", "世界传送");

		for (Entry<String, String> entry : world.entrySet()) {
			if (!FormMenu.getInstance().getServer().isLevelLoaded(entry.getKey()))
				if (!FormMenu.getInstance().getServer().loadLevel(entry.getKey())) {
					continue;
				}
			IButton button = new IButton(entry.getValue());
			button.setListener(
					new WorldTPButtonListener(FormMenu.getInstance().getServer().getLevelByName(entry.getKey())));
			this.addButton(button);
		}
	}

	private class WorldTPButtonListener implements ButtonListener {
		private Level level;

		WorldTPButtonListener(Level level) {
			this.level = level;
		}

		@Override
		public void onClicked(IFormButtonClickedEvent e) {
			e.getPlayer().teleport(level.getSpawnLocation());

		}

	}

}
