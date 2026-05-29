import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;

public class InitialPictures{
    
    /**
     * 
    *Using the background constuctor, it allows for the chosen background to be placed and unchanged
    * @Author Jason Arluck
    * @return BackgroundImage of the background
    */
    public static BackgroundImage backgroundSetup(Image background){
        BackgroundImage bg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, 
            new BackgroundSize(100, 100, true, true, true, false));
            return bg;
    }
    /**
    *The constuctor allows for the catbase to be set up and later be used for the enemy base to extend off of it
    * @Author Jason Arluck
    * @return ImageView object of the catbase picture
    */
    public static ImageView catBaseSetup(){
        Image base = new Image(InitialPictures.class.getResourceAsStream("Catbase.png"));
        ImageView catBase = new ImageView(base);
        catBase.setX(420);
        catBase.setY(170);
        catBase.setFitWidth(base.getWidth()/1.8);
        catBase.setFitHeight(base.getHeight()/1.8);
        return catBase;
    }
    /**
    * This method proccess the base png's and sets them up for both enemy and cat side. 
    * @Author Jason Arluck
    * @return ImageView object for the enemy base picture
    */ 
    
    public static ImageView eBaseSetup(){
        Image eBase = new Image(InitialPictures.class.getResourceAsStream("EnemyBase.png"));
        ImageView enemyBase = new ImageView(eBase);
        enemyBase.setX(10);
        enemyBase.setY(170);
        enemyBase.setFitWidth(eBase.getWidth()/1.8);
        enemyBase.setFitHeight(eBase.getHeight()/1.8);
        return enemyBase;
    }
}
