package cn.blockmc.Zao_hon.form.form;

import java.util.HashMap;
import java.util.Map;

import cn.blockmc.Zao_hon.FormMenu;
import cn.blockmc.Zao_hon.form.element.IButton;
import cn.blockmc.Zao_hon.form.event.ButtonListener;
import cn.blockmc.Zao_hon.form.event.IFormResponseEvent;
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
//
//		IButton skycity = new IButton("�յ�����", e -> e.getPlayer()
//				.teleport(FormMenu.getInstance().getServer().getLevelByName("skycity").getSpawnLocation()));
//		IButton skyisland = new IButton("�յ�", e -> e.getPlayer()
//				.teleport(FormMenu.getInstance().getServer().getLevelByName("skyisland").getSpawnLocation()));
//		IButton pve = new IButton("pve", e -> e.getPlayer()
//				.teleport(FormMenu.getInstance().getServer().getLevelByName("pve").getSpawnLocation()));
//		IButton rpg1 = new IButton("rpg1", e -> e.getPlayer()
//				.teleport(FormMenu.getInstance().getServer().getLevelByName("rpg1").getSpawnLocation()));
//		IButton zc = new IButton("zc", e -> e.getPlayer()
//				.teleport(FormMenu.getInstance().getServer().getLevelByName("zc").getSpawnLocation()));
//		IButton zhucheng = new IButton("zhucheng", e -> e.getPlayer()
//				.teleport(FormMenu.getInstance().getServer().getLevelByName("zhucheng").getSpawnLocation()));
//
//		this.addButton(skycity);
//		this.addButton(skyisland);
//		this.addButton(pve);
//		this.addButton(rpg1);
//		this.addButton(zc);
//		this.addButton(zhucheng);
	}

	private class WorldTPButtonListener implements ButtonListener {
		private Level level;

		WorldTPButtonListener(Level level) {
			this.level = level;
		}

		@Override
		public void onResponse(IFormResponseEvent e) {
			e.getPlayer().teleport(level.getSpawnLocation());

		}

	}

}
