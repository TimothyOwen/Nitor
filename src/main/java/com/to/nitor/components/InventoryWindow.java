package com.to.nitor.components;

import java.util.List;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.gui2.table.Table;
import com.to.nitor.domain.Item;
import com.to.nitor.utils.DBUtils;

public class InventoryWindow extends BasicWindow {
	public InventoryWindow(final WindowBasedTextGUI textGUI) {
		super("Inventory");
		
		DBUtils dbutils = new DBUtils("jdbc:mysql://localhost:3306/nitor","root","root");
		
		dbutils.getConnection();
		
		List<Item> items = dbutils.readAll();
		
		Panel containerPanel = new Panel(new GridLayout(1));
		Table<String> table = new Table<String>("Crop", "Quantity", "Id");
		for(Item item: items) {
			table.getTableModel().addRow(item.getName(),
										String.valueOf(item.getQuantity()),
										String.valueOf(item.getId()));
		}
		
		dbutils.closeConnection();
		
		new Button("Back", new Runnable() {
        	public void run() {
        		Window activeWindow = textGUI.getActiveWindow();
    			textGUI.removeWindow(activeWindow);
    			textGUI.addWindowAndWait(new MenuWindow(textGUI));
        	}
        }).addTo(containerPanel);
		
		new Button("Add Item", new Runnable() {
        	public void run() {
        		Window activeWindow = textGUI.getActiveWindow();
    			textGUI.removeWindow(activeWindow);
    			textGUI.addWindowAndWait(new InventoryWindow(textGUI));
        	}
        }).addTo(containerPanel);
		
		containerPanel.addComponent(table);
		setComponent(containerPanel);
	}
}