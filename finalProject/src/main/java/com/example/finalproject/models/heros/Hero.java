package com.example.finalproject.models.heros;

import com.example.finalproject.models.buildings.Building;
import javafx.scene.image.ImageView;

abstract public class Hero extends ImageView {
    private int health;
    private int power;
    private int speed;
    private int attackSpeed;
    public boolean isAttacking = false;
    private float  progress;
    public Hero(){}
    public boolean isAlive() {
        return getHealth() >= 0;
    }
    public abstract void attack(Building b);
    public abstract void die();

    public abstract void walk();

    public abstract Hero getCopy();
    public boolean detectCollision(Building h) {
        return this.getBoundsInParent().intersects(h.getImg().getBoundsInParent());
    }

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

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}
