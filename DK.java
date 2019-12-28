import greenfoot.*;
public class DK extends Actor
{
    long lastTime;
    int animationCounter = 0;
    int frame = 1;
    GreenfootImage KongDead = new GreenfootImage("Kong Dead.png");
    GreenfootImage KongGrabing = new GreenfootImage("Kong Grabing.png");
    GreenfootImage KongRoar1 = new GreenfootImage("Kong Roar 1.png");
    GreenfootImage KongRoar2 = new GreenfootImage("Kong Roar 2.png");
    GreenfootImage KongStandingStill = new GreenfootImage("Kong Standing Still.png");
    GreenfootImage KongStanding = new GreenfootImage("Kong Standing.png");
    GreenfootImage KongThrowing = new GreenfootImage("Kong Throwing.png");
    public DK(){
        KongRoar1 = getImage();
        KongRoar1.scale(140,110);
        KongRoar2.scale(140,110);
        KongDead.scale(140,110);
        KongGrabing.scale(140,110);
        KongStandingStill.scale(140,110);
        KongStanding.scale(140,110);
        KongThrowing.scale(140,110);
    }
    public void animation(){
        if(frame == 1){
            setImage(KongRoar1);
            frame = 2;
        } else if(frame == 2){
            setImage(KongRoar2);
            frame = 3;
        } else if(frame == 3){
            setImage(KongStandingStill);
            frame = 4;
        } else if(frame == 4){
            setImage(KongGrabing);
            frame = 5;
        } else if(frame == 5){
            setImage(KongStanding);
            frame = 6;
        } else if(frame == 6){
            setImage(KongThrowing);
            frame = 3;
        }
    }
    public void act() 
    {
        animationCounter = animationCounter +1;
         
        if(animationCounter % 50 == 0)
        {
            animation();
        }
        if(isTouching(Mario.class))
        {
            Greenfoot.setWorld(new Finish());

            Greenfoot.stop();
        }
        if(System.currentTimeMillis() - lastTime > 2500)
        {
            lastTime = System.currentTimeMillis();
            getWorld().addObject(new Barrel(), getX(), getY());
        }
    }    
}
