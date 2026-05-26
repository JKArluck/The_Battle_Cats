import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BattleCatsGame extends Application{
    
    @Override
    public void start(Stage stage){
        //Background stuff
        Image background = new Image("Background.jpg");
        BackgroundImage bg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, 
            new BackgroundSize(100, 100, true, true, true, false));
            
        //CatBase
        Image base = new Image(getClass().getResourceAsStream("Catbase.png"));
        ImageView catBase = new ImageView(base);
        catBase.setX(420);
        catBase.setY(170);
        catBase.setFitWidth(base.getWidth()/1.8);
        catBase.setFitHeight(base.getHeight()/1.8);
        
        //EnemyBase
        Image eBase = new Image(getClass().getResourceAsStream("EnemyBase.png"));
        ImageView enemyBase = new ImageView(eBase);
        enemyBase.setX(10);
        enemyBase.setY(170);
        enemyBase.setFitWidth(eBase.getWidth()/1.8);
        enemyBase.setFitHeight(eBase.getHeight()/1.8);
        
        //Normal Cat
        //Cat(String imageName, int health, int attack, double attackRate, int speed, int range)
        Cat normalCat = new Cat("NormalCat.png", 100, 8, 1.23, 10, 140, 420, 290, 5.5, 5.5);
        
        //Doge
        Enemy doge = new Enemy("Doge.png", 90, 8, 1.57, 5, 110, 0, 260, 1.2, 1.2);
        
        
        Pane root = new Pane();
        root.setBackground(new Background(bg));
        root.getChildren().add(catBase);
        root.getChildren().add(enemyBase);
        root.getChildren().add(normalCat.getSprite());
        root.getChildren().add(doge.getSprite());
        
        Scene scene = new Scene(root, 500, background.getHeight());
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
