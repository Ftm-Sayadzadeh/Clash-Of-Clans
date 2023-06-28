package com.example.finalproject.models.buildings;

import javafx.scene.image.ImageView;

abstract public class DefenseBuilding extends Building {
    private int attackPower;
    private int attackSpeed;
    public DefenseBuilding(int health , int attackPower , int attackSpeed , ImageView imageView) {
        super("defense", health , imageView);
        this.attackPower = attackPower;
        this.attackSpeed = attackSpeed;
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
}
