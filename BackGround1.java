import greenfoot.*;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Write a description of class BackGround1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class BackGround1 extends World
{

    /**
     * Constructor for objects of class BackGround1.
     * 
     */
    private static final int w = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.80);
    private static final int h = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.80);
    private static final int floorGap = (int)w/6;
    public BackGround1()
    {    
        //super(1500, 1000, 1);
        super(w,h,1);
        addObject(new DK(), (int)(w*0.1), (int)(h*0.1));
        
        //addObject(new Floor(), 125, 219);
        //addObject(new Floor(), 375, 219);
        //addObject(new Floor(), 625, 219);
        //addObject(new Floor(), 875, 219);
        for (int i = 125; i < w-(250*2); i += 250) {
            addObject(new Floor(), i, h-(floorGap*3));
        }
        //addObject(new Floor2(), 625, 500);
        //addObject(new Floor2(), 875, 500);
        //addObject(new Floor2(), 1125, 500);
        //addObject(new Floor2(), 1375, 500);
        for (int i = 625; i < w; i += 250) {
            addObject(new Floor2(), i, h-(floorGap*2));
        }
        //addObject(new Floor(), 125, 781);
        //addObject(new Floor(), 375, 781);
        //addObject(new Floor(), 625, 781);
        //addObject(new Floor(), 875, 781);
        for (int i = 125; i < w-(250*2); i += 250) {
            addObject(new Floor(), i, h-floorGap);
        }
        //addObject(new Floor2(), 125, h);
        //addObject(new Floor2(), 375, h);
        //addObject(new Floor2(), 625, h);
        //addObject(new Floor2(), 875, h);
        //addObject(new Floor2(), 1125, h);
        //addObject(new Floor2(), 1375, h);
        for (int i = 125; i < w; i += 250) {
            addObject(new Floor2(), i, h);
        }
        
        addObject(new Mario(), 125, h-60);
    }
}
