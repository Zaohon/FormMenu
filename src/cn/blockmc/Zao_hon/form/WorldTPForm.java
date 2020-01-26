package cn.blockmc.Zao_hon.form;

import java.util.HashMap;
import java.util.Map;

import cn.blockmc.Zao_hon.FormMenu;
import cn.blockmc.Zao_hon.form.element.IButton;
import cn.blockmc.Zao_hon.form.event.IFormButtonClickedEvent;
import cn.blockmc.Zao_hon.form.listener.ButtonListener;
import cn.nukkit.level.Level;

public class WorldTPForm extends IFormWindow {
	@SuppressWarnings("serial")
	public Map<String, String> world = new HashMap<String, String>() {
		{
			this.put("skycity", "�յ�����");
			this.put("skyisland", "�յ�������");
			this.put("pve", "pve");
			this.put("rpg1", "rpg1");
			this.put("zc", "zc");
			this.put("zhucheng", "zhucheng");
			this.put("rpg", "rpg1");
			this.put("����ģ����", "����ģ����");
		}
	};

	public WorldTPForm() {
		super("���紫�Ͳ˵�", "");

		world.entrySet().forEach(entry -> {
			if (!FormMenu.getInstance().getServer().isLevelLoaded(entry.getKey()))
				FormMenu.getInstance().getServer().loadLevel(entry.getKey());
			IButton button = new IButton(entry.getValue());
			button.setListener(
					new WorldTPButtonListener(FormMenu.getInstance().getServer().getLevelByName(entry.getKey())));
			this.addButton(button);
		});
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
