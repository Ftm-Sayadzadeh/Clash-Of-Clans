package com.example.finalproject.models.buildingsAndWarEquipment;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;

abstract public class Building {
    private String type;
    private int health;
    private ImageView img;
    private int defenseRadiusCircle;

    public Building(String type , int health , int defenseRadiusCircle , ImageView imageView) {
        this.type = type;
        this.health = health;
        img = imageView;
        this.defenseRadiusCircle = defenseRadiusCircle;
    }
    public boolean isAlive() {
        if(getHealth() < 0){
            getImg().setVisible(false);
        }
        return getHealth() >= 0;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public int getDefenseRadiusCircle() {
        return defenseRadiusCircle;
    }
    public void setDefenseRadiusCircle(int defenseRadiusCircle) {
        this.defenseRadiusCircle = defenseRadiusCircle;
    }
    public Bounds getBound(){return img.localToScene(img.getBoundsInLocal());}

}
