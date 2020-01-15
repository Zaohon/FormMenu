package cn.blockmc.Zao_hon.form.form;

import cn.blockmc.Zao_hon.FormMenu;
import cn.blockmc.Zao_hon.form.element.IButton;

public class WorldTPForm extends IFormWindow {
	public WorldTPForm() {
		super("世界传送菜单", "");

		if (!FormMenu.getInstance().getServer().isLevelLoaded("skycity"))
			FormMenu.getInstance().getServer().loadLevel("skycity");
		if (!FormMenu.getInstance().getServer().isLevelLoaded("skyisland"))
			FormMenu.getInstance().getServer().loadLevel("skyisland");
		if (!FormMenu.getInstance().getServer().isLevelLoaded("pve"))
			FormMenu.getInstance().getServer().loadLevel("pve");
		if (!FormMenu.getInstance().getServer().isLevelLoaded("rpg1"))
			FormMenu.getInstance().getServer().loadLevel("rpg1");
		if (!FormMenu.getInstance().getServer().isLevelLoaded("zc"))
			FormMenu.getInstance().getServer().loadLevel("zc");
		if (!FormMenu.getInstance().getServer().isLevelLoaded("zhucheng"))
			FormMenu.getInstance().getServer().loadLevel("zhucheng");

		IButton skycity = new IButton("空岛主城", e -> e.getPlayer()
				.teleport(FormMenu.getInstance().getServer().getLevelByName("skycity").getSpawnLocation()));
		IButton skyisland = new IButton("空岛", e -> e.getPlayer()
				.teleport(FormMenu.getInstance().getServer().getLevelByName("skyisland").getSpawnLocation()));
		IButton pve = new IButton("pve", e -> e.getPlayer()
				.teleport(FormMenu.getInstance().getServer().getLevelByName("pve").getSpawnLocation()));
		IButton rpg1 = new IButton("rpg1", e -> e.getPlayer()
				.teleport(FormMenu.getInstance().getServer().getLevelByName("rpg1").getSpawnLocation()));
		IButton zc = new IButton("zc", e -> e.getPlayer()
				.teleport(FormMenu.getInstance().getServer().getLevelByName("zc").getSpawnLocation()));
		IButton zhucheng = new IButton("zhucheng", e -> e.getPlayer()
				.teleport(FormMenu.getInstance().getServer().getLevelByName("zhucheng").getSpawnLocation()));

		this.addButton(skycity);
		this.addButton(skyisland);
		this.addButton(pve);
		this.addButton(rpg1);
		this.addButton(zc);
		this.addButton(zhucheng);
	}

}
