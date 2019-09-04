import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YashrajSinghAnimated here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YashrajSinghAnimated extends Actor
{
    
   public String firstName;
   public String lastName;
   public int myRow;         // rows start in the front of class (1), and end in the back of class
   public int mySeat;        // seats are left to right, 1-8
   public boolean isActive;  // can you think of an algorithm that would allow you to use this
                             // variable to use keyboard entry for all the instance of a student
                             // that we will create?
   public boolean sitting;   // Is the student sitting or standing (default sitting)                         
   
   public String imgFile; 
   public String soundFile; //      firstName.toLowerCase()+lastName.toLowerCase()+".ext"; (.wav or .jpg)
   Classroom clas = (Classroom) getWorld();
   private boolean played = false;
   long timer = System.currentTimeMillis();
   
    /**
     * Act - do whatever the YashrajSinghAnimated wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        if (System.currentTimeMillis() - timer >= 7000)
        {
            timer = 0;
            getWorld().removeObject(this);
        } else {
            animation();
        }    
    }
    
    private void animation() {
        if (played == false) {
           Greenfoot.playSound("kilgoretrout.wav");
           played = true;
        }
        Greenfoot.delay(1);
        turn(25);
    }
    
    public YashrajSinghAnimated() {
        firstName="Yash Raj";
        lastName="Singh";
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        imgFile= "kilgoretrout-standing.jpg";//firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        soundFile= "kilgoretrout.wav"; //firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(imgFile);
    }
}
