package com.example.finalproject.models.heros;

import javafx.scene.image.Image;

public class Knight extends Hero{
    public static int sprite;
    private final String img_walk1 = this.getClass().getResource("/com/example/finalproject/img/Knight_01__Walk_003.png").toString();
    private final String img_walk2 = this.getClass().getResource("/com/example/finalproject/img/Knight_01__WALK_006.png").toString();
    private final String img_walk3 = this.getClass().getResource("/com/example/finalproject/img/Knight_01__WALK_009.png").toString();
    private final String img_attack1 = this.getClass().getResource("/com/example/finalproject/img/Knight_01__ATTACK_003.png").toString();
    private final String img_attack2 = this.getClass().getResource("/com/example/finalproject/img/Knight_01__ATTACK_009.png").toString();
    private final String img_die1 = this.getClass().getResource("/com/example/finalproject/img/Knight_01__DIE_009.png").toString();
    private final String img_die2 = this.getClass().getResource("/com/example/finalproject/img/Knight_01__DIE_009.png").toString();
    public Knight(double x, double y) {

        super.setPower(2);
        super.setSpeed(3);
        super.setHealth(50);

        setImage(new Image(img_walk1));

        setFitWidth(163);
        setFitHeight(92);

        setTranslateX(x);
        setTranslateY(y);
    }
    @Override
    public void attack(Hero hero) {
        if (isAttacking) {
            if (sprite % 2 == 0)
                this.setImage(new Image(img_attack1));
            else if (sprite % 2 == 1)
                this.setImage(new Image(img_attack2));
        }
    }

    @Override
    public void die() {
        if(!this.isAlive()){
            setImage(new Image(img_die2));
        }
    }

    @Override
    public void walk() {
        if (!isAttacking) {
            if (sprite % 3 == 0)
                this.setImage(new Image(img_walk1));
            else if (sprite % 3 == 1)
                this.setImage(new Image(img_walk2));
            else if (sprite % 3 == 2)
                this.setImage(new Image(img_walk3));
        }
    }

    @Override
    public Hero getCopy() {
        return new Knight(getTranslateX() , getTranslateY());
    }
}
