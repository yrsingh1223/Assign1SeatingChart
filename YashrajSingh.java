import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The YashrajSingh class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class YashrajSingh extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the YashrajSingh class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public YashrajSingh(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile= "kilgoretrout.jpg"; //f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile= "kilgoretrout-standing.jpg"; //firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile= "kilgoretrout.wav"; //f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public YashrajSingh() {
        firstName="Yash Raj";
        lastName="Singh";
        myRow=3;
        mySeat=7;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile= "kilgoretrout.jpg";//firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile= "kilgoretrout-standing.jpg"; //firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile= "kilgoretrout.wav"; //firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the YashrajSingh actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to time travel!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                animation();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            }
            else {
                answerQuestion();
                sitDown();
            }
                    
        }
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    public void answerQuestion(){
        String q = Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            q=Greenfoot.ask("2D arrays, recursion, and merge sort... May I sit down?");
        
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
        
    }
    /**
     * This is a local method specific to the YashrajSingh class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void animation(){
        
        Greenfoot.delay(10);
       
        int[][] positions = {
          {1, 1},  {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7},
          {2, 1},  {2, 2}, {2, 3}, {2, 4}, {2, 5}, {2, 6}, {2, 7},
          {3, 1},  {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6}, {3, 7},
          {4, 1},  {4, 2}, {4, 3}, {4, 4}, {4, 5}, {4, 6}, {4, 7},

        };
        
        ArrayList<YashrajSinghAnimated> pics = new ArrayList<YashrajSinghAnimated>();
        
        for (int i = 0; i < positions.length; i++) {
            YashrajSinghAnimated pic = new YashrajSinghAnimated();
            getWorld().addObject(pic, positions[i][1], positions[i][0]);
        }
        
        // getWorld().removeObjects(getWorld().getObjects(YashrajSinghAnimated.class));
        timer(7);
        
        Greenfoot.delay(20);
        returnToSeat();
        setRotation(0);
    }
    
    public void myHobby(String s) {
         System.out.println(s);
    }
    
    int i=0;
    public void timer(int time)
    {
            i++;
            if(i==time) {
                getWorld().removeObjects(getWorld().getObjects(YashrajSinghAnimated.class));
                System.out.println("LKDSFJLDS");
            }
            if(i==time+1)
                i=0;
    }

}
