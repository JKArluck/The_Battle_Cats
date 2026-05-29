/**
 * Represents an enemy entity in the game.
 * Enemies will be identical to cats with exception that they will "oppose" the cats by spawning
 * on the left and moving towards the right, attacking cats along the way
 *
 * @author Eric Leyva Del Carmen
 * @version 1.0
 */
 
public class Enemy extends Unit{
    
    /**
     * Enemy constructor assings basic stats to enemey, these include health, attack, attackRate, speed, range, spawn point and divisor
     * @Author Eric Leyva Del Carmen
     * @Param Image must be a valid png, jpg or apng
     * @Param Health must be postive
     * @Param Attack must be postive 
     * @Param attackRate must be postive
     * @Param speed must be above 0
     * @Param range must be above 0
     * @Param range x and y must be postive 
     * @param divisor must be postive
     */
    public Enemy(String image, int health, int attack, double attackRate, int speed, int range, 
                int x, int y, double divisor) {
                    super(image, health, attack, attackRate, speed, range, x, y, divisor, 1);
    }
    
    /**
    * move Method checks if enemy is currently moving, if it is, the walking animation will play.
    * @Author Eric Leyva Del Carmen
    * @Param Enemy should be moving to the right and move by increasing x cordinate.
    */ 

    public void attack(Cat target, long time){
    if(canAttack(time)) {
        target.reduceHealth(super.getAttack());
        showHitEffect(target);
        super.setLastAttackTime(time);
        }
    }
}
