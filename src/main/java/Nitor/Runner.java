package nitor;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
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
	            for(int row = 0; row < terminalSize.getRows(); row=row+2) {
	                screen.setCharacter(column, row, new TextCharacter(' ', TextColor.ANSI.DEFAULT,TextColor.ANSI.CYAN));
	                screen.setCharacter(column, row+1, new TextCharacter(' ', TextColor.ANSI.DEFAULT,TextColor.ANSI.WHITE));
	            }
	        }
	        
			screen.refresh();
			screen.readInput();
			
			String sizeLabel = "Terminal Size: " + terminalSize;
            TerminalPosition labelBoxTopLeft = new TerminalPosition(1, 1);
            TerminalSize labelBoxSize = new TerminalSize(sizeLabel.length() + 2, 3);
            TerminalPosition labelBoxTopRightCorner = labelBoxTopLeft.withRelativeColumn(labelBoxSize.getColumns() - 1);
            TextGraphics textGraphics = screen.newTextGraphics();
            //This isn't really needed as we are overwriting everything below anyway, but just for demonstrative purpose
            textGraphics.fillRectangle(labelBoxTopLeft, labelBoxSize, ' ');
            
            textGraphics.drawLine(
                    labelBoxTopLeft.withRelativeColumn(1),
                    labelBoxTopLeft.withRelativeColumn(labelBoxSize.getColumns() - 2),
                    Symbols.DOUBLE_LINE_HORIZONTAL);
            textGraphics.drawLine(
                    labelBoxTopLeft.withRelativeRow(2).withRelativeColumn(1),
                    labelBoxTopLeft.withRelativeRow(2).withRelativeColumn(labelBoxSize.getColumns() - 2),
                    Symbols.DOUBLE_LINE_HORIZONTAL);
            textGraphics.setCharacter(labelBoxTopLeft, Symbols.DOUBLE_LINE_TOP_LEFT_CORNER);
            textGraphics.setCharacter(labelBoxTopLeft.withRelativeRow(1), Symbols.DOUBLE_LINE_VERTICAL);
            textGraphics.setCharacter(labelBoxTopLeft.withRelativeRow(2), Symbols.DOUBLE_LINE_BOTTOM_LEFT_CORNER);
            textGraphics.setCharacter(labelBoxTopRightCorner, Symbols.DOUBLE_LINE_TOP_RIGHT_CORNER);
            textGraphics.setCharacter(labelBoxTopRightCorner.withRelativeRow(1), Symbols.DOUBLE_LINE_VERTICAL);
            textGraphics.setCharacter(labelBoxTopRightCorner.withRelativeRow(2), Symbols.DOUBLE_LINE_BOTTOM_RIGHT_CORNER);
            textGraphics.putString(labelBoxTopLeft.withRelative(1, 1), sizeLabel);
            screen.refresh();
            Thread.yield();
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
