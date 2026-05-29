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


/**
 * Represents a cat entity in the game.
 * Cats will have dynamic properties based on their defined stats and a visual sprite.
 *
 * @author Jason Arluck
 * @version 1.0
 */
public class Cat extends Unit{
    /**
     * Creates cat class, assigning varibles such as health, attack, attackRate, speed, range, spawn location and divisor
     * @Author Jason Arluck
     * @param imageName is the name of the png that will be used for the cat
     * @param Healh must be postive
     * @param attack must be postive 
     * @param attackRate must be postive 
     * @param speed must be postive
     * @param range must be postive
     * @param spawnX and spawnY must be postive 
     * @param divisor must be more then 0
     */
    public Cat(String imageName, int health, int attack, double attackRate, 
                int speed, int range, int spawnX, int spawnY, double divisor){
        super(imageName, health, attack, attackRate, speed, range, spawnX, spawnY, divisor, -1);
    }
    /**
     *Attack method calls the reduceHealth method on a target if the attack rate allows it to do so.
     * It resets the last attack time after attacking.
     * @Author Jason Arluck
     * @param target is a Unit object. Could be a cat but will always be an enemy in the main game loop.
     * @param time variable definied in the main game loop that will regulate the attack rate.
     */
    public void attack(Unit target, long time){
        if(canAttack(time)){
            target.reduceHealth(super.getAttack());
            showHitEffect(target);
            super.setLastAttackTime(time);
        }
    }
}
