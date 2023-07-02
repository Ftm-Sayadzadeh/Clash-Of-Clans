package com.example.finalproject.models.buildingsAndWarEquipment;

import javafx.scene.image.ImageView;

abstract public class DefenseBuilding extends Building {
    private int attackPower;
    private int attackSpeed;
    private int attackRadiusCircle;
    public DefenseBuilding(int health , int attackPower , int attackSpeed , int defenseRadiusCircle , int attackRadiusCircle, ImageView imageView) {
        super("defense", health , defenseRadiusCircle , imageView);
        this.attackPower = attackPower;
        this.attackSpeed = attackSpeed;
        this.attackRadiusCircle = attackRadiusCircle;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getAttackRadiusCircle() {
        return attackRadiusCircle;
    }

    public void setAttackRadiusCircle(int attackRadiusCircle) {
        this.attackRadiusCircle = attackRadiusCircle;
    }
}
