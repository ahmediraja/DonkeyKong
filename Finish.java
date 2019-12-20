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

    /**
     * Constructor for objects of class Finish.
     * 
     */
    
    private static final int w = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.80);
    private static final int h = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.80);
    
    public Finish()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(1500, 1000, 1); 
        super(w, h, 1);
        //for (int i = 125; i < w; i += 250) {
        //    addObject(new Floor(w, 120), i, h);
        //}
        addObject(new Floor2(w, (int)(h*0.05)), (int)(w/2), h);
        addObject(new Princess(), 145, h-60);
        addObject(new Mario(), 85, h-60);
        showText("YOU WIN", 750, 600);
    }
}
