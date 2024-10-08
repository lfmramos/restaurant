package io.codeforall.bootcamp.gameobject.enemy;

import io.codeforall.bootcamp.gameobject.Destroyable;

/**
 * An enemy with an armour
 */
public class ArmouredEnemy extends Enemy implements Destroyable {

    private int armour;

    /**
     * Constructs an armoured enemy
     * @param health the initial health
     * @param armour the initial armour
     */
    public ArmouredEnemy(int health, int armour) {
        super(health);
        this.armour = armour;
    }

    /**
     * Damage hits armour, if armour is lost it proceeds to take damage
     * @see Enemy#hit(int)
     */
    @Override
    public void hit(int damage) {

        if (armour > damage) {
            armour -= damage;
            return;
        }

        damage -= armour;
        armour = 0;
        super.hit(damage);

    }
    @Override
    public boolean isDestroyed(){
        //Needs to rewrite this condition to stop the infinite loop
        //This method is replacing the isDead();
        //This method needs to get the maxDamage from BarrelType and compare with the currentDamage from this class, and turn True when currentDamage == 0;
        if(armour == 0 && getHealth() == 0){
        return true;
        } return false;
    }
}