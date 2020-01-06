import greenfoot.*;

public class Barrel extends Actor
{
    static int hVel = 1; //horizontal velocity
    public Barrel(int w, int h){
        GreenfootImage myImage = getImage();
        myImage.scale(w,h);
    }
    public void act() 
    {
        if(isTouching(FireBarrel.class))
        {
            getWorld().removeObject(this);
        } else {
          setLocation(getX(), getY() + 3);
          while(isTouching(Floor2.class))
          {
            setLocation(getX() - hVel, getY() - 3);
            turn(-hVel*2);
          }
          while(isTouching(Floor.class))
          {
            setLocation(getX() + hVel, getY() - 3);
            turn(hVel*2);
          }
       }
    }
}
 