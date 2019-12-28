import greenfoot.*;

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    public Floor(int wFloor, int hFloor)
    {
        GreenfootImage image = getImage();
        //image.scale((int)(image.getWidth() * 0.80), (int)(image.getHeight() * 0.80));
        image.scale(wFloor, hFloor);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
