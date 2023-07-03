package com.example.finalproject.models.heroesAndWarEquipment;

import com.example.finalproject.models.buildingsAndWarEquipment.Building;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;

abstract public class Hero extends ImageView {
    private int health;
    private int power;
    private int speed;
    private int attackSpeed;
    public boolean isAttacking  = false;
    private float  progress;
    private int attackRadius;
    public Hero(){}
    public boolean isAlive() {
        if(getHealth() < 0){
            this.setVisible(false);
        }
        return getHealth() >= 0;
    }
    public abstract void attack(Building b);
    public abstract void die();

    public abstract void walk(Building building);

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

    public int getAttackRadius() {
        return attackRadius;
    }

    public void setAttackRadius(int attackRadius) {
        this.attackRadius = attackRadius;
    }
    public Bounds getBound(){
        return this.localToScene(this.getBoundsInLocal());
    }
}
