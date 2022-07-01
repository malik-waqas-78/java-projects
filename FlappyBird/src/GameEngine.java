import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameEngine extends JPanel implements ActionListener, KeyListener {
    //Height of game screen
    public  static final int HEIGHT=720 ;
    //Width of game screen
    public  static final int WIDTH=1080;
    //Height of image that represents land
    public static final int LAND_HEIGHT =120;
    // delay after which Action Performed will be called again and again
    static final int DELAY=40;
    // Player Score
    int score=0;
    double tempScores=0.0;
    // Bird class object that represents bird
    Bird bird=new Bird();
    // pipes list
    ArrayList<PipesPair> pipes=new ArrayList<>();

    //images for the background and land
    BufferedImage land,background;
    private boolean isGameOver, isGameStarted = false;
    // timer to loop action performed after the specified delay
    Timer timer;

    public GameEngine() {
        try {
            //loading land image and background image
            land= ImageIO.read(new File("images/land.jpg"));
            background=ImageIO.read(new File("images/background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // listener for any key presses
        addKeyListener(this);
        //setting focus to this panel so that any input from keyboard will be received in the game
        setFocusable(true);
        // adding pipes of the screen to the pipes array list
        addPipes();
        // init timer
        //here delay is the time in milliseconds after which "this" which is Action Listner will be called in a loop
        // until we exit the game
        timer = new Timer(DELAY, this);
        // starting this loop
        timer.start();

    }


    // this redraws the panel that we will be seeing on the screen

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawing background and land

        g.drawImage(background, 0, 0, null);
        g.drawImage(land, 0, HEIGHT- LAND_HEIGHT, null);
        //drawing pipes
        for (PipesPair pipesPair : pipes) {
            g.drawImage(pipesPair.img, pipesPair.rectTopPipe.x,pipesPair.rectTopPipe.y, PipesPair.WIDTH, pipesPair.rectTopPipe.height, null);
            g.drawImage(pipesPair.img, pipesPair.rectBottomPipe.x,pipesPair.rectBottomPipe.y, PipesPair.WIDTH, pipesPair.rectBottomPipe.height, null);
        }
        // if game is not over than display bird flying animation
        if (isGameStarted && !isGameOver) {
            g.drawImage(bird.getBirdToDraw(), bird.getX(), bird.getY(), null);
        } else {
            // if game is over or it is not started yet display bird image in resting position
            g.drawImage(bird.getInjuredBird(), bird.getX(), bird.getY(), null);
        }
        // setting color and font for text to draw
        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 50));
        if (!isGameStarted) {// if game not started
            g.drawString("Press Space to Start or Jump", 100, 100);
        }
        if (isGameOver) {
            g.drawString("Press Space to Start or Jump", 100, 100);
            g.setColor(Color.red);
            g.drawString("Game Over", 400, HEIGHT / 2);
            g.setFont(new Font("Arial", 1, 100));
            g.setColor(Color.white);
            g.setFont(new Font("Arial", 1, 50));
            g.drawString(String.valueOf(score), 100, 50);
            g.setFont(new Font("Arial", 1, 20));
            g.drawString(String.valueOf("Highest Score :"+LoginForm.getLoggedInPerson().getHeightScore()), 300, 25);

        }
        if (!isGameOver) { // if game is not over show user scores
            g.setColor(Color.white);
            g.drawString(String.valueOf(score), 100, 50);
            g.setFont(new Font("Arial", 1, 20));
            g.drawString(String.valueOf("Highest Score :"+LoginForm.getLoggedInPerson().getHeightScore()), 300, 25);

        }

    }


    // the function that will be called in a loop with the help of timer
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (isGameStarted) {
            // moving pipes from right to left with their specified speed
            for(PipesPair pipesPair:pipes){
                pipesPair.move();
            }

            // creating a temporary list of current pipes
            ArrayList<PipesPair> tempPipes=new ArrayList<>(pipes);
            // looping through pipes
            for (PipesPair pipesPair:pipes) {
                //to check if any pipe has gone past screen on the left
                if (pipesPair.isPipeOffScreen()) {
                    // if so remove this pipe as we no longer need it
                    tempPipes.remove(pipesPair);
                    // add a new pip on the right side of the screen
                    // this pipe will be at a specific distance from the last pipe on the right side
                    // thats why passing the x position of the last pipe on the right side
                    tempPipes.add(new PipesPair(tempPipes.get(tempPipes.size()-1).rectTopPipe.x));
                }
            }
            // as we added new pipes to the temp pipes list so re initializing the global pipes list
            pipes=new ArrayList<>(tempPipes);
            // checking if bird has hited any pipe
            if(bird.isHit(pipes)){
                // if so game is over
                isGameOver=true;
            }
            //checking if bird has fallen down to the ground
            if(bird.isHitGround()){
                // if so game is over
                isGameOver=true;
            }else{
                // if not make the bird fal downwards a liitle bit
                bird.fall();
            }
            // if game is not over and bird has passed through a pipe up the score
//            if(!isGameOver&&bird.doggedPipe(pipes)){
//                score+=4;
//            }
            tempScores+=0.1;
            score= (int) tempScores;
            // iff bord has flown to close to the top of the screen than even if user presses space
            // don't let the bord go off the screen from top
            // instead set top o the screen as birds y-axis.
            bird.flewToHigh();

            if(score>LoginForm.getLoggedInPerson().getHeightScore()){
                LoginForm.getLoggedInPerson().setHeightScore(score);
            }

        }
        // repaint the game with the changed x and y locations
        repaint();
    }

    // add pipes to the pipes array
    public void addPipes(){
        // first pipe will start  past the right side of the screen
        pipes.add(new PipesPair(GameEngine.WIDTH-PipesPair.HORIZONTAL_SPACE_BETWEEN_PIPES));
        // adding two more piipes on the left of the pipe we added in the above line
        for(int i=0;i<2;i++)
            pipes.add(new PipesPair(pipes.get(pipes.size()-1).rectTopPipe.x));
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }



    // whenever user presses a key this function is called
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) { // checking if the presses key is space
            if(!isGameOver&&isGameStarted){
                // if game is  not over and game is started than jump
                bird.jump();
            }else if (isGameOver) {
                // if game is over rest all the variables to the origional position so we could restart the game
                pipes.clear();
                bird.reset();
                score = 0;
                addPipes();
                isGameOver = false;
            }else {
                isGameStarted = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }


}
