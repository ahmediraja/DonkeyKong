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
    long StartTime = System.currentTimeMillis();
    long EndTime;
    int DurationInMillis;//time in millseconds
    public static int DurationInlvl1;//time taken to complete level 1
    public BackGround1()
    {    
        //super(1500, 1000, 1);
        super(w,h,1);
        final int floorHeight = (int)(h*0.05);
        final int floorGap = (int)h/4;
        final int marioHeight = 54;

        addObject(new DK(140, 110), 190, 112);//add DK
        addObject(new BarrelBG(100, 80), 70, 122);//add background barrel
        addObject(new FireBarrel(36, 54), 60, h-46);//add fire barrel
        addObject(new Floor((int)(w*0.75), floorHeight), (int)((w*0.75)*0.5), h-(floorGap*3));//add floors
        addObject(new Floor2((int)(w*0.75), floorHeight), w-(int)((w*0.75)*0.5), h-(floorGap*2));
        addObject(new Floor((int)(w*0.75), floorHeight), (int)((w*0.75)*0.5), h-floorGap);
        addObject(new Floor2(w, floorHeight), (int)(w/2), h);
        addObject(new Ladder((int)(w*0.04), (int)(floorGap-marioHeight+5)), (int)(w*0.33), (int)(h-(floorGap*3)+((floorGap-marioHeight-floorHeight)/2)));//add ladder
        addObject(new Ladder((int)(w*0.04), (int)(floorGap-marioHeight+5)), (int)(w*0.66), (int)(h-(floorGap*2)+((floorGap-marioHeight-floorHeight)/2)));

        addObject(new Mario(24, 36), 125, h-46);//add mario
    }

    public void act(){//timer 
        EndTime = System.currentTimeMillis();
        DurationInMillis = (int)(EndTime - StartTime);
        DurationInlvl1 = DurationInMillis / 1000;
        showText("Time: " + DurationInlvl1, w/2,20);
    }

}
