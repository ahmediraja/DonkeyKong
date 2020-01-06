import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FireBarrel extends Actor
{
    GreenfootImage Barrel1 = new GreenfootImage("Fire Barrel 1.png");
    GreenfootImage Barrel2 = new GreenfootImage("Fire Barrel 2.png");
    int animationCounter = 0;
    int frame = 1;
    public FireBarrel(){
        Barrel1 = getImage();
        Barrel1.scale(50,75);
        Barrel2.scale(50,75);
    }
    public void act(){
        animationCounter = animationCounter +1;
         
        if(animationCounter % 6 == 0)
        {
            animation();
        }
        }
    public void animation() 
    {
      if(frame == 1){
          setImage(Barrel1);
          frame = 2;
        }
        else if(frame == 2){
            setImage(Barrel2);
            frame = 1;
        }
    }
}