package com.example.finalproject.models.buildings;

abstract public class DefenseBuilding extends Building {
    private int attackPower;
    private int attackSpeed;
    public DefenseBuilding(int health , int attackPower , int attackSpeed , int x , int y) {
        super("defense", health , x , y);
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
