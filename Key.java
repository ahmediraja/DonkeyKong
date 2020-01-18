import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Actor
{
    /**
     * Act - do whatever the Key wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Key(int w, int h) {
        //50x60
        GreenfootImage image = getImage();
        image.scale(w, h);
        setImage(image);        
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
