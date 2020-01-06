import greenfoot.*;

public class Barrel extends Actor
{
    public Barrel(){
        GreenfootImage myImage = getImage();
        myImage.scale(50,50);
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
            setLocation(getX() - 3, getY() - 3);
            turn(-8);
          }
          while(isTouching(Floor.class))
          {
            setLocation(getX() + 3, getY() - 3);
            turn(8);
          }
       }
    }
}
 