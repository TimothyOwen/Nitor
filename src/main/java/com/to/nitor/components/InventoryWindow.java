package com.to.nitor.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.gui2.table.Table;
import com.to.nitor.domain.Item;
import com.to.nitor.utils.DBUtils;

public class InventoryWindow extends BasicWindow {
	public InventoryWindow(final WindowBasedTextGUI textGUI) {
		
		super("Inventory");
		setHints(Arrays.asList(Window.Hint.CENTERED));
		
		DBUtils dbutils = null;
		
		List<Item> items = new ArrayList<Item>();
		
		try {
			dbutils = new DBUtils("jdbc:mysql://localhost:3306/nitor","root","root");
			
			dbutils.getConnection();
			
			items = dbutils.readAll();
		} catch(Exception e) {
			items.add(new Item("Oat",39,1));
			items.add(new Item("Beetroot",12,2));
			items.add(new Item("Onion",150,3));
		}
		
		Panel containerPanel = new Panel(new GridLayout(1));
		containerPanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
		
		Table<String> table = new Table<String>("Crop", "Quantity", "Id");
		for(Item item: items) {
			table.getTableModel().addRow(item.getName(),
										String.valueOf(item.getQuantity()),
										String.valueOf(item.getId()));
		}
		
		if(dbutils != null) {
			dbutils.closeConnection();
		}
		
		containerPanel.addComponent(table);
		
		Panel buttonPanel = new Panel(new GridLayout(3));
		
		new Button("Add Item", new Runnable() {
        	public void run() {
        		Window activeWindow = textGUI.getActiveWindow();
    			textGUI.removeWindow(activeWindow);
    			textGUI.addWindowAndWait(new AddItemWindow(textGUI));
        	}
        }).addTo(buttonPanel);
		
		new Button("Remove Item", new Runnable() {
        	public void run() {
        		Window activeWindow = textGUI.getActiveWindow();
    			textGUI.removeWindow(activeWindow);
    			textGUI.addWindowAndWait(new RemoveItemWindow(textGUI));
        	}
        }).addTo(buttonPanel);
		
		new Button("Back", new Runnable() {
        	public void run() {
        		Window activeWindow = textGUI.getActiveWindow();
    			textGUI.removeWindow(activeWindow);
    			textGUI.addWindowAndWait(new MenuWindow(textGUI));
        	}
        }).addTo(buttonPanel);
		
		containerPanel.addComponent(buttonPanel);
		setComponent(containerPanel);
	}
}