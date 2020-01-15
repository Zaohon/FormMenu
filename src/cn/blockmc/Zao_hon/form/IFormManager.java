package cn.blockmc.Zao_hon.form;

import cn.blockmc.Zao_hon.form.element.IButton;
import cn.blockmc.Zao_hon.form.event.IFormResponseEvent;
import cn.blockmc.Zao_hon.form.form.IFormWindow;
import cn.nukkit.Player;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.response.FormResponseSimple;

public class IFormManager {
	public static void handle(Player player, IFormWindow window) {
		FormResponseSimple response = window.getResponse();
		ElementButton button = response.getClickedButton();
		if(!(button instanceof IButton))return;
		IButton iButton = (IButton) button;
		if (iButton.getListener()==null)return;
		IFormResponseEvent event = new IFormResponseEvent(player,window);
		iButton.getListener().onResponse(event);
	}

}
