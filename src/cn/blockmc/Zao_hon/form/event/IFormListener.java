package cn.blockmc.Zao_hon.form.event;

import cn.blockmc.Zao_hon.form.IFormManager;
import cn.blockmc.Zao_hon.form.form.IFormWindow;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindow;

public class IFormListener implements Listener {
	@EventHandler
	public void onResponse(PlayerFormRespondedEvent event) {
		Player player = event.getPlayer();
		FormWindow window = event.getWindow();
		if (!(window instanceof IFormWindow) || window.wasClosed())
			return;
		IFormManager.handle(player, (IFormWindow) window);
	}

}
