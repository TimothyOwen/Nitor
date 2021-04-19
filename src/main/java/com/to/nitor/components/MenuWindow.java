package com.to.nitor.components;

import java.util.Arrays;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;

public class MenuWindow extends BasicWindow {
	public MenuWindow(final WindowBasedTextGUI textGUI) {
		
		super("Nitor");
		setHints(Arrays.asList(Window.Hint.CENTERED));
		
        Panel containerPanel = new Panel(new GridLayout(6));
        GridLayout gridLayout = (GridLayout)containerPanel.getLayoutManager();
        gridLayout.setHorizontalSpacing(3);
        containerPanel.addComponent(new Label("Password"));
        final TextBox passwordBox = new TextBox().addTo(containerPanel);
        final Label buttonOutput = new Label("");
        new Button("Log In", new Runnable() {
        	public void run() {
        		CharSequence password = "root";
        		if(passwordBox.getText().contentEquals(password)) {
        			Window activeWindow = textGUI.getActiveWindow();
        			textGUI.removeWindow(activeWindow);
        			textGUI.addWindowAndWait(new InventoryWindow());
        		}else {
        			buttonOutput.setText(passwordBox.getText());
        		}
        	}
        }).addTo(containerPanel);
        containerPanel.addComponent(buttonOutput);
        setComponent(containerPanel);
	}
}
