import greenfoot.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.awt.Toolkit;
public class Mario extends Actor
{
    int speed;
    private static final int w = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.80);//get screen width
    GreenfootImage marioFacingRight = new GreenfootImage("Mario Facing Right.png"),//mario animation files
    marioFacingLeft = new GreenfootImage("Mario Facing Left.png"),
    marioRunningRightHalf = new GreenfootImage("Mario Running Right Half.png"),
    marioRunningRight = new GreenfootImage("Mario Running Right.png"),
    marioRunningLeftHalf = new GreenfootImage("Mario Running Left Half.png"),
    marioRunningLeft = new GreenfootImage("Mario Running Left.png"),
    marioClimbingLadder1 = new GreenfootImage("Mario Climbing 1.png"),
    marioClimbingLadder2 = new GreenfootImage("Mario Climbing 2.png");
    long lastTime;
    int lives = 3, animationCounter = 0, marioFrame = 1;//set amount of lives, animation counter and mario frame
    Heart[] hearts = new Heart[lives];//array for hearts(lives)
    GreenfootSound win = new GreenfootSound("win.wav"),//setup for sfx
    running = new GreenfootSound("walking.wav"),
    dead = new GreenfootSound("death.wav"),
    jump = new GreenfootSound("jump.wav");
    boolean hasKey = false;//used to determine if mario has collected key or not
    long StartTime = System.currentTimeMillis();//timer 
    long EndTime;//timer
    int DurationInMillis,DurationInlvl2;//timer
    public Mario(int w, int h) {//mario scaling
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

    public void addedToWorld(World world) {//for loop which adds hearts based off of the amount of lives
        if (getWorld() instanceof BackGround1 || getWorld() instanceof BackGround2) {
            for (int i = 0; i < lives; i++) {
                hearts[i] = new Heart(30, 30);
                getWorld().addObject(hearts[i], i*50+25, 25);
            }
        }
    }

    public void animation() {//for mario animaion
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
        animationCounter = animationCounter + 1;
        if (getWorld() instanceof BackGround2){//timer for level 2
            EndTime = System.currentTimeMillis();
            DurationInMillis = (int)(EndTime - StartTime);
            DurationInlvl2 = DurationInMillis / 1000;
            getWorld().showText("Time: " + DurationInlvl2, w/2,20);
        }
        int score = BackGround1.DurationInlvl1 + DurationInlvl2;//add the time from level 1 and level 2 to get the total time(aka score)
        if(animationCounter % 10 == 0)
        {
            animation();
        }
        if(isTouching(Barrel.class))//remove a barrel if collision occurs
        {
            removeTouching(Barrel.class);
            getWorld().removeObject(hearts[lives-1]);
            lives--;//remove a life if collision occurs
        }
        if(lives == 0) {//end game if out of lives
            if(running.isPlaying()){
                running.stop();
            }
            dead.play();
            getWorld().showText("GAME OVER", 750, 600);//show game over text
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
        if(isTouching(Key.class)) {//if mario has collected the key
            hasKey = true;
            getWorld().removeObject(getWorld().getObjects(Key.class).get(0));
        }
        if(isTouching(InCage.class) && hasKey == true) {//if mario is touching the cage and has the key
            win.play();
            Greenfoot.setWorld(new Finish());//change world
            String username = JOptionPane.showInputDialog("Enter a Username");//ask user for username
            File outputFile = new File("Leaderboard.txt");//create file called "leaderboard.txt"
            if(username.length()>15){//if the username is greater than 15 characters then trim it
                username = username.substring(0, 15);
            }
            if(username.length()<7){//if the username is less than 7 characters then add an extra tab(to keep scores nice an alligned)
                username = username+"\t";
            }
            if(username.equals("IAlwaysWin")){//easter egg/cheat code
                score = 0;
            }
            try {   
                FileWriter fileW = new FileWriter(outputFile, true);//creates file writer
                BufferedWriter buffW = new BufferedWriter(fileW);//creates buffered writer

                buffW.write("\n"+username+"\t"+score+" seconds");//buffered writer writes the username and score in a text file
                buffW.close();//closing the buffered writer
                Desktop desktop = Desktop.getDesktop();//gets desktop
                if(outputFile.exists()) desktop.open(outputFile);//automatically launches the leaderboard.txt file
            }
            catch(IOException e) {//catches input output errors
                e.printStackTrace();
                System.out.println("An Error Occured");
            }

            //Greenfoot.stop();
        }

        // MAY USE THIS FOR POWERUPS DOWN THE LINE
        //if(Greenfoot.isKeyDown("l")) {
        //    lives++;
        //    addedToWorld(getWorld());
        //}
    }
}