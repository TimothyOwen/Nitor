package com.to.nitor;

import java.io.IOException;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.to.nitor.components.MenuWindow;

public class Runner {
	
    public static void main(String[] args) throws IOException {
    	
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = null;
        Screen screen = null;      

        try {
        	terminal = terminalFactory.createTerminal();
        	
        	screen = new TerminalScreen(terminal);
        	
        	final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE_BRIGHT));
        	
        	screen.startScreen();
        	            
        	final Window menuWindow = new MenuWindow(textGUI);
      
            textGUI.addWindowAndWait(menuWindow);
        }
        catch (IOException e) {
        	
            e.printStackTrace();
            
        }
        finally {
            if(screen != null) {
                try {
                	
                    screen.stopScreen();
                    
                }
                catch(IOException e) {
                	
                    e.printStackTrace();
                    
                }
            }
        }
    }
}
