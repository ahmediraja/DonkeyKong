import greenfoot.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.*;

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
        super(w,h,1);
        addObject(new DK(), (int)(w*0.1), (int)(h*0.1));
        addObject(new Floor((int)(w*0.75), (int)(h*0.05)), (int)((w*0.75)*0.5), h-(floorGap*3));
        addObject(new Floor2((int)(w*0.75), (int)(h*0.05)), w-(int)((w*0.75)*0.5), h-(floorGap*2));
        addObject(new Floor((int)(w*0.75), (int)(h*0.05)), (int)((w*0.75)*0.5), h-floorGap);
        addObject(new Floor2(w, (int)(h*0.05)), (int)(w/2), h);
        addObject(new Mario(), 125, h-60);
        addObject(new lives(),(int)(w*0.5)+600, (int)(h*0.5)-320);
        addObject(new lives(),(int)(w*0.5)+500, (int)(h*0.5)-320);
        addObject(new lives(),(int)(w*0.5)+425, (int)(h*0.5)-320);
    }
}
