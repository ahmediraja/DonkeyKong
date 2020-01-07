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
        final int marioHeight = 54;
        
        
        addObject(new DK(140, 110), 190, 112);
        addObject(new BarrelBG(100, 80), 70, 122);
        //addObject(new DK(), 220, 150);
        //addObject(new Floor(), 125, 219);
        //addObject(new Floor(), 375, 219);
        //addObject(new Floor(), 625, 219);
        //addObject(new Floor(), 875, 219);
        //addObject(new Floor2(), 625, 500);
        //addObject(new Floor2(), 875, 500);
        //addObject(new Floor2(), 1125, 500);
        //addObject(new Floor2(), 1375, 500);
        //addObject(new Floor(), 125, 781);
        //addObject(new Floor(), 375, 781);
        //addObject(new Floor(), 625, 781);
        //addObject(new Floor(), 875, 781);
        //addObject(new Floor2(), 125, 1000);
        //addObject(new Floor2(), 375, 1000);
        //addObject(new Floor2(), 625, 1000);
        //addObject(new Floor2(), 875, 1000);
        //addObject(new Floor2(), 1125, 1000);
        //addObject(new Floor2(), 1375, 1000);
        addObject(new Floor((int)(w*0.75), floorHeight), (int)((w*0.75)*0.5), h-(floorGap*3));
        addObject(new Floor2((int)(w*0.75), floorHeight), w-(int)((w*0.75)*0.5), h-(floorGap*2));
        addObject(new Floor((int)(w*0.75), floorHeight), (int)((w*0.75)*0.5), h-floorGap);
        addObject(new Floor2(w, floorHeight), (int)(w/2), h);
        //(int)(h*0.375-(floorHeight/2)-marioHeight+1)
        addObject(new Ladder((int)(w*0.04), (int)(floorGap-marioHeight+5)), (int)(w*0.33), (int)(h-(floorGap*3)+((floorGap-marioHeight-floorHeight)/2)));
        addObject(new Ladder((int)(w*0.04), (int)(floorGap-marioHeight+5)), (int)(w*0.66), (int)(h-(floorGap*2)+((floorGap-marioHeight-floorHeight)/2)));
        
        addObject(new Mario(36, 54), 125, h-46);
        
        addObject(new FireBarrel(36, 54), 60, h-46);
    }
}
