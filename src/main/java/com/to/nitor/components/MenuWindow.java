package com.to.nitor.components;

import java.util.Arrays;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;

public class MenuWindow extends BasicWindow {
	public MenuWindow(final WindowBasedTextGUI textGUI) {
		
		super("Nitor");
		setHints(Arrays.asList(Window.Hint.CENTERED));
		
        Panel containerPanel = new Panel(new GridLayout(2));
        GridLayout gridLayout = (GridLayout)containerPanel.getLayoutManager();
        gridLayout.setHorizontalSpacing(3);
        
        new Button("Inventory", new Runnable() {
        	public void run() {
        		Window activeWindow = textGUI.getActiveWindow();
    			textGUI.removeWindow(activeWindow);
    			textGUI.addWindowAndWait(new InventoryWindow(textGUI));
        	}
        }).addTo(containerPanel);
        new Button("Exit", new Runnable() {
        	public void run() {
        		Window activeWindow = textGUI.getActiveWindow();
    			textGUI.removeWindow(activeWindow);
        	}
        }).addTo(containerPanel);

        setComponent(containerPanel);
	}
}
