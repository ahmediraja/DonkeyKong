import greenfoot.*;
public class Mario extends Actor
{
    int speed;
    GreenfootImage marioFacingRight = new GreenfootImage("Mario Facing Right.png"),
    marioFacingLeft = new GreenfootImage("Mario Facing Left.png"),
    marioRunningRightHalf = new GreenfootImage("Mario Running Right Half.png"),
    marioRunningRight = new GreenfootImage("Mario Running Right.png"),
    marioRunningLeftHalf = new GreenfootImage("Mario Running Left Half.png"),
    marioRunningLeft = new GreenfootImage("Mario Running Left.png");
    long lastTime;
    int lives = 5, animationCounter = 0, marioFrame = 1;
    Heart[] hearts = new Heart[lives];
    GreenfootSound win = new GreenfootSound("win.wav");
    boolean hasKey = false;
    public Mario(int w, int h) {
        //w=50, h=75
        marioFacingRight = getImage();
        marioFacingRight.scale(w,h);
        marioFacingLeft.scale(w,h);
        marioRunningRightHalf.scale(w+10,h);
        marioRunningLeftHalf.scale(w+10,h);
        marioRunningRight.scale(w+10,h);
        marioRunningLeft.scale(w+10,h);
    }
    public void addedToWorld(World world) {
        if (getWorld() instanceof BackGround1 || getWorld() instanceof BackGround2) {
            for (int i = 0; i < lives; i++) {
                hearts[i] = new Heart(30, 30);
                getWorld().addObject(hearts[i], i*50+25, 25);
            }
        }
    }
    public void animation() {
        if(Greenfoot.isKeyDown("left")) {
          if(marioFrame == 1){
            setImage(marioRunningLeftHalf);
            marioFrame = 2;
          }
          else if(marioFrame == 2){
            setImage(marioRunningLeft);
            marioFrame = 1;
          }  
        } else if(Greenfoot.isKeyDown("right")){
            if(marioFrame == 1){
                setImage(marioRunningRightHalf);
                marioFrame = 2;
            }
            else if(marioFrame == 2){
              setImage(marioRunningRight);
              marioFrame = 1;
            }
        } else {
            setImage(marioFacingRight);
        }
    }
    public void act() {
        speed += 1;
        setLocation( getX(), getY() + speed);
        //getWorld().showText("Lives: "+ lives +"", 50, 15);
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
            if(isTouching(Ladder.class)) {
                speed = 0;
                setLocation(getX(), getY() - 1);
                //if(Greenfoot.isKeyDown("up")) {
                //    speed = -5;
                //}
            } else {
                while(isTouching(Floor.class))
                {
                    speed = 0;
                    setLocation(getX(), getY() - 1);
                    if(Greenfoot.isKeyDown("up") && !isTouching(Ladder.class))
                    {
                        speed = - 22;
                    }
                }
            }
        }
        if(speed <= 0)
        {
            if(isTouching(Ladder.class)) {
                speed = 0;
                //setLocation(getX(), getY() - 1);
                if(Greenfoot.isKeyDown("up")) {
                    speed = -2;
                }
            } else {
                while(isTouching(Floor.class))
                {
                    speed = 0;
                    setLocation(getX(), getY() + 1);
                }
            }
        }
        if(Greenfoot.isKeyDown("right")) {
            move(1);
        } else if(Greenfoot.isKeyDown("left")) {
            move(-1);
        }
        if(isTouching(Ladder.class)) {
            setLocation(getX(), getY() + 1);
            if(Greenfoot.isKeyDown("up")) {
                speed -= 1;
            } else if(Greenfoot.isKeyDown("down")) {
                speed += 1;
            }
        } else {
            
        }
        if(isTouching(Key.class)) {
            hasKey = true;
            getWorld().removeObject(getWorld().getObjects(Key.class).get(0));
        }
        if(isTouching(InCage.class) && hasKey == true) {
            win.play();
            Greenfoot.setWorld(new Finish());
            Greenfoot.stop();
        }
        // MAY USE THIS FOR POWERUPS DOWN THE LINE
        //if(Greenfoot.isKeyDown("l")) {
        //    lives++;
        //    addedToWorld(getWorld());
        //}
    }
}