import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FireBarrel extends Actor
{
    GreenfootImage barrel1 = new GreenfootImage("Fire Barrel 1.png");
    GreenfootImage barrel2 = new GreenfootImage("Fire Barrel 2.png");
    int animationCounter = 0;
    int frame = 1;
    public FireBarrel(int w, int h){
        //w=50, h=75
        barrel1 = getImage();
        barrel1.scale(w,h);
        barrel2.scale(w,h);
    }
    public void act(){
        animationCounter = animationCounter +1;
         
        if(animationCounter % 30 == 0)
        {
            animation();
        }
        }
    public void animation() 
    {
      if(frame == 1){
          setImage(barrel1);
          frame = 2;
        }
        else if(frame == 2){
            setImage(barrel2);
            frame = 1;
        }
    }
}