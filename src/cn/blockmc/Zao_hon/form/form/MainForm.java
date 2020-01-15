package cn.blockmc.Zao_hon.form.form;

import cn.blockmc.Zao_hon.form.element.IButton;

public class MainForm extends IFormWindow {
	public MainForm() {
		super("主菜单", "");
		IButton worldtp = new IButton("世界菜单", e -> new WorldTPForm().open(e.getPlayer()));
		IButton unknow1 = new IButton("?");
		IButton unknow2 = new IButton("?");
		IButton unknow3 = new IButton("?");
		this.addButton(worldtp);
		this.addButton(unknow1);
		this.addButton(unknow2);
		this.addButton(unknow3);
	}

}
