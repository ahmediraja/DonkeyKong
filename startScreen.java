import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;
/**
 * Write a description of class startScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startScreen extends World
{
    private static final int w = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.80);//screen size scaling
    private static final int h = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.80);//screen size scaling
    GreenfootSound music = new GreenfootSound("startMusic.mp3");//setup for game music
    /**
     * Constructor for objects of class startScreen.
     * 
     */
    public startScreen()
    {    
        // Create a new world with w by h cells with a cell size of 1x1 pixels.
        super(w, h, 1); 
        music.play();//play music
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))//start game if space key is pressed
        {
            music.stop();
            Greenfoot.setWorld(new BackGround1());
        }
        if(Greenfoot.isKeyDown("m"))//if "m" key is pressed then music is paused
        {
            if(music.isPlaying())
            {
                music.pause();
            }
            else
            {
                music.play();
            }
        }
    }
}
