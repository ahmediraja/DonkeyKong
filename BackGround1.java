import greenfoot.*;

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
    public int timer = 0;
    public BackGround1()
    {    
        super(1500, 1000, 1); 
        addObject(new DK(), 220, 150);
        addObject(new BarrelBG(), 70, 150);
        addObject(new Floor(), 125, 219);
        addObject(new Floor(), 375, 219);
        addObject(new Floor(), 625, 219);
        addObject(new Floor(), 875, 219);
        addObject(new Floor2(), 625, 500);
        addObject(new Floor2(), 875, 500);
        addObject(new Floor2(), 1125, 500);
        addObject(new Floor2(), 1375, 500);
        addObject(new Floor(), 125, 781);
        addObject(new Floor(), 375, 781);
        addObject(new Floor(), 625, 781);
        addObject(new Floor(), 875, 781);
        addObject(new Floor2(), 125, 1000);
        addObject(new Floor2(), 375, 1000);
        addObject(new Floor2(), 625, 1000);
        addObject(new Floor2(), 875, 1000);
        addObject(new Floor2(), 1125, 1000);
        addObject(new Floor2(), 1375, 1000);
        addObject(new Mario(), 150, 940);
        addObject(new FireBarrel(), 80, 942);
    }
    public void countTime()
    {
        timer++;
        showTime();
    }
    public void showTime()
    {
        showText("Time: " + timer/60, 500, 50);
    }
    public void act(){
     countTime();
     }
}
