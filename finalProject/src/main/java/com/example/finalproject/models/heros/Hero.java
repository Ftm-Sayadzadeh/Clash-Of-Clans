package com.example.finalproject.models.heros;

import javafx.scene.image.ImageView;

abstract public class Hero extends ImageView {
    private int health;
    private int power;
    private int speed;
    public boolean isAttacking = false;
    private float  progress;
    public Hero(){}
    public boolean isAlive() {
        return getHealth() >= 0;
    }
    public abstract void attack(Hero hero);
    public abstract void die();

    public abstract void walk();

    public abstract Hero getCopy();

    //Getter and Setter ------------------------------------------------

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
