package com.codecool.gladiator.model.gladiators;

public abstract class Gladiator {

    private final String name;
    private final int baseHp;
    private final int baseSp;
    private final int baseDex;
    private int level;

    /**
     * Constructor for Gladiators
     *
     * @param name the gladiator's name
     * @param baseHp the gladiator's base Health Points
     * @param baseSp the gladiator's base Strength Points
     * @param baseDex the gladiator's base Dexterity Points
     * @param level the gladiator's starting Level
     */
    public Gladiator(String name, int baseHp, int baseSp, int baseDex, int level) {
        this.name = name;
        this.baseHp = baseHp;
        this.baseSp = baseSp;
        this.baseDex = baseDex;
        this.level = level;
    }

    /**
     * @return HP multiplier of the gladiator subclass
     */
    protected abstract Multiplier getHpMultiplier();

    /**
     * @return SP multiplier of the gladiator subclass
     */
    protected abstract Multiplier getSpMultiplier();

    /**
     * @return DEX multiplier of the gladiator subclass
     */
    protected abstract Multiplier getDexMultiplier();

    /**
     * @return Gladiator's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the full name of the gladiator
     * assembled by the subtype and the name
     * (e.g. "Brutal Brutus" or "Archer Leo")
     *
     * @return the full name
     */
    public String getFullName() {
        String gladiatorType = this.getClass().getSimpleName();
        String fullName = gladiatorType + " " + name;
        return fullName;
    }

    /**
     * Increments the level of the gladiator by 1.
     */

    public void levelUp(){
        this.level = level + 1;
    }

    /**
     * Returns the level of the gladiator.
     * @return the level
     */

    public int getLevel(){
        return level;
    }

    /**
     * Returns the current HP.
     * @return the current HP
     */

    public double getCurrentHp(){
        return baseHp * getHpMultiplier().getValue() * level;
    }

    /**
     * Returns the current SP.
     * @return the current SP
     */

    public double getCurrentSp(){
        return baseSp * getSpMultiplier().getValue() * level;
    }

    /**
     * Returns the current DEX.
     * @return the current DEX
     */

    public double getCurrentDex(){
        return baseDex * getDexMultiplier().getValue() * level;
    }

    /**
     * Returns true if the gladiator's health is above 0
     * and false if it's below 0.
     * @return true or false.
     */

    public boolean currentHealth(){
        double health = getCurrentHp();
        if(health > 0){
            return true;
        }else{
            return false;
        }
    }

    public enum Multiplier {
        Low(0.75),
        Medium(1.0),
        High(1.25);

        private final double value;

        Multiplier(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }


}
