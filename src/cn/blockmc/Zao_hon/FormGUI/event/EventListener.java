package cn.blockmc.Zao_hon.FormGUI.event;


import cn.blockmc.Zao_hon.FormGUI.FormMenu;
import cn.blockmc.Zao_hon.FormGUI.form.MainForm;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;

public class EventListener implements Listener{
	public EventListener(FormMenu plugin) {
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getItem().getId()==Item.CLOCK) {
			MainForm form = new MainForm();
			form.open(e.getPlayer());
		}
	}
}
