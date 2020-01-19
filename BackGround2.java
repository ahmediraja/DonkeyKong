import greenfoot.*;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Write a description of class BackGround2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackGround2 extends World
{

    /**
     * Constructor for objects of class BackGround2.
     * 
     */
    private static final int w = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.80);
    private static final int h = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.80);
    
    public BackGround2()
    {    
        //super(1500, 1000, 1);
        super(w,h,1);
        final int floorHeight = (int)(h*0.05);
        final int floorGap = (int)h/4;
        
        addObject(new DK(140, 110), 190, 112);//add DK
        addObject(new BarrelBG(100, 80), 70, 122);//add background barrel

        addObject(new Floor((int)(w*0.75), floorHeight), (int)((w*0.75)*0.5), h-(floorGap*3));//add floors
        addObject(new Floor((int)(w*0.30), floorHeight), (int)((w*0.71)*0.21), h-(int)floorGap*2);
        addObject(new Floor2(w, floorHeight), (int)(w/2), h);
        addObject(new Floor((int)(w*0.2), floorHeight), w-(int)((w*0.58)*0.17), h-(floorGap*2));
        addObject(new Floor((int)(w*0.2), floorHeight), w-(int)((w*0.70)*0.2), h-(int)(floorGap*0.9));
        addObject(new Floor((int)(w*0.27), floorHeight), w-(int)((w*0.70)*0.7), h-(int)(floorGap*1.5));
        
        addObject(new Mario(36, 54), 125, h-46);//add mario
        addObject(new FireBarrel(36, 54), 60, h-46);//add fire barrel
        
        addObject(new Key(50, 60),(int)(w*0.5)+25, (int)(h*0.5)-230);//add key 
        addObject(new InCage(76, 74), 145, h-415);//add princess in cage sprite 
    }
}
