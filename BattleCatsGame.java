import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

/**
 * BattleCatGame class will use constructors from unit, enemy, cat, InitialPictures, MainMenu classes in order to build the actual game
 * @Author's Eric L and Jason A
 */

public class BattleCatsGame extends Application{
    boolean gameOver = false;
    private AnimationTimer gameLoop;
    @Override
    public void start(Stage stage){
        
        //Panes - Eric
        Pane root = new Pane();
        Cat.gameRoot = root;
        
        
        //Background stuff - Eric
        Image background = new Image("Background.jpg");
        
        //entities - Jason
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Enemy> enemies = new ArrayList<>();
        
        //money - Jason
        int[] money = {0};
        Label moneyLabel = new Label("Money: $" + money[0]);
        moneyLabel.setLayoutX(350);
        moneyLabel.setLayoutY(50);
        
        //Normal Cat
        //Cat(String imageName, int health, int attack, double attackRate, int speed, int range, int spawnX, int spawnY, double divisor)
        // Cat normalCat = new Cat("NormalCat.png", 100, 8, 1.23, 10, 140, 400, 260, 1.2);
        // cats.add(normalCat);
        // Cat tankCat = new Cat("Tank.png", 200, 3, 1.23, 4, 140, 400, 260, 1.2);
        // cats.add(tankCat);
        // Cat godCat = new Cat("God.png", 1000, 250, 1.23, 3, 140, 400, 260, 1.2);
        // cats.add(godCat);
        
        //Doge
        Enemy doge = new Enemy("Doge.png", 90, 8, 1.57, 5, 110, 0, 260, 1.2);
        enemies.add(doge);
        
        /**
         *Snache Enemy
         * @Auhtor Eric Leyva Del Carmen
         */
        // Enemy snache = new Enemy("Snache.png", 150, 10, 2, 8, 110, 0, 260, 1.2);
        // enemies.add(snache);
        
        /**
         *Doge Tank Enemy
         * @Auhtor Eric Leyva Del Carmen
         */
        // Enemy dogeTank = new Enemy("Doge_Tank.png", 500, 100, 6, 3, 110, 0, 260, 1.2);
        // enemies.add(dogeTank);
        
        //Spawn Buttons - Eric
        Button spawnNormalCat = new Button("Normal Cat - $75");
        spawnNormalCat.setLayoutX(300);
        spawnNormalCat.setLayoutY(100);
        
        Button spawnTankCat = new Button("Tank Cat - $100");
        spawnTankCat.setLayoutX(160);
        spawnTankCat.setLayoutY(100);
        
        Button spawnGodCat = new Button("God Cat - $2000");
        spawnGodCat.setLayoutX(20);
        spawnGodCat.setLayoutY(100);
        
        Button spawnDoge = new Button("Spawn Doge");
        spawnDoge.setLayoutX(300);
        spawnDoge.setLayoutY(150);
        
        Button spawnSnache = new Button("Spawn Snache");
        spawnSnache.setLayoutX(170);
        spawnSnache.setLayoutY(150);
        
        Button spawnDogeTank = new Button("Spawn Doge Tank");
        spawnDogeTank.setLayoutX(20);
        spawnDogeTank.setLayoutY(150);
        

        //Defines layers for which image is in front of the other.
        root.setBackground(new Background(InitialPictures.backgroundSetup(background)));
        root.getChildren().add(InitialPictures.catBaseSetup());
        root.getChildren().add(InitialPictures.eBaseSetup());
        // root.getChildren().add(normalCat.getSprite());
        // root.getChildren().add(tankCat.getSprite());
        // root.getChildren().add(godCat.getSprite());
        root.getChildren().add(doge.getSprite());
        // root.getChildren().add(snache.getSprite());
        // root.getChildren().add(dogeTank.getSprite());
        root.getChildren().add(spawnNormalCat);
        root.getChildren().add(spawnGodCat);
        root.getChildren().add(spawnTankCat);
        root.getChildren().add(spawnDoge);
        root.getChildren().add(spawnSnache);
        root.getChildren().add(spawnDogeTank);
        root.getChildren().add(moneyLabel);
        
        //Button Setup for spawning cat's - Jason
        spawnNormalCat.setOnAction(e -> {
            if(money[0] >= 75){
                money[0] -= 75;
                Cat newCat = new Cat("NormalCat.png", 100, 8, 1.23, 10, 140, 400, 260, 1.2);
                cats.add(newCat);
                root.getChildren().add(newCat.getSprite());
                moneyLabel.setText("Money: $" + money[0]);
            }
        });
        //Button setup for spawning Tank Cat's -Eric
        spawnTankCat.setOnAction(e ->{
            if(money[0] >= 100){
                money[0] -= 100;
                Cat newCat1 = new Cat("Tank.png", 200, 3, 1.23, 4, 140, 400, 260, 1.2);
                cats.add(newCat1);
                root.getChildren().add(newCat1.getSprite());
                moneyLabel.setText("Money: $" + money[0]);
            }
        });
        //Button setup for spawning God Cat's - Eric
      spawnGodCat.setOnAction(e ->{
        if(money[0] >= 2000){
           money[0] -= 2000;
            Cat newCat2 = new Cat("God.png", 1000, 500, 1.23, 4, 140, 400, 260, 1.2);
            cats.add(newCat2);
            root.getChildren().add(newCat2.getSprite());
            moneyLabel.setText("Money: $" + money[0]);
            }
        });
        
    /**
     * Enemy spawn system, releases enemys at specfic times 
     * @Author Eric Leyva Del Carmen
     */
      Timeline waveSystem = new Timeline(
    // 5 seconds for doge - Eric
    new KeyFrame(Duration.seconds(5), e -> {
        Enemy doge1 = new Enemy("Doge.png", 90, 8, 1.57, 5, 110, 0, 260, 1.2);
        enemies.add(doge1);
        root.getChildren().add(doge1.getSprite());
    }),

    // 10 seconds for snache - Eric
    new KeyFrame(Duration.seconds(10), e -> {
        Enemy snache1 = new Enemy("Snache.png", 150, 10, 2, 8, 110, 0, 260, 1.2);
        enemies.add(snache1);
        root.getChildren().add(snache1.getSprite());
    }),

    // 20 seconds for Doge tank - Eric
    new KeyFrame(Duration.seconds(20), e -> {
        Enemy boss = new Enemy("Doge_Tank.png", 500, 300, 6, 3, 110, 0, 260, 1.2);
        enemies.add(boss);
        root.getChildren().add(boss.getSprite());
    })
    );

    waveSystem.play();
        //Spawn button setup for enemy's - Jason
        spawnDoge.setOnAction(e -> {
            Enemy newDoge = new Enemy("Doge.png", 90, 8, 1.57, 5, 110, 0, 260, 1.2);
            
            enemies.add(newDoge);
            root.getChildren().add(newDoge.getSprite());
        });
        //Spawn's snache of button press - Eric
        spawnSnache.setOnAction(e -> {
            Enemy newSnache = new Enemy("Snache.png", 90, 8, 1.57, 5, 110, 0, 260, 1.2);
            
            enemies.add(newSnache);
            root.getChildren().add(newSnache.getSprite());
        });
        //Spawn's Doge tank on button press - Eric
        spawnDogeTank.setOnAction(e -> {
            Enemy newDogeTank = new Enemy("Doge_Tank.png", 500, 100, 6, 3, 110, 0, 260, 1.2);
            
            enemies.add(newDogeTank);
            root.getChildren().add(newDogeTank.getSprite());
        });
        
        //Scene - Eric
        Scene scene = new Scene(root, 500, background.getHeight());
        stage.setScene(scene);
        stage.show();
        
        //Game loop --- dynamic part of the program ---
        gameLoop = new AnimationTimer(){
            
            @Override
            public void handle(long now){
                if(gameOver){
                    return;
                }
                
                //Cash Flow - Jason
                if(now % 10000000 < 16000000){
                    money[0] += 1;
                    moneyLabel.setText("Money: $" + money[0]);
                }
                
                //Move all enemies in the arrayList - Jason
                for (int i = 0; i < cats.size(); i++){
                    cats.get(i).move();
                    
                }
                for (int j = 0; j < enemies.size(); j++){
                    enemies.get(j).move();
                }
                
                //Check for range/distance between units and apply the boolean is moving if there is an enemy in range. - Jason
                for (int i = 0; i < cats.size(); i++){
                    boolean inRange = false;
                    for (int j = 0; j < enemies.size(); j++){
                        double catX = cats.get(i).getSprite().getX();
                        double enemyX = enemies.get(j).getSprite().getX();
                        if (enemyX <= catX){
                            double distance = catX - enemyX;
                            if (distance <= cats.get(i).getRange()){
                                inRange = true;
                                break;
                            }
                        }
                    }
                    cats.get(i).setMoving(!inRange);
                }
                for (int j = 0; j < enemies.size(); j++){
                    boolean inRange = false;
                    for (int i = 0; i < cats.size(); i++){
                        double catX = cats.get(i).getSprite().getX();
                        double enemyX = enemies.get(j).getSprite().getX();
                        if (catX >= enemyX){
                            double distance = catX - enemyX;
                            if (distance <= enemies.get(j).getRange()){
                                inRange = true;
                                break;
                            }
                        }
                    }
                    enemies.get(j).setMoving(!inRange);
                }
                
                //Attacking - Jason
                for (int i = 0; i < cats.size(); i++) {
                    for (int j = 0; j < enemies.size(); j++) {
                        double catX = cats.get(i).getSprite().getX();
                        double enemyX = enemies.get(j).getSprite().getX();
                        if (enemyX <= catX) {
                            double distance = catX - enemyX;
                            if (distance <= cats.get(i).getRange() && !cats.get(i).isMoving()) {
                                //attacks one enemy
                                cats.get(i).attack((Enemy) enemies.get(j), now);
                                break;
                            }
                        }
                    }
                }
                for (int j = 0; j < enemies.size(); j++) {
                    for (int i = 0; i < cats.size(); i++) {
                        double enemyX = enemies.get(j).getSprite().getX();
                        double catX = cats.get(i).getSprite().getX();
                        if (catX >= enemyX) {
                            double distance = catX - enemyX;
                            if (distance <= enemies.get(j).getRange() && !enemies.get(j).isMoving()) {
                                enemies.get(j).attack((Cat) cats.get(i), now);
                                break;
                            }
                        }
                    }
                }
                
                //Check for deaths - Jason
                for (int i = cats.size() - 1; i >= 0; i--){
                    if (cats.get(i).getHealth() <= 0){
                        root.getChildren().remove(cats.get(i).getSprite());
                        cats.remove(i);   
                    }
                }
                for (int j = enemies.size() - 1; j >= 0; j--){
                    if (enemies.get(j).getHealth() <= 0){
                        root.getChildren().remove(enemies.get(j).getSprite());
                        enemies.remove(j);
                    }
                }
                
                //game win/loose - Jason
                for (Cat c : cats) {
                    if (c.getSprite().getX() <= 10) {
                        gameOver = true;
                        stage.setScene(EndScreen.showEndScreen(stage, true));
                        gameLoop.stop();
                        return;
                    }
                }
                for (Enemy e : enemies) {
                    if (e.getSprite().getX() >= 400) {
                        gameOver = true;
                        stage.setScene(EndScreen.showEndScreen(stage, false));
                        gameLoop.stop();
                        return;
                    }
                }
            }
        };
        gameLoop.start();
    }
    /**
     * Starts the actual game
     * @author Eric
     */
    public static void main(String[] args) {
        MainMenu.launch(MainMenu.class, args);
    }
}
