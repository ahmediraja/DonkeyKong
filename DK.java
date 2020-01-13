import greenfoot.*;
public class DK extends Actor
{
    long lastTime;
    int animationCounter = 0;
    int frame = 1;
    int width; //used for adjusting barrel init location
    GreenfootImage kongDead = new GreenfootImage("Kong Dead.png");
    GreenfootImage kongGrabing = new GreenfootImage("Kong Grabing.png");
    GreenfootImage kongRoar1 = new GreenfootImage("Kong Roar 1.png");
    GreenfootImage kongRoar2 = new GreenfootImage("Kong Roar 2.png");
    GreenfootImage kongStandingStill = new GreenfootImage("Kong Standing Still.png");
    GreenfootImage kongStanding = new GreenfootImage("Kong Standing.png");
    GreenfootImage kongThrowing = new GreenfootImage("Kong Throwing.png");
    public DK(int w, int h){
        //w=140, h=110
        width = w;
        kongRoar1 = getImage();
        kongRoar1.scale(w,h);
        kongRoar2.scale(w,h);
        kongDead.scale(w,h);
        kongGrabing.scale(w,h);
        kongStandingStill.scale(w,h);
        kongStanding.scale(w,h);
        kongThrowing.scale(w,h);
    }
    public void animation(){
        if(frame == 1){
            setImage(kongRoar1);
            frame = 2;
        } else if(frame == 2){
            setImage(kongRoar2);
            frame = 3;
        } else if(frame == 3){
            setImage(kongStandingStill);
            frame = 4;
        } else if(frame == 4){
            setImage(kongGrabing);
            frame = 5;
        } else if(frame == 5){
            setImage(kongStanding);
            frame = 6;
        } else if(frame == 6){
            setImage(kongThrowing);
            throwBarrel();
            frame = 3;
        }
    }
    void throwBarrel() {
        getWorld().addObject(new Barrel(35, 35), getX()+(int)(width/2), getY());
    }
    public void act() 
    {
        animationCounter = animationCounter + 1;
        
        if(animationCounter % 120 == 0)
        {
            animation();
        }
        if(isTouching(Mario.class) && getWorld() instanceof BackGround1)
        {
            Greenfoot.setWorld(new BackGround2());
            Greenfoot.stop();
        }
    }
}
