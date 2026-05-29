import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class Unit{
    
    private int health;
    private int attack;
    private double attackRate;
    private int speed;
    private int range;
    private boolean moving;
    private ImageView sprite;
    private long lastAttackTime;
    //direction will define the difference between enemy and cat. -1 = left movement. 1 = right movement
    private int direction;
    public static Pane gameRoot;
    /**
     *Unit constructor that initializes a unit with combat stats and a sprite
     * 
     * Initializes the unit's combats stats and sets up the sprite image at a specified scaling 
     * and starting position based on the programmers' input. Also sets the state of moving to true and the last attack time to 0.
     * 
     * @author Jason Arluck
     * @param imageName is the specified image that will be used to for the sprite.
     * @param health is a metric describing how long the unit will be able to survive when attacked.
     * @param attack is a metric describing how much damage the unit will be able to deal to opposing enemies defined in the Enemy class.
     * @param attackRate will describe the rate by which the unit will dish out the damage explained in the attack value.
     * @param speed will be a metric describing the rate at which the unit will move left accross the screen.
     * @param range will be a value defining (if an enemy is within range) when the unit will both stop moving and start attacking.
     * @param spawnX will be a value defining the x-coordinate by which the unit will appear and is customizable to account for differences in png images.
     * @param spawnY will be a value defining the y-coordinate by which the unit will appear and is customizable to account for differences in png images.
     * @param divisor will be a divisor used to account for the differences in png images by manipulating its on-screen size.
     * 
     */
    public Unit (String imageName, int health, int attack, double attackRate, int speed, int range,
                int spawnX, int spawnY, double divisor, int direction){
        this.health = health;
        this.attack = attack;
        this.attackRate = attackRate;
        this.speed = speed;
        this.range = range;
        this.direction = direction;
        lastAttackTime = 0;
        
        Image img = new Image(getClass().getResourceAsStream(imageName));
        sprite = new ImageView(img);
        sprite.setX(spawnX);
        sprite.setY(spawnY);
        sprite.setFitWidth(img.getWidth() / divisor);
        sprite.setFitHeight(img.getHeight() / divisor);
        
        moving = true;
    }
    
    /**
     * Sprite getter that retrieves sprite of the cat
     * 
     * After setting up a sprite in the constructor, this method will retrieve the sprite, including the
     * adjusted image and spawn location in any file outside of the Cat class.
     * 
     * @author Eric Leyva Del Carmen
     * @return the sprite of the unit
     */
    public ImageView getSprite(){
        return sprite;
    }
    /**
     * gets health when called
     * @Author Eric Leyva Del Carmen
     * @Returns health int
     */
    public int getHealth(){
        return health;
    }
    /**
     * Reduces health when damaged 
     * @Author Eric Leyva Del Carmen
     * @Precon Health is above 0
     */
    public void reduceHealth(int damage){
        health -= damage;
    }
    
    /**
     * Gets attack value
     * @Author Eric Leyva Del Carmen
     * @Returns attack int
     */
    public int getAttack(){
        return attack;
    }
    
    /**
     * Gets attack rate
     * @Author Eric Leyva Del Carmen 
     * @returns attackRate double
     */
    public double getAttackRate(){
        return attackRate;
    }
    /**
     * Gets the speed of unit
     * @Author Eric leyva Del Camren
     * @returns speed int
     */

    public int getSpeed(){
        return speed;
    }
    
    /**
     * Gets the range of unit
     * @Author Jason Arluck
     * @Returns range int
     */
    public int getRange(){
        return range;
    }
    
     /**
     * Checks if the unit is currently moving
     * @Author Jason Arluck
     * @returns moving Boolean 
     */
    public boolean isMoving(){
        return moving;
    }
    
     /**
     * Sets the unit too either moving or stopping depending on what the unit is doing
     * @Author Jason Arluck
     * @Precon unit must be alive 
     */
    public void setMoving(boolean moving){
        this.moving = moving;   
    }
    
     /**
     * Sets last Attack time 
     * @Author Jason Arluck
     * @Precon unit must be alive 
     */
    public void setLastAttackTime(long time){
        lastAttackTime = time;
    }
    
     /**
     * Gets the last attack time 
     * @Author Jason Arluck
     * @Return lastAttackTime long
     */
    public long getLastAttackTime(){
        return lastAttackTime;
    }
    
     /**
     * Gets the direction of the unit
     * @Author Eric Leyva Del Carm
     * @Return direction of unit
     */
    public int getDirection(){
        return direction;
    }
    
     /**
     * Moves unit sprite dpeending on where it moves and it's speed
     * @Author Jason Arluck
     * @Precon unit must be alive 
     */
    public void move(){
        if(moving){
            sprite.setX(sprite.getX() + (direction * speed * 0.1));
        }
    }
    
     /**
     * Checks if the unit can attack
     * @Author Eric Leyva Del Carmen
     * @Precon unit must be alive 
     */
    public boolean canAttack(long time){
        double seconds = (time - lastAttackTime) / 1000000000;
        return seconds >= attackRate;
    }
    
     /**
     * Shows the hit effect 
     * Uses explosion.jpg to show that damage is dealt
     * Removes explosion.jpg after 1 second
     * @Author Eric Leyva Del Carmen - Edits / bug fixes by Jason Arluck
     * @Precon unit must be alive 
     */
    protected void showHitEffect(Unit target) {
    if (gameRoot == null){
        return;
    }
    Image explosionImg = new Image("explosion.png");
    ImageView explosion = new ImageView(explosionImg);

    // Position explosion between attacker and target
    double x = (target.getSprite().getX());
    double y = (target.getSprite().getY());

    explosion.setX(x + 35);
    explosion.setY(y + 20);
    explosion.setFitWidth(60);
    explosion.setFitHeight(60);

    gameRoot.getChildren().add(explosion);

    // Remove after 1 second
    PauseTransition delay = new PauseTransition(Duration.seconds(1));
    delay.setOnFinished(e -> gameRoot.getChildren().remove(explosion));
    delay.play();
    }
}
