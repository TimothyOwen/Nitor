package Nitor;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextCharacter;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		
		DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
		Screen screen = null;
		try {
			Terminal terminal = defaultTerminalFactory.createTerminal();
			screen = new TerminalScreen(terminal);
			screen.startScreen();
	        TerminalSize terminalSize = screen.getTerminalSize();
	        for(int column = 0; column < terminalSize.getColumns(); column++) {
	            for(int row = 0; row < terminalSize.getRows(); row++) {
	                screen.setCharacter(column, row, new TextCharacter(' ', TextColor.ANSI.DEFAULT,TextColor.ANSI.RED));
	            }
	        }
			screen.refresh();
			screen.readInput();
		}
	    catch(Exception e) {
	        e.printStackTrace();
	    }
	    finally {
	        if(screen != null) {
	            try {
	            	screen.close();
	            }
	            catch(Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
}
