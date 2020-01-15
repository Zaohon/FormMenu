package cn.blockmc.Zao_hon.form.form;

import java.util.ArrayList;
import java.util.List;

import cn.blockmc.Zao_hon.form.element.IButton;
import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindowSimple;

public class IFormWindow extends FormWindowSimple {

	private List<IButton> iButtons = new ArrayList<IButton>();

	public IFormWindow(String title, String context) {
		super(title, context);
	}

	public void addButton(IButton button) {
		super.addButton(button);
		iButtons.add(button);
	}

	public void deleteButton(IButton button) {
		iButtons.remove(button);
	}

	public void open(Player player) {
		player.showFormWindow(this);
	}

	public List<IButton> getIButtons() {
		return iButtons;
	}

}
