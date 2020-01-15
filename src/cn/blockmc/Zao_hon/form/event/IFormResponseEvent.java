package cn.blockmc.Zao_hon.form.event;

import cn.blockmc.Zao_hon.form.form.IFormWindow;
import cn.nukkit.Player;

public class IFormResponseEvent{
	private final IFormWindow window;
	private final Player player;

	public IFormResponseEvent(final Player player,final IFormWindow window) {
		this.window = window;
		this.player = player;
	}

	public IFormWindow getWindow() {
		return window;
	}
	
	public Player getPlayer() {
		return player;
	}

}
