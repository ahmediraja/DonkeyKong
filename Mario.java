import greenfoot.*;
public class Mario extends Actor
{
    int speed;
    GreenfootImage marioFacingRight = new GreenfootImage("Mario Facing Right.png");
    GreenfootImage marioFacingLeft = new GreenfootImage("Mario Facing Left.png");
    GreenfootImage marioRunningRightHalf = new GreenfootImage("Mario Running Right Half.png");
    GreenfootImage marioRunningRight = new GreenfootImage("Mario Running Right.png");
    GreenfootImage marioRunningLeftHalf = new GreenfootImage("Mario Running Left Half.png");
    GreenfootImage marioRunningLeft = new GreenfootImage("Mario Running Left.png");
    long lastTime;
    int lives = 5, animationCounter = 0, marioFrame = 1;
    Heart[] hearts = new Heart[lives];
    public Mario(int w, int h){
        //w=50, h=75
        marioFacingRight = getImage();
        marioFacingRight.scale(w,h);
        marioFacingLeft.scale(w,h);
        marioRunningRightHalf.scale(w+10,h);
        marioRunningLeftHalf.scale(w+10,h);
        marioRunningRight.scale(w+10,h);
        marioRunningLeft.scale(w+10,h);
    }
    public Mario(int w, int h, boolean runLeft){ //the bool is just used as identifier
        //w=50, h=75
        marioRunningLeft = getImage();
        marioFacingRight.scale(w,h);
        marioFacingLeft.scale(w,h);
        marioRunningRightHalf.scale(w+10,h);
        marioRunningLeftHalf.scale(w+10,h);
        marioRunningRight.scale(w+10,h);
        marioRunningLeft.scale(w+10,h);
    }
    protected void addedToWorld(World world) {
        if (getWorld() instanceof BackGround1) {
            for (int i = 0; i < hearts.length; i++) {
                hearts[i] = new Heart(30, 30);
                getWorld().addObject(hearts[i], i*50+25, 25);
            }
        }
    }
    public void animation(){
        if(Greenfoot.isKeyDown("left")){
            move(-10);
            if(marioFrame == 1){
            setImage(marioRunningLeftHalf);
            marioFrame = 2;
          }
          else if(marioFrame == 2){
            setImage(marioRunningLeft);
            marioFrame = 1;
          }  
        }
         else if(Greenfoot.isKeyDown("right")){
            move(10);
            if(marioFrame == 1){
                setImage(marioRunningRightHalf);
                marioFrame = 2;
            }
            else if(marioFrame == 2){
              setImage(marioRunningRight);
              marioFrame = 1;
            }
        }  else {
            setImage(marioFacingRight);
        }
    }
    public void act() 
    {
        speed = speed + 1;
        setLocation( getX(), getY() + speed);
        //getWorld().showText("Lives : "+ lives +"", 50, 15);
        animationCounter = animationCounter + 1;
        if(animationCounter % 10 == 0)
        {
            animation();
        }
        if(isTouching(Barrel.class))
        {
            removeTouching(Barrel.class);
            getWorld().removeObject(hearts[lives-1]);
            lives--;
        }
        if(lives == 0)
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
                    speed = - 22;
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
        if(isTouching(Ladder.class)) {
            if(Greenfoot.isKeyDown("up")) {
                speed -= 5;
            } else if(Greenfoot.isKeyDown("down")) {
                speed += 5;
            }
        }
    }
}