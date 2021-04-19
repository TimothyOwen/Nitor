package com.to.nitor.components;

import java.util.Arrays;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.to.nitor.domain.Item;
import com.to.nitor.utils.DBUtils;

public class AddItemWindow extends BasicWindow {
	public AddItemWindow(final WindowBasedTextGUI textGUI) {
		
		super("Add Item");
		setHints(Arrays.asList(Window.Hint.CENTERED));
		
		Panel mainPanel = new Panel(new GridLayout(1));
		mainPanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
		
		Panel containerPanel = new Panel(new GridLayout(2));
		Label nameLabel = new Label("Name");
		final TextBox nameTextBox = new TextBox();
		containerPanel.addComponent(nameLabel);
		containerPanel.addComponent(nameTextBox);
		
		Label quantityLabel = new Label("Quantity");
		final TextBox quantityTextBox = new TextBox();
		containerPanel.addComponent(quantityLabel);
		containerPanel.addComponent(quantityTextBox);
		
		final Label errorLabel = new Label("");
		
		Panel buttonPanel = new Panel(new GridLayout(2));
		
		new Button("Add Item", new Runnable() {
			public void run() {
				try {
					Window activeWindow = textGUI.getActiveWindow();
					DBUtils dbutils = new DBUtils("jdbc:mysql://localhost:3306/nitor","root","root");
					
					dbutils.getConnection();

					String itemName = nameTextBox.getText();
					
					Long itemQuantity = Long.valueOf(quantityTextBox.getText());
					
					dbutils.createItem(new Item(itemName, itemQuantity));
					
					textGUI.removeWindow(activeWindow);
	    			textGUI.addWindowAndWait(new InventoryWindow(textGUI));
	    			
				} catch(Exception e) {
					errorLabel.setText("Error");
				}
			}
		}).addTo(buttonPanel);
		
		new Button("Back", new Runnable() {
        	public void run() {
        		Window activeWindow = textGUI.getActiveWindow();
    			textGUI.removeWindow(activeWindow);
    			textGUI.addWindowAndWait(new InventoryWindow(textGUI));
        	}
        }).addTo(buttonPanel);
		
		containerPanel.addComponent(errorLabel);
		mainPanel.addComponent(containerPanel);
		mainPanel.addComponent(buttonPanel);
		setComponent(mainPanel);
	}
}
