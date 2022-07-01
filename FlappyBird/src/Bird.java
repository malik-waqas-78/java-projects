import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Bird {
    // frames contain images that will animate the bird flying
    private BufferedImage[] birdFrames=new BufferedImage[4];
    //when user press space jumpY will be used to mke the bird go up
    private float jumpY=0;
    // location of bird at X-ais of
    private int x=150;
    // location of bird at Y-ais of
    private int y=100;
    // Width of bird image
    private int width=50;
    // Height of bird image
    private int height=50;
    // it will contain the index of the image to be shown to animate the bird flying
    private int birdFrameIndexToDraw=0;


    public Bird(){
        try {
            //loading images for bird's flying animation

            birdFrames[0]= ImageIO.read(new File("images/b1.png"));
            birdFrames[1]=ImageIO.read(new File("images/b2.png"));
            birdFrames[2]=ImageIO.read(new File("images/b3.png"));
            birdFrames[3]=ImageIO.read(new File("images/b4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Rectangle getRect(){
        // a rectangle that represent the location of the bird in the game
        // its easy to use rectangles for detecting collision of bird with the pipes or ground
        return new Rectangle(x,y,width,height);
    }


    //when ever user presses the space this function will be called
    // it will make bird move upwords
    public void jump(){
        if(jumpY>0){
            jumpY=0;
        }
        jumpY-=8;
    }

    // if the game is over repostion the bird to its origional position
    public void reset() {
        jumpY=0;
        x=150;
        y=100;
        width=50;
        height=50;
        birdFrameIndexToDraw=0;
    }

    public float getJumpY() {
        return jumpY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setJumpY(float jumpY) {
        this.jumpY = jumpY;
    }

    // if user do not press the space button the bird will keep falling until it hits ground

    public void fall(){
        jumpY+=0.8;
        y+=jumpY;
    }

    // this method checks whether bird has hit any of the pipes
    public boolean isHit(ArrayList<PipesPair> pipes) {
        for(PipesPair pipesPair:pipes){
            if(pipesPair.rectTopPipe.intersects(getRect())||pipesPair.rectBottomPipe.intersects(getRect())){
                x=pipesPair.rectTopPipe.x-width;
                return true;
            }
        }
        return false;
    }

    // this method checks if the bird has fallen to ground
    public boolean isHitGround() {
        if(y+this.height>=GameEngine.HEIGHT-GameEngine.LAND_HEIGHT){
            y = GameEngine.HEIGHT -this.height-GameEngine.LAND_HEIGHT;
            return true;
        }
        return false;
    }

    // this method check whether bird has successfully managed to pass through the pipes
  /*  public boolean doggedPipe(ArrayList<PipesPair> pipes) {
        for(PipesPair pipesPair:pipes){
            if ((this.x +this.width)> (pipesPair.rectTopPipe.x + (PipesPair.WIDTH / 2) +10) ||
                    (this.x + this.width) < (pipesPair.rectTopPipe.x + (PipesPair.WIDTH / 2)-10)) {
                    return true;
            }
        }
        return false;

    }*/


    // this method checks if the bird flew to close to the top of the screen
    public void flewToHigh() {
        if(this.y<0){
            jumpY=0;
        }
    }

    // this will return image of the bird to draw
    public BufferedImage getBirdToDraw(){
        if(birdFrameIndexToDraw>3){
            birdFrameIndexToDraw=0;
        }
        return birdFrames[birdFrameIndexToDraw++];

    }

    // if the bird is fallen or hit with a pipe this method will be called
    public BufferedImage getInjuredBird(){
        return birdFrames[1];
    }

}
