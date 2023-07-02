package com.example.finalproject.models.heroesAndWarEquipment;

import com.example.finalproject.models.buildingsAndWarEquipment.Building;
import javafx.scene.image.Image;

public class ArcherWoman extends Hero{
    private Arrow arrow = new Arrow();
    public static int sprite;
    private final String img_walk1 = this.getClass().getResource("/com/example/finalproject/img/Warrior_03__WALK_003.png").toString();
    private final String img_walk2 = this.getClass().getResource("/com/example/finalproject/img/Warrior_03__WALK_006.png").toString();
    private final String img_walk3 = this.getClass().getResource("/com/example/finalproject/img/Warrior_03__WALK_009.png").toString();
    private final String img_attack1 = this.getClass().getResource("/com/example/finalproject/img/Warrior_03__ATTACK_002.png").toString();
    private final String img_attack2 = this.getClass().getResource("/com/example/finalproject/img/Warrior_03__ATTACK_009.png").toString();
    private final String img_die1 = this.getClass().getResource("/com/example/finalproject/img/Warrior_03__DIE_005.png").toString();
    private final String img_die2 = this.getClass().getResource("/com/example/finalproject/img/Warrior_03__DIE_009.png").toString();
    public ArcherWoman(double x, double y) {

        super.setPower(5);
        super.setSpeed(4);
        super.setAttackSpeed(5);
        super.setHealth(30);
        super.setAttackRadius(80);

        setImage(new Image(img_walk1));

        setFitWidth(99);
        setFitHeight(65);

        setTranslateX(x);
        setTranslateY(y);
        arrow.setTranslateX(x);
        arrow.setTranslateY(y);
    }
    @Override
    public void attack(Building b) {
        sprite++;
        if (isAttacking) {
            if (sprite % 2 == 0) {
                this.setImage(new Image(img_attack1));
            }
            else if (sprite % 2 == 1){
                this.setImage(new Image(img_attack2));
            }
        }
        b.setHealth(b.getHealth() - this.getPower());
    }

    @Override
    public void die() {
        if(!this.isAlive()){
            setImage(new Image(img_die2));
        }
    }

    @Override
    public void walk(Building building) {
        double disCenterX = building.getBound().getCenterX() - this.getBound().getCenterX();
        double disCenterY = building.getBound().getCenterY() - this.getBound().getCenterY();
        double slope = Math.abs(disCenterY / disCenterX);
        sprite++;
        if (!isAttacking) {
            //moving in best line base on distance
            if(disCenterX > 0 && disCenterY > 0){
                setTranslateX(getTranslateX() + getSpeed());
                setTranslateY(getTranslateY() + (getSpeed()*slope));
            }
            else if(disCenterX < 0 && disCenterY < 0){
                setTranslateX(getTranslateX() - getSpeed());
                setTranslateY(getTranslateY() - (getSpeed()*slope));
            }
            else if(disCenterX > 0 && disCenterY < 0){
                setTranslateX(getTranslateX() + getSpeed());
                setTranslateY(getTranslateY() - (getSpeed()*slope));
            }
            else if(disCenterX < 0 && disCenterY > 0){
                setTranslateX(getTranslateX() - getSpeed());
                setTranslateY(getTranslateY() + (getSpeed()*slope));
            }
            //sprite images
            if (sprite % 3 == 0)
                this.setImage(new Image(img_walk1));
            else if (sprite % 3 == 1)
                this.setImage(new Image(img_walk2));
            else if (sprite % 3 == 2)
                this.setImage(new Image(img_walk3));
        }
    }

    public Arrow getArrow() {
        return arrow;
    }

    public void setArrow(Arrow arrow) {
        this.arrow = arrow;
    }
}
