import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class lives extends Actor
{
    /**
     * Act - do whatever the lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    public lives()
    {
        GreenfootImage image = getImage();
        image.scale(200, 50);
        setImage(image);        
    }
}
