import greenfoot.*;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Write a description of class Finish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Finish extends World
{
    private static final int w = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.80);
    private static final int h = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.80);
    
    /**
     * Constructor for objects of class Finish.
     * 
     */
    public Finish()
    {    
        // Create a new world with w*h cells with a cell size of 1x1 pixels.
        super(w, h, 1);
        addObject(new Floor2(w, (int)(h*0.05)), (int)(w/2), h);
        addObject(new Princess(76, 70), 145, h-57);
        addObject(new Mario(50, 75), 85, h-57);
        showText("YOU WIN", (int)(w/2), (int)(h/2));
    }
}
