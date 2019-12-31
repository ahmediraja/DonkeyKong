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
    
    public BackGround1()
    {    
        //super(1500, 1000, 1);
        super(w,h,1);
        final int floorHeight = (int)(h*0.05);
        final int floorGap = (int)h/4;
        
        addObject(new DK(140, 110), 190, 112);
        addObject(new BarrelBG(100, 80), 70, 122);

        addObject(new Floor((int)(w*0.75), floorHeight), (int)((w*0.75)*0.5), h-(floorGap*3));
        addObject(new Floor2((int)(w*0.75), floorHeight), w-(int)((w*0.75)*0.5), h-(floorGap*2));
        addObject(new Floor((int)(w*0.75), floorHeight), (int)((w*0.75)*0.5), h-floorGap);
        addObject(new Floor2(w, floorHeight), (int)(w/2), h);
        
        addObject(new Ladder((int)(w*0.04), (int)(h*0.2)), (int)(w*0.33), (int)(h*0.375));
        addObject(new Ladder((int)(w*0.04), (int)(h*0.2)), (int)(w*0.66), h-(int)(h*0.375));
        
        addObject(new Mario(36, 54), 125, h-46);
        addObject(new FireBarrel(36, 54), 60, h-46);
        
        addObject(new lives(),(int)(w*0.5)+600, (int)(h*0.5)-320);
        addObject(new lives(),(int)(w*0.5)+500, (int)(h*0.5)-320);
        addObject(new lives(),(int)(w*0.5)+425, (int)(h*0.5)-320);
    }
}
