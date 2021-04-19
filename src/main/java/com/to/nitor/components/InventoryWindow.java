package com.to.nitor.components;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.table.Table;

public class InventoryWindow extends BasicWindow {
	public InventoryWindow() {
		super("Inventory");
		Panel containerPanel = new Panel(new GridLayout(4));
		Table<String> table = new Table<String>("Crop", "Quantity", "Id");
		table.getTableModel().addRow("Beetroot","2", "0540");
		table.getTableModel().addRow("Potato","5", "9348");
		table.getTableModel().addRow("Onion","1", "3985");
		table.getTableModel().addRow("Mushroom","3", "1232");
		table.getTableModel().addRow("Leek","10", "3124");
		containerPanel.addComponent(table);
		setComponent(containerPanel);
	}
}