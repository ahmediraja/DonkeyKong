import greenfoot.*;
public class Mario extends Actor
{
    int speed;
    GreenfootImage MarioFacingRight = new GreenfootImage("Mario Facing Right.png");
    GreenfootImage MarioFacingLeft = new GreenfootImage("Mario Facing Left.png");
    GreenfootImage MarioRunningRightHalf = new GreenfootImage("Mario Running Right Half.png");
    GreenfootImage MarioRunningRight = new GreenfootImage("Mario Running Right.png");
    GreenfootImage MarioRunningLeftHalf = new GreenfootImage("Mario Running Left Half.png");
    GreenfootImage MarioRunningLeft = new GreenfootImage("Mario Running Left.png");
    long lastTime;
    int Lives = 3;
    int animationCounter = 0;
    int MarioFrame = 1;
    public Mario(){
        MarioFacingRight = getImage();
        MarioFacingRight.scale(50,75);
        MarioFacingLeft.scale(50,75);
        MarioRunningRightHalf.scale(60,75);
        MarioRunningLeftHalf.scale(60,75);
        MarioRunningRight.scale(60,75);
        MarioRunningLeft.scale(60,75);
    }
    public void animation(){
        if(Greenfoot.isKeyDown("left")){
            move(-20);
            if(MarioFrame == 1){
            setImage(MarioRunningLeftHalf);
            MarioFrame = 2;
          }
          else if(MarioFrame == 2){
            setImage(MarioRunningLeft);
            MarioFrame = 1;
          }  
        }
         else if(Greenfoot.isKeyDown("right")){
            move(20);
            if(MarioFrame == 1){
                setImage(MarioRunningRightHalf);
                MarioFrame = 2;
            }
            else if(MarioFrame == 2){
              setImage(MarioRunningRight);
              MarioFrame = 1;
            }
        }  else {
            setImage(MarioFacingRight);
        }
    }
    public void act() 
    {
        speed = speed + 1;
        setLocation( getX(), getY() + speed);
        getWorld().showText("Lives : "+ Lives +"",1450, 50);
        animationCounter = animationCounter +1;
         
        if(animationCounter % 4 == 0)
        {
            animation();
        }
        if(isTouching(Barrel.class))
        {
            removeTouching(Barrel.class);
            Lives = Lives - 1;
        }
        if(Lives == 0)
        {
            getWorld().showText("GAME OVER", 750, 600);
            Greenfoot.stop();
        }
        if(speed > 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() - 1);
                if(Greenfoot.isKeyDown("up"))
                {
                    speed = - 27;
                }
            }
        }
        if(speed <= 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() + 1);
            }
        }    
    }
        /*if(Greenfoot.isKeyDown("left"))
        {
            move(-5);
            
            
    
            
            while(isTouching(Floor.class))
            {
               move(1);
            } 
        } else {
            if(Greenfoot.isKeyDown("right")){
            
               move(5);
               
        }
        if(Greenfoot.isKeyDown("down")){
        
            speed = 50;
        }
    } */
}