import greenfoot.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.awt.Toolkit;
public class Mario extends Actor
{
    int speed;
    private static final int w = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.80);
    GreenfootImage marioFacingRight = new GreenfootImage("Mario Facing Right.png"),
    marioFacingLeft = new GreenfootImage("Mario Facing Left.png"),
    marioRunningRightHalf = new GreenfootImage("Mario Running Right Half.png"),
    marioRunningRight = new GreenfootImage("Mario Running Right.png"),
    marioRunningLeftHalf = new GreenfootImage("Mario Running Left Half.png"),
    marioRunningLeft = new GreenfootImage("Mario Running Left.png"),
    marioClimbingLadder1 = new GreenfootImage("Mario Climbing 1.png"),
    marioClimbingLadder2 = new GreenfootImage("Mario Climbing 2.png");
    long lastTime;
    int lives = 3, animationCounter = 0, marioFrame = 1;
    Heart[] hearts = new Heart[lives];
    GreenfootSound win = new GreenfootSound("win.wav"),
    running = new GreenfootSound("walking.wav"),
    dead = new GreenfootSound("death.wav"),
    jump = new GreenfootSound("jump.wav");
    boolean hasKey = false;
    long StartTime = System.currentTimeMillis();
    long EndTime;
    int DurationInMillis, DurationInlvl1, DurationInlvl2;
    public Mario(int w, int h) {
        //w=50, h=75
        marioFacingRight = getImage();
        marioFacingRight.scale(w,h);
        marioFacingLeft.scale(w,h);
        marioRunningRightHalf.scale(w+10,h);
        marioRunningLeftHalf.scale(w+10,h);
        marioRunningRight.scale(w+10,h);
        marioRunningLeft.scale(w+10,h);
        marioClimbingLadder1.scale(w+10,h);
        marioClimbingLadder2.scale(w+10,h);
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
            running.play();
            if(marioFrame == 1){
                setImage(marioRunningLeftHalf);
                marioFrame = 2;
            } else if(marioFrame == 2){
                setImage(marioRunningLeft);
                marioFrame = 1;
            }  
        } else if(Greenfoot.isKeyDown("right")){
            running.play();
            if(marioFrame == 1){
                setImage(marioRunningRightHalf);
                marioFrame = 2;
            }
            else if(marioFrame == 2){
              setImage(marioRunningRight);
              marioFrame = 1;
            }
        } else if(isTouching(Ladder.class)){
            setImage(marioClimbingLadder1);
            if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down")) {
                if(marioFrame == 1) {
                    setImage(marioClimbingLadder1);
                    marioFrame = 2;
                } else if(marioFrame == 2) {
                    setImage(marioClimbingLadder2);
                    marioFrame = 1;
                }
            }
        } else {
            setImage(marioFacingRight);
        }
    }
    public void act() {
        speed += 1;
        setLocation(getX(), getY() + (speed/8));
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
        if(lives == 0) {
            if(running.isPlaying()){
                running.stop();
            }
            dead.play();
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
                        speed = - 65;
                        if(running.isPlaying()) {
                            running.stop();
                        }
                        jump.play();
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
                speed -= 15;
            } else if(Greenfoot.isKeyDown("down")) {
                speed += 15;
            }
        }
        if(isTouching(Key.class)) {
            hasKey = true;
            getWorld().removeObject(getWorld().getObjects(Key.class).get(0));
        }
        if(isTouching(InCage.class) && hasKey == true) {
            win.play();
            Greenfoot.setWorld(new Finish());
            String username = JOptionPane.showInputDialog("Enter a Username");
            File outputFile = new File("Leaderboard.txt");
            if(username.length()>15){
                username = username.substring(0, 15);
            }
            if(username.length()<7){
                username = username+"\t";
            }
            int score = DurationInlvl1 + DurationInlvl2;
            try {   
                FileWriter fileW = new FileWriter(outputFile, true);//creates file writer
                BufferedWriter buffW = new BufferedWriter(fileW);//creates buffered writer

                buffW.write("\n"+username+"\t"+score+" seconds");//buffered writer writes the parsed info into fileOutput
                buffW.close();//closing the buffered writer
                Desktop desktop = Desktop.getDesktop();

                if(outputFile.exists()) desktop.open(outputFile);
            }
            catch(IOException e) {
                e.printStackTrace();
                System.out.println("An Error Occured");
            }

            //Greenfoot.stop();
        }
        EndTime = System.currentTimeMillis();
        DurationInMillis = (int)(EndTime - StartTime);

        if (getWorld() instanceof BackGround1){
            DurationInlvl1 = DurationInMillis / 1000;
            getWorld().showText("Time: " + DurationInlvl1, w/2,20);
        }
        if (getWorld() instanceof BackGround2){
            DurationInlvl2 = DurationInMillis / 1000;
            getWorld().showText("Time: " + DurationInlvl2, w/2,20);
        }
        // MAY USE THIS FOR POWERUPS DOWN THE LINE
        //if(Greenfoot.isKeyDown("l")) {
        //    lives++;
        //    addedToWorld(getWorld());
        //}
    }
}