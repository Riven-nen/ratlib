package com.example.game;

public class Entity implements Attack {
    private int hp;
    private int strength;
    private int agility;
    private int intelligence;
    private int defense;

    private int level = 1;

    
    /**
     * Returns the level of the entity.
     * @return the level of the entity
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level of the entity.
     * @param level the new level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Increases the level of the entity by 1.
     */
    public void addLevel() {
        this.level++;
    }

    /**
     * Decreases the level of the entity by the given amount.
     * @param level the amount of levels to remove
     */
    public void decreaseLevel(int level) {
        this.level -= level;
    }

    /**
     * Returns the hitpoints of the entity.
     * @return the hitpoints of the entity
     */
    public int getHp() {
        return hp;
    }

    /**
     * Sets the hitpoints of the entity.
     * @param hp the hitpoints to set
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Increases the hitpoints of the entity by the given amount.
     * @param hp the amount of hitpoints to add
     */
    public void addHp(int hp) {
        this.hp += hp;
    }

    /**
     * Decreases the hitpoints of the entity by the given amount.
     * @param hp the amount of hitpoints to remove
     */
    public void decreaseHp(int hp) {
        this.hp -= hp;
    }

    /**
     * Returns the strength of the entity.
     * @return the strength of the entity
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets the strength of the entity.
     * @param strength the strength to set
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Increases the strength of the entity by the given amount.
     * @param strength the amount of strength to add
     */
    public void addStrength(int strength) {
        this.strength += strength;
    }

    /**
     * Decreases the strength of the entity by the given amount.
     * @param strength the amount of strength to remove
     */
    public void decreaseStrength(int strength) {
        this.strength -= strength;
    }

    /**
     * Returns the agility of the entity.
     * @return the agility of the entity
     */
    public int getAgility() {
        return agility;
    }

    /**
     * Sets the agility of the entity.
     * @param agility the agility to set
     */
    public void setAgility(int agility) {
        this.agility = agility;
    }

    /**
     * Increases the agility of the entity by the given amount.
     * @param agility the amount of agility to add
     */
    public void addAgility(int agility) {
        this.agility += agility;
    }

    /**
     * Decreases the agility of the entity by the given amount.
     * @param agility the amount of agility to remove
     */
    public void decreaseAgility(int agility) {
        this.agility -= agility;
    }

    /**
     * Returns the intelligence of the entity.
     * @return the intelligence of the entity
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Sets the intelligence of the entity.
     * @param intelligence the intelligence to set
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Increases the intelligence of the entity by the given amount.
     * @param intelligence the amount of intelligence to add
     */
    public void addIntelligence(int intelligence) {
        this.intelligence += intelligence;
    }

    /**
     * Decreases the intelligence of the entity by the given amount.
     * @param intelligence the amount of intelligence to remove
     */
    public void decreaseIntelligence(int intelligence) {
        this.intelligence -= intelligence;
    }

    /**
     * Sets the defense of the entity.
     * @param defense the defense to set
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Returns the defense of the entity.
     * @return the defense of the entity
     */
    public int getDefense () {
        return this.defense;
    }

    /**
     * Increases the defense of the entity by the given amount.
     * @param defense the amount of defense to add
     */
    public void addDefense(int defense) {
        this.defense += defense;
    }

    /**
     * Decreases the defense of the entity by the given amount.
     * @param defense the amount of defense to remove
     */
    public void decreaseDefense(int defense) {
        this.defense -= defense;
    }


    /**
     * Returns the amount of damage that the entity will take after its defense is
     * subtracted from the given amount.
     *
     * If the defense is greater than the given amount, the method returns 1 to
     * indicate that the entity will take at least 1 damage.
     *
     * @param damage the amount of damage to block
     * @return the amount of damage that the entity will take
     */
    public int passiveBlock(int damage) {
        int defendedDamage = damage - defense;

        if (defendedDamage <= 0) {
            return 1;
        } else {
            return defendedDamage;
        }
    }

    /**
     * Takes damage from the given amount.
     * The damage is modified by passiveBlock() before being applied to the entity's HP.
     * @param amount the amount of damage to take
     */
    public void takeDamage(int amount) {
        this.decreaseHp(passiveBlock(amount));;
    }

    /**
     * Attacks the given entity with the entity's strength.
     * The entity that is attacked will take damage equal to this entity's strength.
     * @param entity the entity to attack
     */
    public void attack(Entity entity) {
        entity.takeDamage(this.strength);
    }
}
