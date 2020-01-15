package cn.blockmc.Zao_hon.form.element;

import cn.blockmc.Zao_hon.form.event.ButtonListener;
import cn.nukkit.form.element.ElementButton;

public class IButton extends ElementButton {
	private ButtonListener listener;

	public IButton(String text) {
		super(text);
	}

	public IButton(String text, ButtonListener listener) {
		super(text);
		this.listener = listener;
	}

	public ButtonListener getListener() {
		return listener;
	}

	public void setListener(ButtonListener listener) {
		this.listener = listener;
	}

}
