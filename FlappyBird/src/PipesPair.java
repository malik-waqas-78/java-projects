import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PipesPair {


    // images of the pipe
    BufferedImage img;
    // pipe  that will be attached from top of the screen
    Rectangle rectTopPipe;
    // pipe  that will be attached from bottom of the screen
    Rectangle rectBottomPipe;
    // speed with which pipes will move from right to the left
    public static final int  PIPES_SPEED=4;
    //pipe width
    public static final int WIDTH=80;
    //pipe height
    private int height=0;
    // random number genarator
    public static Random rand=null;
    // represents the space between two pipes through which bird could pass
    static final int VERTICAL_SPACE_BETWEEN_PIPES =170;
    // space between one set of the pipes and the other coming fromm right side
    static final int HORIZONTAL_SPACE_BETWEEN_PIPES =400;
    // minimum height of a pipe as height is generated randomly so it could have been 0
    static final int MIN_HEIGHT=80;

    public PipesPair(int location){

        try {
            // loading pipe image
            img= ImageIO.read(new File("images/pipe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // initializing shared instance oof random number ganerator
        if(rand==null){
            rand=new Random();
        }
        //creating a pipe of random height
        height=rand.nextInt(GameEngine.HEIGHT / 2 - GameEngine.LAND_HEIGHT)+MIN_HEIGHT;

        // calculating space between two pipes
        int horizontalSpaceBetweenPipes=location+ HORIZONTAL_SPACE_BETWEEN_PIPES +WIDTH;
        // rectangle for pipe attached to top of screen
        rectTopPipe=new Rectangle(horizontalSpaceBetweenPipes,0,WIDTH,height);
        // rectangle for pipe attached to bottom of screen
        rectBottomPipe=new Rectangle(horizontalSpaceBetweenPipes,
                height+ VERTICAL_SPACE_BETWEEN_PIPES,WIDTH,
                GameEngine.HEIGHT-(height+ VERTICAL_SPACE_BETWEEN_PIPES)-GameEngine.LAND_HEIGHT);

    }

    // move pipes to left by pipes speed
    public void move(){
        rectTopPipe.x-=PIPES_SPEED;
        rectBottomPipe.x-=PIPES_SPEED;
    }

    // checking whether pipe has crossed whole screen from right to left
    public boolean isPipeOffScreen(){
        if(rectTopPipe.x+rectTopPipe.width<0){
            return true;
        }
        return false;
    }





}
