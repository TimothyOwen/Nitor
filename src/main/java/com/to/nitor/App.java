  
package com.to.nitor;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        //Screen screen = new TerminalScreen(terminal);
        //screen.startScreen();
        
        TerminalSize screenSize = terminal.getTerminalSize();

        //Place the cursor in the bottom right corner
        terminal.setCursorPosition(screenSize.getColumns() - 1, screenSize.getRows() - 1);
        
        terminal.setBackgroundColor(TextColor.ANSI.BLUE);
        terminal.setForegroundColor(TextColor.ANSI.YELLOW);
        terminal.setCursorPosition(10, 5);
        terminal.putCharacter('H');
        terminal.putCharacter('e');
        terminal.putCharacter('l');
        terminal.putCharacter('l');
        terminal.putCharacter('o');
        terminal.putCharacter('!');
        terminal.setCursorPosition(0, 0);
        Thread.sleep(2000);
        
        // Create panel to hold components
        
//        Panel panel = new Panel();
//        panel.setLayoutManager(new GridLayout(2));
//
//        panel.addComponent(new Label("Forename"));
//        panel.addComponent(new TextBox());
//
//        panel.addComponent(new Label("Surname"));
//        panel.addComponent(new TextBox());
//
//        panel.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
//        panel.addComponent(new Button("Submit"));

        // Create window to hold the panel
        //BasicWindow window = new BasicWindow();
        //window.setComponent(panel);

        // Create gui and start gui
        //MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        //gui.addWindowAndWait(window);
    }
}